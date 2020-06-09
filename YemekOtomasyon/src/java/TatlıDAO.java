

import Entity.Tatlı;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TatlıDAO {

    private Connection connection;
    private DBConnection db;

    public List<Tatlı> getList(int page,int pageSize) {
        List<Tatlı> tatlıdaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from tatlı order by tatlıid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                Tatlı tatlı = new Tatlı();
                tatlı.setTatlıid(rs.getInt("tatlıid"));
                tatlı.setTatlıismi(rs.getString("tatlıismi"));
                tatlı.setTatlıkalori(rs.getInt("tatlıkalori"));
                tatlı.setTatlıfiyat(rs.getInt("tatlıfiyat"));
                tatlıdaolist.add(tatlı);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tatlıdaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(tatlıid) as tatlıcount from tatlı");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("tatlıcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(Tatlı tatlı) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into tatlı (tatlıismi) values ('" + tatlı.getTatlıismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(Tatlı tatlı) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into tatlı(tatlıid,tatlıismi,tatlıkalori,tatlıfiyat) values('" + tatlı.getTatlıid() + "','" + tatlı.getTatlıismi() + "','" + tatlı.getTatlıkalori() + "','" + tatlı.getTatlıfiyat() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Tatlı tatlı) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from tatlı where tatlıid=?");
            pst.setInt(1, tatlı.getTatlıid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Tatlı tatlı) {
        String query = "update from tatlı set tatlıismi,tatlıkalori,tatlıfiyat (?,?,?) where tatlıid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, tatlı.getTatlıismi());
            pst.setInt(2, tatlı.getTatlıkalori());
            pst.setInt(3, tatlı.getTatlıfiyat());
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

    public Tatlı tatlıIdBul(Integer tatlıId) {
        Tatlı tatlı = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from tatlıid=" + tatlıId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            tatlı = new Tatlı();
            tatlı.setTatlıid(rs.getInt("tatlıid"));
            tatlı.setTatlıismi(rs.getString("tatlıismi"));
            tatlı.setTatlıkalori(rs.getInt("tatlıkalori"));
            tatlı.setTatlıfiyat(rs.getInt("tatlıfiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tatlı;
    }
}

