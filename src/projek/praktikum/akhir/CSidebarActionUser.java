package projek.praktikum.akhir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CSidebarActionUser 
{
    static final String sessEmail = CSession.getSessionEmail();
    public static void sidebarAction(VDashboardUser view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail()); 
        
        view.bHome.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VDashboardUser v = new VDashboardUser();
                new CDashboardUser(v);
            }
        });
        
        view.bTransaksi.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VTransaksiUser v = new VTransaksiUser();
                CDashboardUser.showTransaksi(v);
            }
        });
        
        view.bSaldo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VShowSaldoUser v = new VShowSaldoUser();
                CDashboardUser.showSaldo(v);
            }
        });
        
        
        view.bLogout.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               int logout = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Pilih Opsi", JOptionPane.YES_NO_OPTION);
                if(logout==0) //jika user klik yes
                {
                    JOptionPane.showMessageDialog(null, "Berhasil keluar");
                    view.setVisible(false);
                    VLogin v = new VLogin();
                    MLogin m = new MLogin();
                    new CLogin(v, m);
                }
           }
        });
    }
    
    public static void sidebarAction(VTransaksiUser view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail()); 
        
        view.bHome.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VDashboardUser v = new VDashboardUser();
                new CDashboardUser(v);
            }
        });
        
        view.bTransaksi.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VTransaksiUser v = new VTransaksiUser();
                CDashboardUser.showTransaksi(v);
            }
        });
        
        view.bSaldo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VShowSaldoUser v = new VShowSaldoUser();
                CDashboardUser.showSaldo(v);
            }
        });
        
        
        view.bLogout.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               int logout = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Pilih Opsi", JOptionPane.YES_NO_OPTION);
                if(logout==0) //jika user klik yes
                {
                    JOptionPane.showMessageDialog(null, "Berhasil keluar");
                    view.setVisible(false);
                    VLogin v = new VLogin();
                    MLogin m = new MLogin();
                    new CLogin(v, m);
                }
           }
        });
    }
    
    public static void sidebarAction(VShowSaldoUser view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail()); 
        
        view.bHome.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VDashboardUser v = new VDashboardUser();
                new CDashboardUser(v);
            }
        });
        
        view.bTransaksi.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VTransaksiUser v = new VTransaksiUser();
                CDashboardUser.showTransaksi(v);
            }
        });
        
        view.bSaldo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.setVisible(false);
                VShowSaldoUser v = new VShowSaldoUser();
                CDashboardUser.showSaldo(v);
            }
        });
        
        
        view.bLogout.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               int logout = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Pilih Opsi", JOptionPane.YES_NO_OPTION);
                if(logout==0) //jika user klik yes
                {
                    JOptionPane.showMessageDialog(null, "Berhasil keluar");
                    view.setVisible(false);
                    VLogin v = new VLogin();
                    MLogin m = new MLogin();
                    new CLogin(v, m);
                }
           }
        });
    }
}
