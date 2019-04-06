/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.bean.DongtvBean;
import static dongtv.controller.Utils.*;
import dongtv.dto.EventDTO;
import dongtv.dto.RankDTO;
import java.io.IOException;
import java.sql.Timestamp;
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
public class Detail extends HttpServlet {

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
        String url = DETAILVIEW;
        try {
            String temp = request.getParameter("eventId");
            HttpSession session = request.getSession();
            temp = temp != null? temp : (String) session.getAttribute("EventId");
            if (temp == null || temp.length() == 0) {
                url = HOME;
            } else {
                int eventId = Integer.parseInt(temp);
                DongtvBean bean = new DongtvBean();
                bean.setEventId(eventId);
                EventDTO dto = bean.getEvent();
                if (dto == null) {
                    url = HOME;
                }
                request.setAttribute("DTO", dto);
                String dateStarted = objSDF.format(dto.getDateStarted());
                request.setAttribute("START", dateStarted);

                String username = (String) session.getAttribute("USERNAME");
                if (username != null) {
                    bean.setUsername(username);
                    bean.setEventId(eventId);
                    bean.getRank();
                    RankDTO rankDto = bean.getRankDTO();
                    if (rankDto != null) {
                        request.setAttribute("POINT", 0);
                    }
                }
                
                Timestamp now = new Timestamp(new java.util.Date().getTime());
                if(now.compareTo(dto.getDateStarted()) >0)
                {
                    bean.setEventId(eventId);
                    bean.searchRanksByEventId();
                    List<RankDTO> ranks = bean.getRanks();
                    for (RankDTO rank : ranks) {
                        bean.setUsername(rank.getUsername());
                        rank.setName(bean.getNameAccount());
                    }
                    request.setAttribute("RANKS", ranks);
                    
                    if(now.compareTo(dto.getDateEnded()) > 0)
                    {
                        request.setAttribute("EXPIRED", true);
                    }
                    
                    url= DETAILRANKING;
                }
            }
        } catch (Exception e) {
            log("ERROR at Detail " + e.getMessage());
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
