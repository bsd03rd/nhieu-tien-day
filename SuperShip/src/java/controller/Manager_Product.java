/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import context.libDao;
import core.CurrentDate;
import core.ImagesString;
import core.Inpputer;
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
import model.Acount_cloud;
import model.Product_Cloud;
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
public class Manager_Product extends HttpServlet {
    
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
            request.getRequestDispatcher("view/Manager_Product.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
        
        if (request.getParameter("ADDpdbtn") != null) {
            try {
                
                if(request.getParameter("pdname")==null||request.getParameter("pdname").trim().isEmpty()||
                        request.getParameter("pdunit")==null||request.getParameter("pdunit").trim().isEmpty()||
                        request.getParameter("pdcost")==null||request.getParameter("pdcost").trim().isEmpty()||
                        request.getParameter("pdamount")==null||request.getParameter("pdamount").trim().isEmpty()||
                        request.getParameter("pddescription")==null||request.getParameter("pddescription").trim().isEmpty()){
                    request.getSession().setAttribute("notice1", "Please fill all data to create product!");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("pdname"), "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")==false){
                    request.getSession().setAttribute("notice1", "Name format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("pdunit"), "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")==false){
                    request.getSession().setAttribute("notice1", "Unit format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("pdcost"), "^([+-]?\\d*\\.?\\d*)$")==false){
                    request.getSession().setAttribute("notice1", "Cost format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("pdamount"), "^\\d+$")==false){
                    request.getSession().setAttribute("notice1", "Amount format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                
                //
                Part filePart = request.getPart("ADDimg_item");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = filePart.getInputStream();
                byte[] img = IOUtils.readFully(fileContent, fileContent.available(), true);
                if(fileName.isEmpty()){
                    img=Base64.getDecoder().decode(new ImagesString().getDefaultProdcut());
                }
                new DAO().Add_Product_Cloud(
                        new Product_Cloud(
                                "", request.getParameter("pdcate"),
                                ac.getGmail_Account(), request.getParameter("pdname"),
                                request.getParameter("pdunit"),
                                request.getParameter("pdcost"),
                                request.getParameter("pdamount"),
                                new CurrentDate().GetDate(), img,request.getParameter("pddescription")));
                response.sendRedirect("Manager_Product");
            } catch (SQLException ex) {
                System.err.println(ex);
            } catch (ClassNotFoundException ex) {
                System.err.println(ex);
            }
        }
        if(request.getParameter("delepdbtn")!=null){
            try {
                new DAO().Delete_Product_Cloud(request.getParameter("deletepd"), ac.getGmail_Account());
                response.sendRedirect("Manager_Product");
            } catch (SQLException ex) {
                Logger.getLogger(Manager_Product.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manager_Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (request.getParameter("editpdbtn") != null) {
            
            ///edit regex
            
            if(request.getParameter("editpdname")==null||request.getParameter("editpdname").trim().isEmpty()||
                        request.getParameter("editpdunit")==null||request.getParameter("editpdunit").trim().isEmpty()||
                        request.getParameter("editpdcost")==null||request.getParameter("editpdcost").trim().isEmpty()||
                        request.getParameter("editpdamount")==null||request.getParameter("editpdamount").trim().isEmpty()||
                        request.getParameter("editpddescription")==null||request.getParameter("editpddescription").trim().isEmpty()){
                    request.getSession().setAttribute("notice2", "Please fill all data to create product!");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("editpdname"), "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")==false){
                    request.getSession().setAttribute("notice2", "Name format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("editpdunit"), "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")==false){
                    request.getSession().setAttribute("notice2", "Unit format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("editpdcost"), "^([+-]?\\d*\\.?\\d*)$")==false){
                    request.getSession().setAttribute("notice2", "Cost format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
                if(new Inpputer().InputRegex(request.getParameter("editpdamount"), "^\\d+$")==false){
                    request.getSession().setAttribute("notice2", "Amount format is not a good format !");
                    response.sendRedirect("Manager_Product");
                    return;
                }
            
            
            ///
            
            
            
            
            if(!(request.getParameter("editimgcheck").equals("null"))){
                Part filePart = request.getPart("EDITimg_item");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = filePart.getInputStream();
                byte[] img = IOUtils.readFully(fileContent, fileContent.available(), true);
                try {
                    new DAO().Update_Product_Cloud(
                            new Product_Cloud(
                                    request.getParameter("editpd"), request.getParameter("editpdcate"),
                                    ac.getGmail_Account(), request.getParameter("editpdname"),
                                    request.getParameter("editpdunit"),
                                    request.getParameter("editpdcost"),
                                    request.getParameter("editpdamount"),
                                    new CurrentDate().GetDate(), img,request.getParameter("editpddescription")));
                    response.sendRedirect("Manager_Product");
                } catch (SQLException ex) {
                    Logger.getLogger(Manager_Product.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Manager_Product.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
               try {
                    new DAO().Update_Product_Cloud(
                            new Product_Cloud(
                                    request.getParameter("editpd"), request.getParameter("editpdcate"),
                                    ac.getGmail_Account(), request.getParameter("editpdname"),
                                    request.getParameter("editpdunit"),
                                    request.getParameter("editpdcost"),
                                    request.getParameter("editpdamount"),
                                    new CurrentDate().GetDate(), new libDao().GetIMGDProduct(request.getParameter("editpd")
                                    ),request.getParameter("editpddescription")));
                    response.sendRedirect("Manager_Product");
                } catch (SQLException ex) {
                    Logger.getLogger(Manager_Product.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Manager_Product.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
                
        }
        
    }
    
}
