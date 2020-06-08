

import Entity.Sağlıklı;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SağlıklıDAO {

    private Connection connection;
    private DBConnection db;

    public List<Sağlıklı> getList(int page,int pageSize) {
        List<Sağlıklı> sağlıklıdaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from sağlıklı order by saglikliid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                Sağlıklı sağlıklı = new Sağlıklı();
                sağlıklı.setSaglikliid(rs.getInt("saglikliid"));
                sağlıklı.setSaglikliismi(rs.getString("saglikliismi"));
                sağlıklı.setSagliklikalori(rs.getInt("sagliklikalori"));
                sağlıklı.setSagliklifiyat(rs.getInt("sagliklifiyat"));
                sağlıklıdaolist.add(sağlıklı);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sağlıklıdaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(saglikliid) as sağlıklıcount from sağlıklı");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("sağlıklıcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(Sağlıklı sağlıklı) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into sağlıklı (saglikliismi) values ('" + sağlıklı.getSaglikliismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(Sağlıklı sağlıklı) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into sağlıklı(saglikliid,saglikliismi,sagliklikalori,sagliklifiyat) values('" + sağlıklı.getSaglikliid() + "','" + sağlıklı.getSaglikliismi() + "','" + sağlıklı.getSagliklikalori() + "','" + sağlıklı.getSagliklifiyat() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Sağlıklı sağlıklı) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from sağlıklı where saglikliid=?");
            pst.setInt(1, sağlıklı.getSaglikliid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Sağlıklı sağlıklı) {
        String query = "update from sağlıklı set saglikliismi,sagliklikalori,sagliklifiyat (?,?,?) where saglikliid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, sağlıklı.getSaglikliismi());
            pst.setInt(2, sağlıklı.getSagliklikalori());
            pst.setInt(3, sağlıklı.getSagliklifiyat());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = DBConnection.connect();
        }
        return connection;
    }

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public Sağlıklı sağlıklıIdBul(Integer sağlıklıId) {
        Sağlıklı sağlıklı = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from saglikliid=" + sağlıklıId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            sağlıklı = new Sağlıklı();
            sağlıklı.setSaglikliid(rs.getInt("saglikliid"));
            sağlıklı.setSaglikliismi(rs.getString("saglikliismi"));
            sağlıklı.setSagliklikalori(rs.getInt("sagliklikalori"));
            sağlıklı.setSagliklifiyat(rs.getInt("sagliklifiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sağlıklı;
    }
}
