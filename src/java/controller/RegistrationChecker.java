package controller;

import dto.StudentDTO;
import model.RegistrationAuthenticator;
import javax.servlet.annotation.WebServlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegistrationChecker", urlPatterns = {"/RegistrationChecker"})

public class RegistrationChecker extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("registration.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        StudentDTO student = new StudentDTO();
        
        student.setEmail(email);
        student.setPassword(password);
        
        
        RegistrationAuthenticator authenticator = new RegistrationAuthenticator();
        boolean register = authenticator.isRegister(student);
        
        if(register)
        {
            HttpSession session = request.getSession(true);
            System.out.println(email);
            System.out.println(password);
            response.sendRedirect("index.html");
        }
        else
        {
           response.sendRedirect("registration.html");
        }       
   }
}
