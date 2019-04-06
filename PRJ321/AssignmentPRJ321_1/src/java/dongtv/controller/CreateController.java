/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.ProductDAO;
import dongtv.dto.ErrorObj;
import dongtv.dto.ProductDTO;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xhunt
 */
public class CreateController extends HttpServlet {

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
        String url = "Create.jsp";
        try {
            boolean valid = true;
            String id = request.getParameter("txtId");
            String Name = request.getParameter("txtName");
            String temp = request.getParameter("txtPrice");
            String Description = request.getParameter("txtDescription");
            String status = request.getParameter("txtStatus");

            ErrorObj errorObj = new ErrorObj();

            float price = 0;
            try {
                price = Float.parseFloat(temp);
            } catch (Exception e) {
                errorObj.setProductPrice("Price is invalid");
                valid = false;
            }
            if (id.length() == 0) {
                valid = false;
                errorObj.setProductID("ProductCode can not be blank");
            }
            if (Name.length() == 0) {
                valid = false;
                errorObj.setProductName("Name can not be blank");
            }
            if (Description.length() == 0) {
                valid = false;
                errorObj.setDescription("Description can not be blank");
            }
            if (status.length() == 0) {
                valid = false;
                errorObj.setStatus("status can not be blank");
            }
            ProductDTO dto = new ProductDTO(id, Name, price, Description, status);
            request.setAttribute("dto", dto);
            if (!valid) {
                request.setAttribute("error", errorObj);

                request.getRequestDispatcher(url).forward(request, response);
                return;
            }

            ProductDAO dao = new ProductDAO();
            boolean check = dao.insert(dto);
            if (check) {
                url = "index.jsp";
                List<ProductDTO> list = new LinkedList<>();
                list.add(dto);
                request.setAttribute("data", list);
            } else {
                request.setAttribute("Error", "Insert fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
            url = "Error.jsp";
            request.setAttribute("Error", e.getMessage());
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
