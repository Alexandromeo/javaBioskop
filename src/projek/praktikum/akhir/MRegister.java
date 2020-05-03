package projek.praktikum.akhir;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MRegister {
    MConnect koneksi;
    Statement state;
    String email;
    public MRegister()
    {
        koneksi = new MConnect();
    }
    
    public int insertUser(String email, String pass, int role)
    {
        try
        {
            String query = "insert into user_data (ud_email, ud_password, ud_role) values ('"+email+"', '"+pass+"', '"+role+"')";
            state = koneksi.koneksi.createStatement();
            state.executeUpdate(query);
            return 1;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int getUser(String email, int role)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            String query = "select * from user_data where ud_email = '"+email+"'";
            ResultSet result = state.executeQuery(query);
            if(result.next()) //jika email sudah terdaftar
                return 0;
            else
            {
                CSession.setSession(email, role);
                return 1;
            }
        }
        catch(Exception e)
        {
            return -1;
        }
    }
}
