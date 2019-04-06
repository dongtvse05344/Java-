/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.bean.DongtvBean;
import static dongtv.controller.Utils.*;
import static dongtv.dao.Utils.USER;
import dongtv.dto.AccountDTO;
import dongtv.dto.ErrorObj;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xhunt
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = REGISTERVIEW;
        HttpSession session = request.getSession();
        try {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            String email = request.getParameter("email");

            boolean valid = true;
            ErrorObj error = new ErrorObj();

            if (name.length() == 0) {
                valid = false;
                error.setName("Name can not be blank");
            }

            if (!username.matches("^[A-Z]{2}[0-9]{5}$")) {
                valid = false;
                error.setUsername("Username is invalid");
            }

            if (!password.matches(".{6,}")) {
                valid = false;
                error.setPassword("Password is invalid");
            }
            if (!confirmPassword.equals(password)) {
                valid = false;
                error.setConfirmPassword("Confirm password not matched");
            }
            if (email.length() == 0) {
                valid = false;
                error.setEmail("Email can not be blank");
            }

            AccountDTO dto = new AccountDTO(username, password, name, email, USER);

            if (!valid) {
                request.setAttribute("ERROR", error);
                request.setAttribute("DTO", dto);
            } else {
                DongtvBean bean = new DongtvBean();
                bean.setAcountDTO(dto);
                if (bean.createAccount()) {
                    session.setAttribute("ROLE", USER);
                    session.setAttribute("USERNAME", username);
                    url = HOME;
                } else {
                    error.setMess("Create Account Failed, Please user another infomation");
                    error.setUsername("Username already existed");
                    request.setAttribute("ERROR", error);
                    request.setAttribute("DTO", dto);
                }
            }

        } catch (Exception e) {
            log("ERROR at RegisterController " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
