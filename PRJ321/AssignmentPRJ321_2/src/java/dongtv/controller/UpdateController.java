/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import static dongtv.controller.Utils.*;
import dongtv.dao.RestaurantDAO;
import dongtv.dto.ErrorObj;
import dongtv.dto.RestaurantDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xhunt
 */
public class UpdateController extends HttpServlet {

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
        String url = UPDATE_VIEW;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        ErrorObj error = new ErrorObj();
        boolean valid = true;
        RestaurantDTO dto = new RestaurantDTO(id, name, address, district);
        try {

            if (name.length() == 0) {
                error.setRestaurantName("name can not be blank");
                valid = false;
            }
            if (address.length() == 0) {
                error.setAddress("address can not be blank");
                valid = false;
            }
            if (district.length() == 0) {
                error.setDistrict("district can not be blank");
                valid = false;
            }

            if (!valid) {
                request.setAttribute("DTO", dto);
                request.setAttribute("ERROR", error);
            } else {
                RestaurantDAO dao = new RestaurantDAO();
                boolean res = dao.update(dto);
                if (res) {
                    request.setAttribute("MESS", "Update success");
                    url = SEARCH;
                } else {
                    error.setRestaurantID("Update failed");
                    request.setAttribute("DTO", dto);
                    request.setAttribute("ERROR", error);
                }
            }
        } catch (Exception e) {
            log("ERROR at UpdateController " + e.getMessage());
            request.setAttribute("ERROR", e.getMessage());
            url = ERROR_VIEW;
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
