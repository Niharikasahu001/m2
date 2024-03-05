package dao;

import db.DBConnector;
import dto.StudentDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO 
{
    public static StudentDTO getStudentById(String email)
    {
        StudentDTO student = new StudentDTO();
        try
        {
            Connection con = DBConnector.getConnection();
            Statement st = DBConnector.getStatement();
            String query = "select * from student where email = '"+email+"'";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
                student.setEmail(rs.getString(4));
                student.setPassword(rs.getString(5));
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return student; 
    }     
}
