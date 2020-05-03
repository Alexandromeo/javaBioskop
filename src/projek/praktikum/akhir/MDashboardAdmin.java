package projek.praktikum.akhir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MDashboardAdmin 
{
    MConnect koneksi;
    Statement state;
    public MDashboardAdmin()
    {
        koneksi = new MConnect();
    }
    
    public int insertMovie(String judul, int harga, int stok)
    {
        try
        {
            String query = "insert into movie_data (md_title, md_price, md_stock) "
                    + "values ('"+judul+"', "+harga+", "+stok+")";
            state = koneksi.koneksi.createStatement();
            state.executeUpdate(query);
            return 1;
        }
        catch(Exception e)
        {
            return 0;
        }
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
                data[jmlData][0] = resultSet.getString("md_title"); 
                data[jmlData][1] = "Rp"+resultSet.getString("md_price");                
                data[jmlData][2] = resultSet.getString("md_stock")+" tiket";
                if(resultSet.getInt("total") > 0)
                {
                    data[jmlData][3] = resultSet.getString("total")+" tiket";
                }
                else
                {
                    data[jmlData][3] = "0 tiket";
                }
                
                data[jmlData][4] = resultSet.getString("md_created_at");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            return null;
        }
    }  
    
    public int getCount(String table){//menghitung jumlah baris
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
    
    public int getPromoByName(String name)
    {
        int jmlData = 0;
        try
        {
            state = koneksi.koneksi.createStatement();
            String query = "select *from voucher_data where md_name = '"+name+"'";
            ResultSet result = state.executeQuery(query);
            while (result.next())
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
    
    public int insertPromo(String nama, int diskon, int durasi)
    {
        try
        {
            state = koneksi.koneksi.createStatement();
            String query = "insert into voucher_data"
                    + " (vd_name, vd_discount, vd_duration) "
                    + "values ('"+nama+"', '"+diskon+"', '"+durasi+"')";
            state.executeUpdate(query);
            return 1;
        } 
        catch(SQLException e)
        {
            return 0;
        }
    }
    
    public String[][] getPromo()
    {
        try{
            int jmlData = 0;//menampung jumlah data
            String table = "voucher_data";
            String data[][] = new String[getCount(table)-1][5];
            String query = "Select * from `"+table+"` where vd_name != ''"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data[jmlData][0] = resultSet.getString("vd_name"); 
                data[jmlData][1] = resultSet.getString("vd_discount")+"%";                
                data[jmlData][2] = resultSet.getString("vd_duration")+" hari";
                data[jmlData][3] = resultSet.getString("vd_created_at");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            return null;
        }
    }
    
    public String[][] getUser()
    {
        try{
            int jmlData = 0;//menampung jumlah data
            String table = "user_data";
            String data[][] = new String[getCount(table)][6];
            String query = "Select * from `"+table+"`"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data[jmlData][0] = resultSet.getString("ud_email");              
                if(resultSet.getInt("ud_role") == 1)
                    data[jmlData][1] = "Admin";
                else
                    data[jmlData][1] = "Pengguna";
                
                data[jmlData][2] = resultSet.getString("ud_created_at");   
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            return null;
        }
    }
    
    public String[][] getTransaksi()
    {
        try{
            int jmlData = 0;//menampung jumlah data
            String table = "transaction_data";
            String data[][] = new String[getCount(table)][9];
            String query = "Select * from transaction_data "
                    + "join movie_data on td_movie = md_id "
                    + "join user_data on td_user = ud_id "
                    + "join voucher_data on td_voucher = vd_id"; 
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            { 
                data[jmlData][0] = resultSet.getString("ud_email"); 
                data[jmlData][1] = resultSet.getString("md_title");                
                data[jmlData][2] = resultSet.getString("td_amount");
                data[jmlData][3] = resultSet.getString("md_price");
                if(resultSet.getString("vd_name").equals(""))
                    data[jmlData][4] = "-";
                else
                    data[jmlData][4] = resultSet.getString("vd_name");
                data[jmlData][5] = resultSet.getString("td_created_at");
                
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            return null;
        }
    }
}
