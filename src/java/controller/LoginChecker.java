package controller;

import db.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginChecker", urlPatterns = {"/LoginChecker"})

public class LoginChecker extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("login.html");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        PrintWriter out= response.getWriter();
        System.out.println(email);
        System.out.println(password);
        

        String tablePassword="";
        try
        {
            Statement st = DBConnector.getStatement();
            
            String query="select password from student where email='"+email+"';";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                tablePassword = rs.getString(1);
            }  
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(email!=null && password!=null && password.equals(tablePassword))
        {
            response.sendRedirect("welcome.jsp");
        }
        else
        {
            out.println("Login Failed!");
        }
    }
    
    
}

