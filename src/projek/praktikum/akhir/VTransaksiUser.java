package projek.praktikum.akhir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class VTransaksiUser extends JFrame
{
    JLabel uProfile, lTitle;
    JButton bHome, bPromo, bTransaksi, bSaldo, bLogout;
    
    
    //dinamis
    JTable tTransaksi;
    DefaultTableModel modelTable;
    JScrollPane scroll;
    Object headTable[] = {"Judul", "Harga", "Jumlah Tiket", "Kode Voucher", "Tanggal Pemesanan"};
    public VTransaksiUser()
    {
        modelTable = new DefaultTableModel(headTable, 1);
        tTransaksi = new JTable(modelTable);
        scroll = new JScrollPane(tTransaksi);
        
        setTitle("Dashboard");
        lTitle = new JLabel("Bioskop Onlen");
        uProfile = new JLabel("Profile");
        bHome = new JButton("Beranda");
        bTransaksi = new JButton("Transaksi");
        bSaldo = new JButton("Saldo");
        bLogout = new JButton("Keluar");
        setLayout(null);
        add(lTitle);
        add(uProfile);
        add(bHome);
        add(bTransaksi);
        add(bSaldo);
        add(bLogout);
        
        //dinamis
        add(scroll);
        
        
        //x,y,width,height
        lTitle.setBounds(30, 10, 140, 30);
        uProfile.setBounds(650, 10, 200, 30);
        bHome.setBounds(0, 50, 140, 30);
        bTransaksi.setBounds(0, 80, 140, 30);
        bSaldo.setBounds(0, 110, 140, 30);
        bLogout.setBounds(0, 140, 140, 30);
        
        
        //dinamis
        scroll.setBounds(150, 50, 700, 400);
        
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
