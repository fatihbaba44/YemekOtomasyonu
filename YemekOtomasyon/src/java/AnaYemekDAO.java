

import Entity.AnaYemek;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnaYemekDAO {

    private Connection connection;
    private DBConnection db;

    public List<AnaYemek> getList(int page,int pageSize) {
        List<AnaYemek> anayemekdaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from anayemek order by anayemekid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                AnaYemek anayemek = new AnaYemek();
                anayemek.setAnayemekid(rs.getInt("anayemekid"));
                anayemek.setAnayemekismi(rs.getString("anayemekismi"));
                anayemek.setAnayemekkalori(rs.getInt("anayemekkalori"));
                anayemek.setAnayemekfiyat(rs.getInt("anayemekfiyat"));
                anayemekdaolist.add(anayemek);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return anayemekdaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(anayemekid) as anayemekcount from anayemek");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("anayemekcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(AnaYemek anayemek) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into anayemek (anayemekismi) values ('" + anayemek.getAnayemekismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(AnaYemek anayemek) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into anayemek(anayemekid,anayemekismi,anayemekkalori,anayemekfiyat) values('" + anayemek.getAnayemekid() + "','" + anayemek.getAnayemekismi() + "','" + anayemek.getAnayemekkalori() + "','" + anayemek.getAnayemekfiyat() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(AnaYemek anayemek) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from anayemek where anayemekid=?");
            pst.setInt(1, anayemek.getAnayemekid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(AnaYemek anayemek) {
        String query = "update from anayemek set anayemekismi,anayemekkalori,anayemekfiyat (?,?,?) where anayemekid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, anayemek.getAnayemekismi());
            pst.setInt(2, anayemek.getAnayemekkalori());
            pst.setInt(3, anayemek.getAnayemekfiyat());
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

    public AnaYemek anayemekIdBul(Integer anayemekId) {
        AnaYemek anayemek = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from anayemekid=" + anayemekId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            anayemek = new AnaYemek();
            anayemek.setAnayemekid(rs.getInt("anayemekid"));
            anayemek.setAnayemekismi(rs.getString("anayemekismi"));
            anayemek.setAnayemekkalori(rs.getInt("anayemekkalori"));
            anayemek.setAnayemekfiyat(rs.getInt("anayemekfiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return anayemek;
    }
}
