
package doviz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB 
{

    Connection conn;
    Statement s;
    
    public DB() throws Exception
    {
        Class.forName("org.sqlite.JDBC");  
        conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hgb\\Desktop\\doviz.db");
        
        
        // Tablo Olusturma
        
        s = conn.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS KURLAR (AD TEXT, ALIS TEXT, SATIS TEXT)");
        
        
        
        String sil = "Delete from kurlar";
        s = conn.createStatement();
        s.execute(sil);
    }
    
    public void addKur(String sql) throws Exception
    {
        
        s = conn.createStatement();
        s.execute(sql);
        
    }
    
    public ResultSet getKurAdlari() throws Exception
    {
        s = conn.createStatement();
        ResultSet rs = s.executeQuery("select ad from kurlar");
        return rs;
    }
    
    public ResultSet getKurAdi(String ad) throws Exception
    {
        s = conn.createStatement();
        ResultSet rs = s.executeQuery("select * from kurlar where AD='"+ad+"'");
        return rs;
    }

    /**
     *
     */
    
    
}
