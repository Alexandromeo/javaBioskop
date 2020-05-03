package projek.praktikum.akhir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CDashboardAdmin {
    
    MDashboardAdmin model = new MDashboardAdmin();
    //halaman beranda
    public CDashboardAdmin(VDashboardAdmin view)
    {
        homePage(view);
    }
    
    private void homePage(VDashboardAdmin view)
    {
        //ketika tambah film diklik
        CSidebarAction.sidebarAction(view);
        view.bAddMovie.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VAddMovie v = new VAddMovie();
               addMovie(v);
           }
        });
        
        String dataFilm[][] = model.getMovie();
        if(dataFilm != null)
        {
            view.tMovie.setModel(new JTable(dataFilm, view.headTable).getModel());
        }
        
        else
            System.out.println("Data tidak ada ");
    }
    
    public static void showPromo(VPromo view)
    {
        MDashboardAdmin model = new MDashboardAdmin();
        CSidebarAction.sidebarAction(view);
        
        //ketika tambah film diklik
        view.bAddPromo.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VAddPromo v = new VAddPromo();
               addPromo(v);
           }
        });
        
        String dataPromo[][] = model.getPromo();
        if(dataPromo != null)
        {
            view.tMovie.setModel(new JTable(dataPromo, view.headTable).getModel());
        }
        
        else
            System.out.println("Data tidak ada ");
        
    }
    
    //add movie
    public void addMovie(VAddMovie view)
    {
       CSidebarAction.sidebarAction(view);
       view.bAddMovie.addActionListener(new ActionListener()
       {
          @Override
          public void actionPerformed(ActionEvent e)
          {
              String judul = view.getMovieTitle();
              String price = view.getMoviePrice();
              String stock = view.getMovieStock();
              if(!judul.equals("") && !price.equals("") && !stock.equals(""))
              {
                  int harga = Integer.parseInt(price);
                  int stok = Integer.parseInt(stock);
                  
                  int insert = model.insertMovie(judul, harga, stok);
                  if(insert == 1)
                  {
                    JOptionPane.showMessageDialog(null, "Berhasil menambahkan data film");
                    view.setVisible(false);
                    VDashboardAdmin v = new VDashboardAdmin();
                    homePage(v);
                  }
                  
                  else
                      JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam menambahkan data film");
              }
              
              else
                  JOptionPane.showMessageDialog(null, "Seluruh data harus diisi");
          }
       });
    }
    
    
    //add promo
    public static void addPromo(VAddPromo view)
    {
        MDashboardAdmin model = new MDashboardAdmin();
        CSidebarAction.sidebarAction(view);
        view.bAddPromo.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               String nama = view.getName();
               String diskon = view.getDiscount();
               String durasi = view.getDuration();
               if(!nama.equals("") && !diskon.equals("") && !durasi.equals(""))
               {
                   if(model.getPromoByName(nama) <= 0)
                   {
                       int discount = Integer.parseInt(diskon);
                       int duration = Integer.parseInt(durasi);
                       int insert = model.insertPromo(nama, discount, duration);
                       if(insert == 1)
                       {
                           JOptionPane.showMessageDialog(null, "Berhasil menambahkan data voucher");
                           view.setVisible(false);
                           VPromo v = new VPromo();
                           showPromo(v);
                       }
                       
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Mohon tunggu beberapa saat");
                       }
                   } 
                   
                   else 
                   {
                       JOptionPane.showMessageDialog(null, "Kode voucher sudah ada sebelumnya");
                   }
               }
               
               else
                   JOptionPane.showMessageDialog(null, "Seluruh data harus diisi");
           }   
        });
    }
    
    public static void showUser(VUser view)
    {
        MDashboardAdmin model = new MDashboardAdmin();
        CSidebarAction.sidebarAction(view);
        
        String dataUser[][] = model.getUser();
        if(dataUser != null)
        {
            view.tMovie.setModel(new JTable(dataUser, view.headTable).getModel());
        }
        
        else
            System.out.println("Data tidak ada ");
    }
    
    public static void showTransaksi(VTransaksi view)
    {
        MDashboardAdmin model = new MDashboardAdmin();
        CSidebarAction.sidebarAction(view);
        String dataTransaksi[][] = model.getTransaksi();
        if(dataTransaksi != null)
        {
            view.tTransaksi.setModel(new JTable(dataTransaksi, view.headTable).getModel());
        }
        
        else
            System.out.println("Data transaksi tidak ada");
    }
}
