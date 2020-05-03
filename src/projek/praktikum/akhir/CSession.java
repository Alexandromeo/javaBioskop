
package projek.praktikum.akhir;

public class CSession 
{
    private static String email;
    private static int role;
    protected static void setSession(String email, int role)
    {
        CSession.email = email;
        CSession.role = role;
    }
    
    public static String getSessionEmail()
    {
        return CSession.email;
    }
    
    public static int getSessionRole()
    {
        return CSession.role;
    }
}
