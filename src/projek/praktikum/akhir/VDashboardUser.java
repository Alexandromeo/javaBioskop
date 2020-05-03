package projek.praktikum.akhir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class VDashboardUser extends JFrame
{
    JLabel uProfile, lTitle;
    JButton bHome, bPromo, bTransaksi, bSaldo, bLogout;
    
    
    //dinamis
    JTable tMovie;
    DefaultTableModel modelTable;
    JScrollPane scroll;
    JLabel lSaldo, lPriceSaldo;
    Object headTable[] = {"ID Film", "Judul", "Harga", "Jumlah Tiket", "Tanggal Dibuat"};
    
    JLabel lVoucher, lQTY, lTotal, lKeterangan, lPrice;
    JTextField fVoucher;
    private JTextField fQTY;
    JButton bOrder;
    
    public VDashboardUser()
    {
        modelTable = new DefaultTableModel(headTable, 0);
        tMovie = new JTable(modelTable);
        scroll = new JScrollPane(tMovie);
        
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
        lSaldo = new JLabel("Saldo : ");
        lPriceSaldo = new JLabel();
        add(lSaldo);
        add(lPriceSaldo);
        lQTY = new JLabel("Jumlah Tiket");
        lVoucher = new JLabel("Voucher (Jika ada)");
        fQTY = new JTextField("1");
        fVoucher = new JTextField();
        bOrder = new JButton("Pesan");
        lPrice = new JLabel("0");
        lTotal = new JLabel("Total : Rp");
        lKeterangan = new JLabel("");
        add(lQTY);
        add(lVoucher);
        add(fQTY);
        add(fVoucher);
        add(bOrder);
        add(lTotal);
        add(lPrice);
        add(lKeterangan);
        
        //x,y,width,height
        lTitle.setBounds(30, 10, 140, 30);
        uProfile.setBounds(650, 10, 200, 30);
        bHome.setBounds(0, 50, 140, 30);
        bTransaksi.setBounds(0, 80, 140, 30);
        bSaldo.setBounds(0, 110, 140, 30);
        bLogout.setBounds(0, 140, 140, 30);
        
        
        //dinamis
        scroll.setBounds(150, 50, 700, 400);
        lSaldo.setBounds(150, 450, 60, 30);
        lPriceSaldo.setBounds(210, 450, 400, 30);
        lQTY.setBounds(650, 450, 200, 30);
        fQTY.setBounds(650, 490, 200, 30);
        lVoucher.setBounds(430, 450, 200, 30);
        fVoucher.setBounds(430, 490, 200, 30);
        lTotal.setBounds(730, 540, 60, 30);
        lPrice.setBounds(790, 540, 120, 30);
        bOrder.setBounds(730, 570, 120, 30);
        lKeterangan.setBounds(600, 600, 400, 30);
        
        
        setSize(900,700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public int getQTY()
    {
        return Integer.parseInt(fQTY.getText());
    }
}
