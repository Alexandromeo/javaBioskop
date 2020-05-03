/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.praktikum.akhir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import projek.praktikum.akhir.CDashboardAdmin;

public class CSidebarAction{
    static final String sessEmail = CSession.getSessionEmail();
    
    
    //di homepage
    public static void sidebarAction(VDashboardAdmin view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail());        
        
        
        
        //ketika tombol beranda diklik
        view.bHome.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent ae) 
           {
               view.setVisible(false);
               VDashboardAdmin v = new VDashboardAdmin();
               new CDashboardAdmin(v);
           }
        });
        
        
        //ketika tombol promo diklik
        view.bPromo.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VPromo view = new VPromo();
               CDashboardAdmin.showPromo(view);
           }
        });
        
        
        //ketika tombol transaksi diklik
        view.bTransaksi.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VTransaksi view = new VTransaksi();
               CDashboardAdmin.showTransaksi(view);
           }
        });
        
        
        //ketika tombol user diklik
        view.bUser.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VUser view = new VUser();
               CDashboardAdmin.showUser(view);
           }
        });
        
        //ketika tombol logout diklik
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
    
    
    //di halaman add film
    public static void sidebarAction(VAddMovie view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail());        
        
        
        
        //ketika tombol beranda diklik
        view.bHome.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent ae) 
           {
               view.setVisible(false);
               VDashboardAdmin v = new VDashboardAdmin();
               new CDashboardAdmin(v);
           }
        });
        
        
        //ketika tombol promo diklik
        view.bPromo.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VPromo view = new VPromo();
               CDashboardAdmin.showPromo(view);
           }
        });
        
        
        //ketika tombol transaksi diklik
        view.bTransaksi.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VTransaksi view = new VTransaksi();
               CDashboardAdmin.showTransaksi(view);
           }
        });
        
        
        //ketika tombol user diklik
        view.bUser.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VUser view = new VUser();
               CDashboardAdmin.showUser(view);
           }
        });
        
        //ketika tombol logout diklik
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
    
    //di halaman promo
    public static void sidebarAction(VAddPromo view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail());        
        
        
        
        //ketika tombol beranda diklik
        view.bHome.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent ae) 
           {
               view.setVisible(false);
               VDashboardAdmin v = new VDashboardAdmin();
               new CDashboardAdmin(v);
           }
        });
        
        
        //ketika tombol promo diklik
        view.bPromo.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VPromo view = new VPromo();
               CDashboardAdmin.showPromo(view);
           }
        });
        
        
        //ketika tombol transaksi diklik
        view.bTransaksi.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VTransaksi view = new VTransaksi();
               CDashboardAdmin.showTransaksi(view);
           }
        });
        
        
        //ketika tombol user diklik
        view.bUser.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VUser view = new VUser();
               CDashboardAdmin.showUser(view);
           }
        });
        
        //ketika tombol logout diklik
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
    
     //di halaman promo
    public static void sidebarAction(VPromo view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail());        
        
        
        
        //ketika tombol beranda diklik
        view.bHome.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent ae) 
           {
               view.setVisible(false);
               VDashboardAdmin v = new VDashboardAdmin();
               new CDashboardAdmin(v);
           }
        });
        
        
        //ketika tombol promo diklik
        view.bPromo.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VPromo view = new VPromo();
               CDashboardAdmin.showPromo(view);
           }
        });
        
        
        //ketika tombol transaksi diklik
        view.bTransaksi.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VTransaksi view = new VTransaksi();
               CDashboardAdmin.showTransaksi(view);
           }
        });
        
        
        //ketika tombol user diklik
        view.bUser.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VUser view = new VUser();
               CDashboardAdmin.showUser(view);
           }
        });
        
        //ketika tombol logout diklik
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
    
    public static void sidebarAction(VUser view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail());        
        
        
        
        //ketika tombol beranda diklik
        view.bHome.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent ae) 
           {
               view.setVisible(false);
               VDashboardAdmin v = new VDashboardAdmin();
               new CDashboardAdmin(v);
           }
        });
        
        
        //ketika tombol promo diklik
        view.bPromo.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VPromo view = new VPromo();
               CDashboardAdmin.showPromo(view);
           }
        });
        
        
        //ketika tombol transaksi diklik
        view.bTransaksi.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VTransaksi view = new VTransaksi();
               CDashboardAdmin.showTransaksi(view);
           }
        });
        
        
        //ketika tombol user diklik
        view.bUser.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VUser view = new VUser();
               CDashboardAdmin.showUser(view);
           }
        });
        
        //ketika tombol logout diklik
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
    
    public static void sidebarAction(VTransaksi view)
    {
        if(!sessEmail.equals(""))
            view.uProfile.setText(CSession.getSessionEmail());        
        
        
        
        //ketika tombol beranda diklik
        view.bHome.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent ae) 
           {
               view.setVisible(false);
               VDashboardAdmin v = new VDashboardAdmin();
               new CDashboardAdmin(v);
           }
        });
        
        
        //ketika tombol promo diklik
        view.bPromo.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VPromo view = new VPromo();
               CDashboardAdmin.showPromo(view);
           }
        });
        
        
        //ketika tombol transaksi diklik
        view.bTransaksi.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VTransaksi view = new VTransaksi();
               CDashboardAdmin.showTransaksi(view);
           }
        });
        
        
        //ketika tombol user diklik
        view.bUser.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               view.setVisible(false);
               VUser view = new VUser();
               CDashboardAdmin.showUser(view);
           }
        });
        
        //ketika tombol logout diklik
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
