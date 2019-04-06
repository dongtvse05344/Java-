/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.bean.DongtvBean;
import static dongtv.controller.Utils.*;
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
public class Home extends HttpServlet {

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
        String url = HOMEVIEW;
        try {
            
            DongtvBean bean = new DongtvBean();
            List<EventDTO> list = bean.getEventFuture();
            List<EventDTO> listNow = bean.getEventNow();
            List<EventDTO> listPast = bean.getEventPast();
            
            Page<EventDTO> pagePast = new Page<>(listPast,1,2);
            Page<EventDTO> pageNow = new Page<>(listNow,1,2);
            Page<EventDTO> pageFuture = new Page<>(list);
            
            request.setAttribute("LISTFUTURE", pageFuture);
            request.setAttribute("LISTPAST", pagePast);
            request.setAttribute("LISTNOW", pageNow);
        } catch (Exception e) {
            log("ERROR at Home "  +e.getMessage());
            url = ERROR;
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
