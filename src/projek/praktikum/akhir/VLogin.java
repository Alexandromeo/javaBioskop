package projek.praktikum.akhir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class VLogin extends JFrame
{
    JLabel lTitle, lEmail, lPass;
    JTextField fEmail;
    JPasswordField fPass;
    JButton bLogin;
    JLabel lRegis;
    String anu = "HALO";
    public VLogin()
    {
        setTitle("Halaman Masuk");     
        lTitle = new JLabel("Masuk");
        lEmail = new JLabel("Email");
        lPass = new JLabel("Password");
        fEmail = new JTextField();
        fPass = new JPasswordField();
        bLogin = new JButton("Masuk");
        lRegis = new JLabel("Belum punya akun?");
        
        setLayout(null);
        add(lTitle);
        add(lEmail);
        add(fEmail);
        add(lPass);
        add(fPass);
        add(bLogin);
        add(lRegis);
        
        //x, y, width, height
        lTitle.setBounds(280,30,80,30);
        lEmail.setBounds(150,80,80,30);
        fEmail.setBounds(240,80,200,30);
        lPass.setBounds(150,130,80,30);
        fPass.setBounds(240,130,200,30);
        bLogin.setBounds(260,190,100,30);
        lRegis.setBounds(260,220,150,30);
        
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
