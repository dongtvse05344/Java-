/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.PartialController;

import static dongtv.PartialController.Utils.*;
import dongtv.bean.DongtvBean;
import dongtv.dto.EventDTO;
import dongtv.dto.Page;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xhunt
 */
public class getEvent extends HttpServlet {

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
        String url = "";
        try {
            DongtvBean bean = new DongtvBean();
            int index = 1;
            String temp = request.getParameter("index");
            int _case = Integer.parseInt(request.getParameter("_case"));
            if (temp != null) {
                index = Integer.parseInt(temp);
            }
            switch (_case) {
                case 1:
                    List<EventDTO> list = bean.getEventFuture();
                    Page<EventDTO> pageFuture = new Page<>(list, index);
                    request.setAttribute("LISTFUTURE", pageFuture);
                    url = EVENT_FUTURE;
                    break;
                case 2:
                    List<EventDTO> listNow = bean.getEventNow();
                    Page<EventDTO> pageNow = new Page<>(listNow,index,2);
                    request.setAttribute("LISTNOW", pageNow);
                    url = EVENT_NOW;
                    break;
                case 3:
                    List<EventDTO> listPast = bean.getEventPast();
                    Page<EventDTO> pagePast = new Page<>(listPast,index,2);
                    request.setAttribute("LISTPAST", pagePast);
                    url = EVENT_PAST;
                    break;

            }

        } catch (Exception e) {
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
