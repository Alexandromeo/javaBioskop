package projek.praktikum.akhir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class CLogin 
{
    VLogin view;
    MLogin model;
    public CLogin(VLogin view, MLogin model)
    {
        view.bLogin.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String email = view.fEmail.getText();
                String pass = view.fPass.getText();
                if(!email.equals("") && !pass.equals(""))
                {
                    int checkUser = model.checkUser(email, pass);
                    if(checkUser == 2) //jika pelanggan
                    {
                        JOptionPane.showMessageDialog(null, "Anda berhasil masuk");
                        view.setVisible(false);
                        VDashboardUser view = new VDashboardUser();
                        new CDashboardUser(view);
                    }
                    
                    else if(checkUser == 1) //jika admin
                    {
                        JOptionPane.showMessageDialog(null, "Anda berhasil masuk");
                        view.setVisible(false);
                        VDashboardAdmin v = new VDashboardAdmin();
                        new CDashboardAdmin(v);
                    }

                    else if(checkUser == 0)
                        JOptionPane.showMessageDialog(null,
                                "Email belum terdaftar");

                    else if(checkUser == -1)
                        JOptionPane.showMessageDialog(null,
                                "Terjadi kesalahan teknis. Mohon tunggu sejenak");

                    else if(checkUser == -2)
                        JOptionPane.showMessageDialog(null,
                                "Password yang dimasukkan salah");
                }
                
                else
                    JOptionPane.showMessageDialog(null,
                                "Email dan password harus diisi");
            }
        });
        
        view.lRegis.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e) 
            {
                view.setVisible(false);
                VRegister v = new VRegister();
                MRegister m = new MRegister();
                new CRegister(v, m);
            }
        });
    }
}
