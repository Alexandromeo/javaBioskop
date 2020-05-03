package projek.praktikum.akhir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MDashboardUser 
{
    MConnect koneksi;
    Statement state;
    public MDashboardUser()
    {
        koneksi = new MConnect();
    }
    
    public String[][] getMovie()
    {
        try{
            int jmlData = 0;//menampung jumlah data
            String table = "movie_data";
            String data[][] = new String[getCount(table)][99];
            String query = "select *, sum(td_amount) as total from movie_data left join transaction_data on md_id = td_movie group by md_id order by md_title asc"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data[jmlData][0] = resultSet.getString("md_id");
                data[jmlData][1] = resultSet.getString("md_title"); 
                data[jmlData][2] = "Rp"+resultSet.getString("md_price");                
                data[jmlData][3] = resultSet.getString("md_stock")+" tiket";
                data[jmlData][4] = resultSet.getString("md_created_at");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            return null;
        }
    }
    
    public int getCount(String table)
    {
        int jmlData = 0;
        try{
            state = koneksi.koneksi.createStatement();
            String query = "Select * from `"+table+"`"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            return 0;
        }
    }
    
    public int getCountTransaksi()
    {
        int jmlData = 0;
        try
        {
            state = koneksi.koneksi.createStatement();
            String query = "Select * from transaction_data "
                    + "join movie_data on td_movie = md_id "
                    + "join user_data on td_user = ud_id and ud_email = '"+CSession.getSessionEmail()+"'"
                    + "join voucher_data on td_voucher = vd_id";
            ResultSet resultSet = state.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            return 0;
        }
    }
    
    public String[][] getTransaksi()
    {
        try{
            int jmlData = 0;//menampung jumlah data
            String table = "transaction_data";
            String data[][] = new String[getCountTransaksi()][9];
            String query = "Select * from transaction_data "
                    + "join movie_data on td_movie = md_id"
                    + "join user_data on td_user = ud_id and ud_email = '"+CSession.getSessionEmail()+"'"
                    + "join voucher_data on td_voucher = vd_id order";
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data[jmlData][0] = resultSet.getString("md_title");                
                data[jmlData][1] = "Rp"+resultSet.getString("md_price");
                data[jmlData][2] = resultSet.getString("td_amount");
                data[jmlData][3] = resultSet.getString("vd_name");
                data[jmlData][4] = resultSet.getString("td_created_at");
                if(resultSet.getString("vd_name").equals(""))
                    data[jmlData][3] = "-";
                else
                    data[jmlData][3] = resultSet.getString("vd_name");
                
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            return null;
        }
    }
    
    public double getSaldo()
    {
        try{
            state = koneksi.koneksi.createStatement();
            String table = "user_data";
            double saldo = 0;
            String query = "select *from user_data where ud_email = '"+CSession.getSessionEmail()+"'";
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
               saldo = resultSet.getInt("ud_saldo");
            }
            return saldo;
               
        }catch(SQLException e){
            return 0;
        }
    }
    
    public int topUp(double saldo)
    {
        try
        {
            String query = "update user_data set "
                    + "ud_saldo = ud_saldo+'"+saldo+"' "
                    + "where ud_email = '"+CSession.getSessionEmail()+"'";
            state = koneksi.koneksi.createStatement();
            state.executeUpdate(query);
            return 1;
        }
        
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public String[] getMovieById(int id)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            String data[] = new String[5];
            String query = "Select * from `movie_data` where md_id = '"+id+"'"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data[0] = resultSet.getString("md_id");
                data[1] = resultSet.getString("md_title");
                data[2] = resultSet.getString("md_price");
                data[3] = resultSet.getString("md_stock");
            }
            return data;
        }
        
        catch(Exception e)
        {
            return null;
        }
    }
    
    public int getVoucherByName(String name)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            int data = 0;
            String query = "Select * from `voucher_data` where vd_name = '"+name+"'"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data = Integer.parseInt(resultSet.getString("vd_discount"));
            }
            return data;
        }
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int getIDVoucherByName(String name)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            int data = 0;
            String query = "Select * from `voucher_data` where vd_name = '"+name+"'"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data = Integer.parseInt(resultSet.getString("vd_id"));
            }
            return data;
        }
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int getIDUserByEmail(String email)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            int data = 0;
            String query = "Select * from `user_data` where ud_email = '"+email+"'"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data = Integer.parseInt(resultSet.getString("ud_id"));
            }
            return data;
        }
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int insertTransaksi(int id, int movie, int amount, int voucher)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            String query = "insert into transaction_data (td_user, td_movie, td_amount, td_voucher)"
                    + "values ("+id+", "+movie+", "+amount+", "+voucher+")";
            state.executeUpdate(query);
            return 1;
        } 
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int kurangiSaldo(double bayar)
    {
        try
        {
            String query = "update user_data set "
                    + "ud_saldo = ud_saldo-'"+bayar+"' "
                    + "where ud_email = '"+CSession.getSessionEmail()+"'";
            state = koneksi.koneksi.createStatement();
            state.executeUpdate(query);
            return 1;
        }
        
        catch(Exception e)
        {
            return 0;
        }
    }
}
