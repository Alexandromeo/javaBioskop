package projek.praktikum.akhir;

public class ProjekPraktikumAkhir 
{
    public static void main(String[] args) 
    {
        VRegister v = new VRegister();
        MRegister m = new MRegister();
        CRegister cRegister = new CRegister(v, m);
    } 
}
