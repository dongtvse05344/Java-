 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import static dongtv.controller.Utils.HOME;
import static dongtv.controller.admin.Utils.*;
import static dongtv.controller.manager.Utils.HOME_MANAGER;
import dongtv.dao.AccountDAO;
import static dongtv.dao.Utils.*;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN;
        HttpSession session = request.getSession();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            ErrorObj error = new ErrorObj();
            boolean valid = true;
            if(!username.matches("^[A-Z]{2}[0-9]{4,10}$"))
            {
                valid = false;
                error.setUsername("Username is invalid");
            }
            
            if(!password.matches(".{6,}"))
            {
                valid = false;
                error.setPassword("Password is invalid");
            }
            if(!valid)
            {
                request.setAttribute("error", error);
            }
            else
            {
                AccountDAO dao = new AccountDAO();
                String role = dao.checkLogin(username, password);
                if(role.equals(ADMIN))
                {
                    session.setAttribute("ROLE", ADMIN);
                    session.setAttribute("USERNAME", username);
                    url = ADMIN_HOME;
                }
                else if(role.equals(USER))
                {
                    session.setAttribute("ROLE", USER);
                    session.setAttribute("USERNAME", username);
                    url = HOME;
                }
                else if(role.equals(MANAGER))
                {
                    session.setAttribute("ROLE", MANAGER);
                    session.setAttribute("USERNAME", username);
                    url = HOME_MANAGER;
                }
                else
                {
                    error.setMess("Login failed");
                    request.setAttribute("error", error);
                }
            }
        } catch (Exception e) {
            log("ERROR at LoginController " +e.getMessage() );
        }
        finally
        {
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
