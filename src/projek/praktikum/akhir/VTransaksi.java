package projek.praktikum.akhir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class VTransaksi extends JFrame
{
    JLabel uProfile, lTitle;
    JButton bHome, bPromo, bTransaksi, bUser, bLogout;
    
    
    //dinamis
    JTable tTransaksi;
    JLabel subTitle;
    DefaultTableModel modelTable;
    JScrollPane scroll;
    Object headTable[] = {"Email Pembeli", "Judul Film", "Jumlah Tiket", "Harga Tiket", "Voucher", "Tanggal Pemesanan"};
    public VTransaksi()
    {
        modelTable = new DefaultTableModel(headTable, 0);
        tTransaksi = new JTable(modelTable);
        scroll = new JScrollPane(tTransaksi);
        
        setTitle("Dashboard");
        lTitle = new JLabel("Bioskop Onlen");
        uProfile = new JLabel("Profile");
        bHome = new JButton("Beranda");
        bPromo = new JButton("Promo");
        bTransaksi = new JButton("Transaksi");
        bUser = new JButton("Pengguna");
        bLogout = new JButton("Keluar");
        setLayout(null);
        add(lTitle);
        add(uProfile);
        add(bHome);
        add(bPromo);
        add(bTransaksi);
        add(bUser);
        add(bLogout);
        
        //dinamis
        subTitle = new JLabel("Data Transaksi");
        add(subTitle);
        add(scroll);
        
        
        //x,y,width,height
        lTitle.setBounds(30, 10, 140, 30);
        uProfile.setBounds(650, 10, 200, 30);
        bHome.setBounds(0, 50, 140, 30);
        bPromo.setBounds(0, 80, 140, 30);
        bTransaksi.setBounds(0, 110, 140, 30);
        bUser.setBounds(0, 140, 140, 30);
        bLogout.setBounds(0, 170, 140, 30);
        
        
        //dinamis
        scroll.setBounds(150, 90, 700, 400);
        subTitle.setBounds(400, 50, 150, 30);
        
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
