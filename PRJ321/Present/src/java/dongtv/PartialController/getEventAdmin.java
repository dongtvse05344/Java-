/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.PartialController;

import dongtv.bean.DongtvBean;
import dongtv.dto.EventDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xhunt
 */
public class getEventAdmin extends HttpServlet {

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
        String url = "PartialView/EventAdmin.jsp";
        try {
            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("ROLE");
            
            
            if (role.equals("Admin")) {
                String temp = request.getParameter("option");
                int option = Integer.parseInt(temp);
                DongtvBean bean = new DongtvBean();
                List<EventDTO> list =null;
                switch(option)
                {
                    case 1 : list = bean.getEventFuture(); break;
                    case 2 : list = bean.getEventNow(); break;
                    case 3 : list = bean.getEventPast(); break;
                    case 4 : list = bean.getEventAll(); break;
                    case 5 : String nameSearch = request.getParameter("nameSearch");
                            bean.setEvenName(nameSearch);
                            list = bean.searhEvents(); break;
                }
                
                request.setAttribute("LISTEVENT", list);
            }
        } catch (Exception e) {
            log("ERROR at adminController " + e.getMessage());
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
