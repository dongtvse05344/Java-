/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedetail;

/**
 *
 * @author xhunt
 */
public class EmployeeDetail {
    public String empCode;
    public String name;
    public String address;

    public EmployeeDetail(String empCode, String name, String address) {
        this.empCode = empCode;
        this.name = name;
        this.address = address;
    }
    
    public String toString(){
        return "\nEmployee Code : " +empCode +"\nName : "+name + "\nAddress : "+ address;
    }
}
