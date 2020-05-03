package projek.praktikum.akhir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class CRegister 
{
    VRegister view;
    MRegister model;
    public CRegister(VRegister view, MRegister model)
    {
        this.view = view;
        this.model = model;
        view.bRegis.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String email = view.fEmail.getText();
                String pass = view.fPass.getText();
                String role = (String) view.fRole.getSelectedItem();
                
                int roleID = 0;
                if(role.equals("Admin"))
                    roleID = 1;
                else if(role.equals("Pelanggan"))
                    roleID = 2;
                
                if(!email.equals("") && !pass.equals(""))
                {
                    int registerStatus = model.getUser(email, roleID);
                    if(registerStatus > 0)
                    {
                        int insert = model.insertUser(email, pass, roleID);
                        if(insert == 1)
                        {
                            JOptionPane.showMessageDialog(null,
                                "Data berhasil ditambahkan");
                            view.setVisible(false);
                            if(roleID == 1)
                            {
                                VDashboardAdmin v = new VDashboardAdmin();
                                new CDashboardAdmin(v);
                            }
                            
                            else if(roleID == 2)
                            {
                                VDashboardUser view = new VDashboardUser();
                                new CDashboardUser(view);
                            }   
                        }

                        else if(insert == 0)
                            JOptionPane.showMessageDialog(null,
                                "Terjadi kesalahan teknis. Mohon tunggu sejenak");
                    }
                    else if(registerStatus == 0)
                        JOptionPane.showMessageDialog(null,
                                "User dengan email "+email+" sudah terdaftar sebelumnya");
                    else if(registerStatus == -1)
                        JOptionPane.showMessageDialog(null,
                                "Terjadi kesalahan teknis. Mohon tunggu sejenak");
                }
                
                else
                    JOptionPane.showMessageDialog(null,
                                "Seluruh data harus diisi");
            }
        });
        
        view.lLogin.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e) 
            {
                view.setVisible(false);
                VLogin v = new VLogin();
                MLogin m = new MLogin();
                new CLogin(v, m);
            }
        });
    }
}
