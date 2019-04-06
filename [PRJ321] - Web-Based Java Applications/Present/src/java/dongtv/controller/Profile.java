/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.bean.DongtvBean;
import static dongtv.controller.Utils.*;
import static dongtv.controller.manager.Utils.HOME_MANAGER;
import static dongtv.dao.Utils.*;
import dongtv.dto.AccountDTO;
import dongtv.dto.RankDTO;
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
public class Profile extends HttpServlet {

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
        request.setAttribute("ACTION", "LoginController");
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("USERNAME");
            String role = (String)session.getAttribute("ROLE");
            if(role.equals(ADMIN)){
                url = ADMIN_HOME;
            } 
            else if(role.equals(USER))
            {
                url = PROFILE_VIEW;
                DongtvBean bean = new DongtvBean();
                bean.setUsername(username);
                AccountDTO account = bean.getAcount();
                request.setAttribute("ACCOUNT", account);
                List<RankDTO> ranks =bean.searchRankByUsername();
                for (RankDTO rank : ranks) {
                    bean.setEventId(rank.getEventId());
                    rank.setEvent(bean.getEvent());
                    bean.setPrizeId(rank.getPrizeId());
                    rank.setPrize(bean.getPrize());
                }
                request.setAttribute("RANKS", ranks);
                
            } else if(role.equals(MANAGER))
            {
                url = HOME_MANAGER;
            }
        } catch (Exception e) {
            log("ERROR at Profile "+e.getMessage());
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
