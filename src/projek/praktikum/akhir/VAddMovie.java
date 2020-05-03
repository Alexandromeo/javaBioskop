package projek.praktikum.akhir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class VAddMovie extends JFrame
{
    JLabel uProfile, lTitle;
    JButton bHome, bPromo, bTransaksi, bUser, bLogout;
    
    
    //dinamis
    JLabel lMovieTitle, lMoviePrice, lMovieStock; 
    private JTextField fMovieTitle, fMoviePrice, fMovieStock;
    JButton bAddMovie;
    public VAddMovie()
    {                
        setTitle("Dashboard");
        lTitle = new JLabel("Bioskop Onlen");
        uProfile = new JLabel("Profile");
        bHome = new JButton("Beranda");
        bPromo = new JButton("Promo");
        bTransaksi = new JButton("Transaksi");
        bUser = new JButton("Pengguna");
        bLogout = new JButton("Keluar");
        bAddMovie = new JButton("Tambah Film");
        setLayout(null);
        add(lTitle);
        add(uProfile);
        add(bHome);
        add(bPromo);
        add(bTransaksi);
        add(bUser);
        add(bLogout);
        
        //dinamis
        lMovieTitle = new JLabel("Judul Film");
        add(lMovieTitle);
        lMoviePrice = new JLabel("Harga");
        add(lMoviePrice);
        lMovieStock = new JLabel("Jumlah Tiket");
        add(lMovieStock);
        
        fMovieTitle = new JTextField();
        add(fMovieTitle);
        fMoviePrice = new JTextField();
        add(fMoviePrice);
        fMovieStock = new JTextField();
        add(fMovieStock);
        bAddMovie = new JButton("Tambah Film");
        add(bAddMovie);
        
        
        //x,y,width,height
        lTitle.setBounds(30, 10, 140, 30);
        uProfile.setBounds(650, 10, 200, 30);
        bHome.setBounds(0, 50, 140, 30);
        bPromo.setBounds(0, 80, 140, 30);
        bTransaksi.setBounds(0, 110, 140, 30);
        bUser.setBounds(0, 140, 140, 30);
        bLogout.setBounds(0, 170, 140, 30);
        
        
        //dinamis
        lMovieTitle.setBounds(170, 50, 80, 30);
        fMovieTitle.setBounds(250, 50, 200, 30);
        lMoviePrice.setBounds(170, 90, 80, 30);
        fMoviePrice.setBounds(250, 90, 200, 30);
        lMovieStock.setBounds(170, 130, 80, 30);
        fMovieStock.setBounds(250, 130, 200, 30);
        bAddMovie.setBounds(500, 50, 150, 30);
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getMovieTitle()
    {
        return this.fMovieTitle.getText();
    }
    
    public String getMoviePrice()
    {
        return this.fMoviePrice.getText();
    }
    
    public String getMovieStock()
    {
        return this.fMovieStock.getText();
    }
}
