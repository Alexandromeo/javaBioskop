package projek.praktikum.akhir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VRegister extends JFrame
{
    JLabel lTitle, lEmail, lPass, lRole;
    JTextField fEmail;
    JPasswordField fPass;
    JButton bRegis;
    JLabel lLogin;
    JComboBox fRole;
    public VRegister()
    {
        setTitle("Halaman Pendaftaran");     
        lTitle = new JLabel("Pendaftaran");
        lEmail = new JLabel("Email");
        lPass = new JLabel("Password");
        fEmail = new JTextField();
        fPass = new JPasswordField();
        bRegis = new JButton("Daftar");
        lLogin = new JLabel("Masuk");
        
        lRole = new JLabel("Role");
        fRole = new JComboBox(new Object[] {
            "Admin","Pelanggan"
        });
        
        setLayout(null);
        add(lTitle);
        add(lEmail);
        add(fEmail);
        add(lPass);
        add(fPass);
        add(lRole);
        add(fRole);
        add(bRegis);
        add(lLogin);
        
        //x, y, width, height
        lTitle.setBounds(280,30,80,30);
        lEmail.setBounds(150,80,80,30);
        fEmail.setBounds(240,80,200,30);
        lPass.setBounds(150,130,80,30);
        fPass.setBounds(240,130,200,30);
        lRole.setBounds(150, 180, 80, 30);
        fRole.setBounds(240, 180, 200, 30);
        bRegis.setBounds(260, 240, 100, 30);
        lLogin.setBounds(290, 270, 100, 30);
        
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
