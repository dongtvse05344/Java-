/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.FlightDAO;
import dongtv.dao.Fly_PlanDAO;
import dongtv.dto.ErrorObj;
import dongtv.dto.Fly_PlanDTO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xhunt
 */
public class InsertFlyController extends HttpServlet {

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
        String url = "setFly.jsp";
        FlightDAO fDao = new FlightDAO();
        try {
            String flightCode = request.getParameter("flightCode");
            String dateTemp = request.getParameter("dateFly");
            int day = 0, month = 0, year = 0;
            boolean valid = true;
            ErrorObj error = new ErrorObj();
            try {
                String[] temp = dateTemp.split("-");
                day = Integer.parseInt(temp[0]);
                month = Integer.parseInt(temp[1]);
                year = Integer.parseInt(temp[2]);
            } catch (Exception e) {
                error.setDateFlyError("Date must be format like dd-mm-yyyy");
                valid = false;
            }
            java.sql.Date date = new Date(year - 1900, month - 1, day);
            int customerNo = 0;
            try {
                customerNo = Integer.parseInt(request.getParameter("customerNo"));
            } catch (Exception e) {
                valid = false;
                error.setCustomerNoError("Customer number must be a number");
            }
            int chairNo = Integer.parseInt(request.getParameter("chairNo"));
            if (customerNo < 0 || customerNo > chairNo) {
                valid = false;
                error.setCustomerNoError("Customer number must be 0 - " + chairNo);
            }
            if (!valid) {
                request.setAttribute("DTO", fDao.get(flightCode));
                request.setAttribute("ERROR", error);
            } else {
                Fly_PlanDTO dto = new Fly_PlanDTO(0, flightCode, date, customerNo);
                Fly_PlanDAO dao = new Fly_PlanDAO();
                boolean check = dao.insert(dto);
                if (check) {
                    url = "GetAllFlights";
                } else {
                    url = "error.jsp";
                }
            }

        } catch (Exception e) {
            log("ERROR at InsertFlyController " + e.getMessage());
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
