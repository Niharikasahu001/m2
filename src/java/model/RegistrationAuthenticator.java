package model;

import db.DBConnector;
import java.sql.ResultSet;
import dto.StudentDTO;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 91898
 */
public class RegistrationAuthenticator 
{
    public boolean isRegister(StudentDTO student)
    {
        Statement st = DBConnector.getStatement();
       
        String email = student.getEmail();
        String password = student.getPassword(); 
       
        try
        {
            String query = "insert into student values('"+email+"','"+password+"')";
            int rs = st.executeUpdate(query);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return false;
        
    }
}
