

import Entity.AraYemek;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AraYemekDAO {

    private Connection connection;
    private DBConnection db;

    public List<AraYemek> getList(int page,int pageSize) {
        List<AraYemek> arayemekdaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from arayemek order by arayemekid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                AraYemek arayemek = new AraYemek();
                arayemek.setArayemekid(rs.getInt("arayemekid"));
                arayemek.setArayemekismi(rs.getString("arayemekismi"));
                arayemek.setArayemekkalori(rs.getInt("arayemekkalori"));
                arayemek.setArayemekfiyat(rs.getInt("arayemekfiyat"));
                arayemekdaolist.add(arayemek);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arayemekdaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(arayemekid) as arayemekcount from arayemek");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("arayemekcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(AraYemek arayemek) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into arayemek (arayemekismi) values ('" + arayemek.getArayemekismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(AraYemek arayemek) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into arayemek(arayemekid,arayemekismi,arayemekkalori,arayemekfiyat) values('" + arayemek.getArayemekid() + "','" + arayemek.getArayemekismi() + "','" + arayemek.getArayemekkalori() + "','" + arayemek.getArayemekfiyat() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(AraYemek arayemek) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from arayemek where arayemekid=?");
            pst.setInt(1, arayemek.getArayemekid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(AraYemek arayemek) {
        String query = "update from arayemek set arayemekismi,arayemekkalori,arayemekfiyat (?,?,?) where arayemekid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, arayemek.getArayemekismi());
            pst.setInt(2, arayemek.getArayemekkalori());
            pst.setInt(3, arayemek.getArayemekfiyat());
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

    public AraYemek arayemekIdBul(Integer arayemekId) {
        AraYemek arayemek = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from arayemekid=" + arayemekId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            arayemek = new AraYemek();
            arayemek.setArayemekid(rs.getInt("arayemekid"));
            arayemek.setArayemekismi(rs.getString("arayemekismi"));
            arayemek.setArayemekkalori(rs.getInt("arayemekkalori"));
            arayemek.setArayemekfiyat(rs.getInt("arayemekfiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arayemek;
    }
}
