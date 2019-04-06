/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller.admin;

import dongtv.bean.DongtvBean;
import static dongtv.controller.admin.Utils.*;
import dongtv.dto.ErrorObj;
import dongtv.dto.EventDTO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024*1024*2, maxFileSize = 1024*1024*10, maxRequestSize = 1024*1024*50)
/**
 *
 * @author xhunt
 */
public class UpdateEventController extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "E:\\Ki_4\\Present\\web\\css\\img\\upload";
    // must be change in another Root
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
        String url = UPDATE_EVENT_VIEW;
        try {
            boolean valid = true;
            ErrorObj error = new ErrorObj();

            String name = request.getParameter("name");

            Date dateTemp = OBJ_SDF.parse(request.getParameter("dateStarted"));
            java.sql.Timestamp dateStarted = new Timestamp(dateTemp.getTime());
            dateTemp = OBJ_SDF.parse(request.getParameter("dateEnded"));
            java.sql.Timestamp dateEnded = new Timestamp(dateTemp.getTime());

            String managerId = request.getParameter("managerId");

            String location = request.getParameter("location");

            int noUser = 0;
            try {
                noUser = Integer.parseInt(request.getParameter("NoUser"));
                if (noUser <= 0) {
                    valid = false;
                    error.setNoUser("Number of user must be positive number");
                }
            } catch (Exception e) {
                valid = false;
                error.setNoUser("Please input Number of user");
            }

            String description = request.getParameter("description");
            description = new String(description.getBytes("ISO-8859-1"), "UTF-8");
            if (name.length() == 0) {
                valid = false;
                error.setName("Name can not be blank");
            }

            if (location.length() == 0) {
                valid = false;
                error.setLocation("Location can not be blank");
            }

            if (description.length() == 0) {
                valid = false;
                error.setDescription("Description can not be blank");
            }

            if (dateStarted.compareTo(dateEnded) > 0) {
                valid = false;
                error.setDateEnded("Date ended can not be pre date started");
            }
            String filename = request.getParameter("banner");
            if (filename == null || filename.length() == 0) {
                try {
//                    Part part = request.getPart("file");
//                    filename = new Date().getTime() + ".jpg";
//                    String savePath = UPLOAD_DIRECTORY + "/" + filename;
//                    part.write(savePath);
//                    filename = "css/img/upload1/" + filename;
                    
                    Part part = request.getPart("file");
                    filename = new Date().getTime() +".jpg";
                    part.write(UPLOAD_DIRECTORY + "/" +filename);
                    filename  ="css/img/upload/" + filename;


                } catch (Exception e) {

                }
            }
            int id = Integer.parseInt(request.getParameter("eventId"));
            EventDTO dto = new EventDTO(id, name, null, dateStarted, dateEnded, managerId, filename, location, description, noUser);
            if (!valid) {
                request.setAttribute("DTO", dto);
                request.setAttribute("ERROR", error);
                request.setAttribute("timeStart", request.getParameter("dateStarted"));
                request.setAttribute("timeEnd", request.getParameter("dateEnded"));
            } else {
                DongtvBean bean = new DongtvBean();
                bean.setEventDTO(dto);
                boolean check = bean.updateEvent();
                System.out.println(check);
                url = ADMIN_HOME;
            }
        } catch (Exception e) {
            log("ERROR at CreateEventController " + e.getMessage());
            url = ERROR;
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

//    private String extractFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String items[] = contentDisp.split(";");
//        for (String item : items) {
//            if (item.trim().startsWith("filename")) {
//                return item.substring(item.indexOf("=") + 2, item.length() - 1);
//            }
//        }
//        return "";
//    }

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
