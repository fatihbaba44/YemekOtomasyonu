

import Entity.İçecek;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class İçecekDAO {

    private Connection connection;
    private DBConnection db;

    public List<İçecek> getList(int page,int pageSize) {
        List<İçecek> içecekdaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from içecek order by içecekid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                İçecek içecek = new İçecek();
                içecek.setIçecekid(rs.getInt("içecekid"));
                içecek.setIçecekismi(rs.getString("içecekismi"));
                içecek.setIçecekkalori(rs.getInt("içecekkalori"));
                içecek.setIçecekboyut(rs.getString("içecekboyut"));
                içecek.setIçecekfiyat(rs.getInt("içecekfiyat"));
                içecekdaolist.add(içecek);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return içecekdaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(içecekid) as içecekcount from içecek");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("içecekcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(İçecek içecek) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into içecek (içecekismi) values ('" + içecek.getIçecekismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(İçecek içecek) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into içecek(içecekid,içecekismi,içecekkalori,içecekfiyat) values('" + içecek.getIçecekid() + "','" + içecek.getIçecekismi() + "','" + içecek.getIçecekkalori() + "','"+içecek.getIçecekboyut()+"','" + içecek.getIçecekfiyat() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(İçecek içecek) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from içecek where içecekid=?");
            pst.setInt(1, içecek.getIçecekid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(İçecek içecek) {
        String query = "update from içecek set içecekismi,içecekkalori,içecekboyut,içecekfiyat (?,?,?,?) where içecekid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, içecek.getIçecekismi());
            pst.setInt(2, içecek.getIçecekkalori());
            pst.setInt(3, içecek.getIçecekfiyat());
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

    public İçecek içecekIdBul(Integer içecekId) {
        İçecek içecek = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from içecekid=" + içecekId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            içecek = new İçecek();
            içecek.setIçecekid(rs.getInt("içecekid"));
            içecek.setIçecekismi(rs.getString("içecekismi"));
            içecek.setIçecekkalori(rs.getInt("içecekkalori"));
            içecek.setIçecekboyut(rs.getString("içecekboyut"));
            içecek.setIçecekfiyat(rs.getInt("içecekfiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return içecek;
    }
}
