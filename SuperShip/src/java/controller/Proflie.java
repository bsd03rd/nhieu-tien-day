/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import core.ImagesString;
import core.Inpputer;
import core.SHA_256;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Account_info_Cloud;
import model.Acount_cloud;
import model.All_In4_Account_Seller;
import sun.misc.IOUtils;

/**
 *
 * @author 
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class Proflie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            new AutoLogin().processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (request.getSession().getAttribute("ac") != null) {
            request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            new AutoLogin().processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (request.getParameter("repass") != null) {
            String notice = "";
            String[] newpass = request.getParameterValues("new");
            if (!(newpass[0]).equals(newpass[1])) {
                notice = "Repassword wrong!\n";
            request.getSession().setAttribute("noticepass", notice);
            request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
            return;
            }
            if (new Inpputer().InputRegex(newpass[0], "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,28}$") == false) {
                notice = "Minimum eight and maximum 28 characters, at least one uppercase letter, one lowercase letter, one number and one special character\n";
           request.getSession().setAttribute("noticepass", notice);
            request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
            return;
            }
            try {
                new DAO().Update_Pass(new SHA_256().MySHA256(newpass[0]) , ((Acount_cloud)request.getSession().getAttribute("ac")).getGmail_Account());
                request.getSession().setAttribute("noticepass", "");
                new Logout().doPost(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
          
        }

        if (request.getParameter("upload_img") != null) {
            Part filePart = request.getPart("img_item"); // Retrieves <input type="file" name="file">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            byte[] img = IOUtils.readFully(fileContent, fileContent.available(), true);
            try {
                if (fileName.isEmpty()) {
                    Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
                    new DAO().Update_AccountIMG_Cloud(Base64.getDecoder().decode(new ImagesString().getDefaultAvatar()), ac.getGmail_Account());
                    response.sendRedirect("Proflie");
                    return;
                } else {
                    Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
                    new DAO().Update_AccountIMG_Cloud(img, ac.getGmail_Account());
                    response.sendRedirect("Proflie");
                    return;
                }

            } catch (Exception e) {
                response.sendRedirect("Proflie");
                return;
            }
        }
        if (request.getParameter("update_info") != null) {
            if (request.getParameter("fname") == null || request.getParameter("fname").trim().isEmpty() || request.getParameter("lname") == null || request.getParameter("lname").trim().isEmpty() || request.getParameter("phone") == null || request.getParameter("phone").trim().isEmpty()) {
                request.setAttribute("notice", "Please Insert all information to update your profile ! ");
                request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
                return;
            }
            if (new Inpputer().InputRegex(request.getParameter("phone"), "^[0-9]{9,10}$") == false) {
                request.setAttribute("notice", "Your Phone number onlyinclude number and Your Phone Number must lenght at less 9 and less than 10 !");
                request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
                return;
            }
            if (new Inpputer().InputRegex(request.getParameter("fname"), "^[A-Z]{1}[a-z]{2,7}$") == false) {
                request.setAttribute("notice", "FirstName:First chracter must Uppcase , format only chracter A-Z and length must from 3 to 8 ");
                request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
                return;
            }
            if (new Inpputer().InputRegex(request.getParameter("lname"), "^[A-Z]{1}[a-z]{2,7}$") == false) {
                request.setAttribute("notice", "LasName:First chracter must Uppcase , format only chracter A-Z and length must from 3 to 8 ");
                request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
                return;
            }
            try {
                Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
                new DAO().Update_Account_Cloud(
                        new Acount_cloud(request.getParameter("email"), "", "", new Account_info_Cloud(null, request.getParameter("fname"), request.getParameter("lname"), request.getParameter("gender"), null, request.getParameter("phone"), ac.getAccount_info().getImg(), null), null, null)
                );
                response.sendRedirect("Proflie");
                return;
            } catch (SQLException ex) {
                Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

        try {
            new AutoLogin().processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (request.getSession().getAttribute("ac") != null) {
            request.getRequestDispatcher("view/Profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }

    }

}
