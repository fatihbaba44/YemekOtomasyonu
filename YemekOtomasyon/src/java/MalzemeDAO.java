

import Entity.Malzeme;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MalzemeDAO {

    private Connection connection;
    private DBConnection db;

    public List<Malzeme> getList(int page,int pageSize) {
        List<Malzeme> malzemedaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from malzeme order by malzemeid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                Malzeme malzeme = new Malzeme();
                malzeme.setMalzemeid(rs.getInt("malzemeid"));
                malzeme.setMalzemeismi(rs.getString("malzemeismi"));
                malzeme.setMalzemekalori(rs.getInt("malzemekalori"));
                malzeme.setMalzemefiyat(rs.getInt("malzemefiyat"));
                malzemedaolist.add(malzeme);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return malzemedaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(malzemeid) as malzemecount from malzeme");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("malzemecount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(Malzeme malzeme) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into malzeme (malzemeismi) values ('" + malzeme.getMalzemeismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(Malzeme malzeme) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into malzeme(malzemeid,malzemeismi,malzemekalori,malzemefiyat) values('" + malzeme.getMalzemeid() + "','" + malzeme.getMalzemeismi() + "','" + malzeme.getMalzemekalori() + "','" + malzeme.getMalzemefiyat() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Malzeme malzeme) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from malzeme where malzemeid=?");
            pst.setInt(1, malzeme.getMalzemeid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Malzeme malzeme) {
        String query = "update from malzeme set malzemeismi,malzemekalori,malzemefiyat (?,?,?) where malzemeid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, malzeme.getMalzemeismi());
            pst.setInt(2, malzeme.getMalzemekalori());
            pst.setInt(3, malzeme.getMalzemefiyat());
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

    public Malzeme malzemeIdBul(Integer malzemeId) {
        Malzeme malzeme = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from malzemeid=" + malzemeId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            malzeme = new Malzeme();
            malzeme.setMalzemeid(rs.getInt("malzemeid"));
            malzeme.setMalzemeismi(rs.getString("malzemeismi"));
            malzeme.setMalzemekalori(rs.getInt("malzemekalori"));
            malzeme.setMalzemefiyat(rs.getInt("malzemefiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return malzeme;
    }
}
