package projek.praktikum.akhir;

import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VAddPromo extends JFrame {
    JLabel uProfile, lTitle;
    JButton bHome, bPromo, bTransaksi, bLogout, bUser;
    
    
    //dinamis
    JLabel lName, lDiscount, lDuration;
    private JTextField fName, fDiscount, fDuration;
    JButton bAddPromo;
    public VAddPromo()
    {
        setTitle("Dashboard");
        lTitle = new JLabel("Bioskop Onlen");
        uProfile = new JLabel("Profile");
        bHome = new JButton("Beranda");
        bPromo = new JButton("Promo");
        bTransaksi = new JButton("Transaksi");
        bUser = new JButton("Pengguna");
        bLogout = new JButton("Keluar");
        
        
        //dinamis
        lName = new JLabel("Kode Promo");
        lDiscount = new JLabel("Besar diskon (%)");
        lDuration = new JLabel("Durasi (hari)");
        fName = new JTextField();
        fDiscount = new JTextField();
        fDuration = new JTextField();
        bAddPromo = new JButton("Tambahkan");
        
        setLayout(null);
        add(lTitle);
        add(uProfile);
        add(bHome);
        add(bPromo);
        add(bTransaksi);
        add(bUser);
        add(bLogout);
        
        //dinamis
        add(lName);
        add(lDiscount);
        add(lDuration);
        add(fName);
        add(fDiscount);
        add(fDuration);
        add(bAddPromo);
        
        
        //x,y,width,height
        lTitle.setBounds(30, 10, 140, 30);
        uProfile.setBounds(650, 10, 200, 30);
        bHome.setBounds(0, 50, 140, 30);
        bPromo.setBounds(0, 80, 140, 30);
        bTransaksi.setBounds(0, 110, 140, 30);
        bUser.setBounds(0, 140, 140, 30);
        bLogout.setBounds(0, 170, 140, 30);
        
        
        //dinamis
        lName.setBounds(170, 50, 100, 30);
        fName.setBounds(280, 50, 200, 30);
        lDiscount.setBounds(170, 90, 100, 30);
        fDiscount.setBounds(280, 90, 200, 30);
        lDuration.setBounds(170, 130, 100, 30);
        fDuration.setBounds(280, 130, 200, 30);
        bAddPromo.setBounds(500, 50, 150, 30);
        
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getName()
    {
        return fName.getText();
    }
    
    public String getDiscount()
    {
        return fDiscount.getText();
    }
    
    public String getDuration()
    {
        return fDuration.getText();
    }
}
