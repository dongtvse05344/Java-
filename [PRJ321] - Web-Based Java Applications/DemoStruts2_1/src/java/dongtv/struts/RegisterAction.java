/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author xhunt
 */
public class RegisterAction extends ActionSupport {

    private String username, password, confirm, phoneNo, emailId;

    public String getUsername() {
        return username;
    }

    @Validations(
            requiredStrings = {
                @RequiredStringValidator(type = ValidatorType.FIELD,
                        message = "Username can not be blank !!")
            },
            stringLengthFields = {
                @StringLengthFieldValidator(type = ValidatorType.FIELD,
                        minLength = "6",
                        maxLength = "20", message = "Username must be 6 to 20 chars !")
            }
    )
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Password can not be blank !!")
    @StringLengthFieldValidator(type = ValidatorType.FIELD,
            minLength = "6",
            maxLength = "20", message = "Password must be 6 to 20 chars !")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    @FieldExpressionValidator(expression = "confirm==password", message = "Confirm must match Password")
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @RegexFieldValidator(type = ValidatorType.FIELD, message = "Phone number is invalid",
            regex = "\\d{3}-\\d{7}")
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    @EmailValidator(type = ValidatorType.FIELD, message = "Email is invalid")
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public RegisterAction() {
    }

    public String execute() throws Exception {
        System.out.println("khong muon thuc thi");
        return SUCCESS;
    }

    @Action(value = "/register",
            exceptionMappings = {
                @ExceptionMapping(exception = "java.sql.SQLException", result = "input")
            },
            results = {
                @Result(name = "success", location = "/index.jsp") ,
                @Result(name = "input", location = "/index.jsp")
            })
    public String insert() throws Exception {
        boolean check = false;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String user = "sa";
        String pass = "";
        String conString = "jdbc:sqlserver://localhost:1456;databaseName=SinhVien";
        String sql = "INSERT into Registrations values(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(conString, user, pass);
                PreparedStatement preStm = conn.prepareStatement(sql)) {

            preStm.setString(1, username);
            preStm.setString(2, password);
            preStm.setString(3, emailId);
            preStm.setString(4, "user");
            check = preStm.executeUpdate() > 0;
            if (check) {
                return SUCCESS;
            }
        }
        return "failed";
    }

}
