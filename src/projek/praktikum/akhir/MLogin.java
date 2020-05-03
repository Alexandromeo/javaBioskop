package projek.praktikum.akhir;

import java.sql.ResultSet;
import java.sql.Statement;

public class MLogin {
    MConnect koneksi;
    Statement state;
    String email;
    public MLogin()
    {
        koneksi = new MConnect();
    }
    
    public int checkUser(String email, String password)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            String query = "select * from user_data where ud_email = '"+email+"'";
            ResultSet result = state.executeQuery(query);
            if(result.next()) //email tidak ada
            {
                if(password.equals(result.getString("ud_password")))
                {
                    CSession.setSession(email, result.getInt("ud_role"));
                    return result.getInt("ud_role");    
                }
                
                else
                    return -2;
            }
            else
                return 0;
        }
        catch(Exception e)
        {
            return -1;
        }
    }
}
