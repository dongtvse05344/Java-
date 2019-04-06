/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller.admin;

import dongtv.bean.DongtvBean;
import static dongtv.controller.admin.Utils.*;
import dongtv.dao.AccountDAO;
import dongtv.dto.AccountDTO;
import dongtv.dto.ErrorObj;
import dongtv.dto.EventDTO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 *1024 *2, maxFileSize = 1024 *1024 *10 , maxRequestSize = 1024*1024 *50)
/**
 *
 * @author
 */


public class CreateEventController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "E:\\Ki_4\\Present\\web\\css\\img\\upload";
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
        String url = CREATE_EVENT_FORM;
        try {
            HttpSession session = request.getSession();
            AccountDAO dao = new AccountDAO();
            ArrayList<AccountDTO> list = dao.getManagers();
            session.setAttribute("list", list);

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm").format(Calendar.getInstance().getTime());
            request.setAttribute("timeStart", timeStamp);
            request.setAttribute("timeEnd", timeStamp);
        } catch (Exception e) {
            log("ERROR at CreateEventController doGet " + e.getMessage());
        }
        request.getRequestDispatcher(url).forward(request, response);
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
        String url = CREATE_EVENT_FORM;
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
            String filename = "";
            try {
//                Part part = request.getPart("file");
//                filename = new Date().getTime() + extractFileName(part);
//                String savePath = UPLOAD_DIRECTORY + File.separator + filename;
//                File fileSaveDir = new File(savePath);
//                part.write(savePath + File.separator);
                
                Part part = request.getPart("file");
                filename = new Date().getTime() + ".jpg";
                part.write(UPLOAD_DIRECTORY + "/" + filename);
            } catch (Exception e) {
                e.printStackTrace();
            } 

            EventDTO dto = new EventDTO(name, dateStarted, dateEnded, managerId, "css/img/upload/"+filename, location, description, noUser);
            if (!valid) {
                request.setAttribute("DTO", dto);
                request.setAttribute("ERROR", error);
                request.setAttribute("timeStart", request.getParameter("dateStarted"));
                request.setAttribute("timeEnd", request.getParameter("dateEnded"));
            } else {
                DongtvBean bean = new DongtvBean();

                bean.setEventDTO(dto);
                int check = bean.createEvent();
                if (check >= 0) {
                    dto.setId(check);
                    System.out.println(check);
                    url = ADMIN_HOME;
                } else {
                    error.setMess("Create Failed");
                    request.setAttribute("DTO", dto);
                    request.setAttribute("ERROR", error);
                    request.setAttribute("timeStart", request.getParameter("dateStarted"));
                    request.setAttribute("timeEnd", request.getParameter("dateEnded"));
                }
            }
        } catch (Exception e) {
            log("ERROR at CreateEventController " + e.getMessage());
            url = ERROR;
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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

    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String items[] = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
    }
}
