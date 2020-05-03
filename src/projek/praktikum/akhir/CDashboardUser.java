package projek.praktikum.akhir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CDashboardUser {
    MDashboardUser model = new MDashboardUser();
    public CDashboardUser(VDashboardUser view)
    {
        homePage(view);
    }
    
    private void homePage(VDashboardUser view)
    {
        //ketika tambah film diklik
        CSidebarActionUser.sidebarAction(view);
        String dataFilm[][] = model.getMovie();
        if(dataFilm != null)
        {
            view.tMovie.setModel(new JTable(dataFilm, view.headTable).getModel());
        }
        
        else
            System.out.println("Data tidak ada ");
        
        double saldo = model.getSaldo();
        view.lPriceSaldo.setText(""+saldo);
        
        view.tMovie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double total = 0;
                super.mousePressed(e);
                int baris = view.tMovie.getSelectedRow();
                int kolom = view.tMovie.getSelectedColumn();

                int idFilm = Integer.parseInt(view.tMovie.getValueAt(baris, 0).toString());
                String dataFilm[] = model.getMovieById(idFilm);
                
                int QTY = view.getQTY();
                String kodePromo = view.fVoucher.getText();
                int diskon = model.getVoucherByName(kodePromo);
                int hargaFilm = Integer.parseInt(dataFilm[2]);
                total = hargaFilm*QTY*(100-diskon)/100;
                view.lPrice.setText(""+total);
                
                
                System.out.println("Harga film : "+hargaFilm);
                System.out.println("QTY : "+QTY);
                System.out.println("Dis : "+diskon);
                System.out.println("Kode : "+kodePromo);
            }
        });
        
        view.bOrder.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               System.out.println("action buttotn sudah ada");
               int baris = view.tMovie.getSelectedRow();
               int kolom = view.tMovie.getSelectedColumn();

               double total = Double.parseDouble(view.lPrice.getText());
               double saldo = Double.parseDouble(view.lPriceSaldo.getText());
               
               String kodePromo = view.fVoucher.getText();
               
               int idFilm = Integer.parseInt(view.tMovie.getValueAt(baris, 0).toString());
               int QTY = view.getQTY();
               int voucher = model.getIDVoucherByName(kodePromo);
               int idUser = model.getIDUserByEmail(CSession.getSessionEmail());
               if(total <= saldo)
               {
                   int insert = model.insertTransaksi(idUser, idFilm, QTY, voucher);
                   if(insert == 1)
                   {
                       model.kurangiSaldo(total);
                       JOptionPane.showMessageDialog(null, "Berhasil melakukan transaksi");
                       homePage(view);
                   }
                   
                   else
                       JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam transaksi");
               }
               
               else
                   JOptionPane.showMessageDialog(null, "Saldo Anda kurang untuk membelinya");
           }
        });
    }
    
    public static void showTransaksi(VTransaksiUser view)
    {
        MDashboardUser model = new MDashboardUser();
        CSidebarActionUser.sidebarAction(view);
        String dataTransaksi[][] = model.getTransaksi();
        if(dataTransaksi != null)
        {
            view.tTransaksi.setModel(new JTable(dataTransaksi, view.headTable).getModel());
        }
        
        else
            System.out.println("Data tidak ada ");
    }
    
    public static void showSaldo(VShowSaldoUser view)
    {
        MDashboardUser model = new MDashboardUser();
        CSidebarActionUser.sidebarAction(view);
        double dataSaldo = model.getSaldo();
        view.lSaldo.setText("Saldo : Rp"+dataSaldo);
        
        view.bTopUp.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               double saldo = view.getSaldo();
               if(saldo > 0)
               {
                   int topup = model.topUp(saldo);
                   if(topup > 0)
                   {
                       JOptionPane.showMessageDialog(null, "Berhasil melakukan topup");
                       view.fSaldo.setText("");
                       showSaldo(view);
                   }
                   else
                       JOptionPane.showMessageDialog(null, "Terjadi kesalahan yang tidak diketahui. Cobalah beberapa saat lagi");
               }
               
               else
                   JOptionPane.showMessageDialog(null, "Nominal yang dimasukkan harus lebih dari Rp0");
           }
        });
    }
}