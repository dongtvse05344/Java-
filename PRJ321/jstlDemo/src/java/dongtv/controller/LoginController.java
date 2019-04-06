/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import static dongtv.controller.Utils.*;
import dongtv.dao.Bean;
import dongtv.dto.ErrorObj;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author linh
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final static String INVALID = "index.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String url = INVALID;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            boolean valid = true;
            ErrorObj error = new ErrorObj();
            if(username.length()==0)
            {
                valid = false;
                error.setUsernameError("username can not be blank");
            }
            if(password.length() ==0)
            {
                valid =false;
                error.setPasswordError("password can not be blank");
            }
            if(valid == false)
            {
                request.setAttribute("INVALID", error);
            }
            else
            {
                Bean bean = new Bean();
                bean.setUsername(username);
                bean.setPassword(password);
                String role = bean.checkLogin();
                
                if(role.equals("failed")) 
                {
                    request.setAttribute("ERROR", "Invalid Username or Password");
                }
                else
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", username);
                    if(role.equals("admin")) url = ADMIN;
                    else if(role.equals("user")) url = USER;
                    else
                    {
                        request.setAttribute("ERROR", "Your role is invalid");
                    }
                }
            }
        } catch (Exception e) {
            log("ERROR at LoginController "+e.getMessage() );
            e.printStackTrace();
        }
        finally{
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
