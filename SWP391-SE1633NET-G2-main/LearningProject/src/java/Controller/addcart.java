/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import dal.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author BachDuc
 */
public class addcart extends HttpServlet {

    
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        Course course ;
         ArrayList<Course> listcart= (ArrayList<Course>)request.getSession().getAttribute("listcart");
         if(listcart==null){
             listcart= new ArrayList<>();
         }
        try {
            
           course = cd.getCourseInformation(Integer.parseInt(request.getParameter("CourseID")));
           if(course.getCourseID()==0){
                 response.sendRedirect("home");
           }
        } catch (Exception e) {
            response.sendRedirect("home");
        }
        if(request.getParameter("removecart")!=null){
            for (int i = 0; i < listcart.size() ; i++) {
                if(listcart.get(i).getCourseID()==cd.getCourseInformation(Integer.parseInt(request.getParameter("CourseID"))).getCourseID()){
                    listcart.remove(listcart.get(i));
                }
            }
//            listcart.remove(cd.getCourseInformation(Integer.parseInt(request.getParameter("CourseID"))));
            request.getSession().setAttribute("listcart", listcart);
            response.sendRedirect("ShoppingCart");
        }else{
            listcart.add(cd.getCourseInformation(Integer.parseInt(request.getParameter("CourseID"))));
            request.getSession().setAttribute("listcart", listcart);
            response.sendRedirect("home");
        }
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
}
