

import Entity.FastFood;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FastFoodDAO {

    private Connection connection;
    private DBConnection db;

    public List<FastFood> getList(int page,int pageSize) {
        List<FastFood> fastfooddaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from fastfood order by fastfoodid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                FastFood fastfood = new FastFood();
                fastfood.setFastfoodid(rs.getInt("fastfoodid"));
                fastfood.setFastfoodismi(rs.getString("fastfoodismi"));
                fastfood.setFastfoodkalori(rs.getInt("fastfoodkalori"));
                fastfood.setFastfoodfiyat(rs.getInt("fastfoodfiyat"));
                fastfooddaolist.add(fastfood);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fastfooddaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(fastfoodid) as fastfoodcount from fastfood");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("fastfoodcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(FastFood fastfood) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into fastfood (fastfoodismi) values ('" + fastfood.getFastfoodismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(FastFood fastfood) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into fastfood(fastfoodid,fastfoodismi,fastfoodkalori,fastfoodfiyat) values('" + fastfood.getFastfoodid() + "','" + fastfood.getFastfoodismi() + "','" + fastfood.getFastfoodkalori() + "','" + fastfood.getFastfoodfiyat() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(FastFood fastfood) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from fastfood where fastfoodid=?");
            pst.setInt(1, fastfood.getFastfoodid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(FastFood fastfood) {
        String query = "update from fastfood set fastfoodismi,fastfoodkalori,fastfoodfiyat (?,?,?) where fastfoodid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, fastfood.getFastfoodismi());
            pst.setInt(2, fastfood.getFastfoodkalori());
            pst.setInt(3, fastfood.getFastfoodfiyat());
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

    public FastFood fastfoodIdBul(Integer fastfoodId) {
        FastFood fastfood = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from fastfoodid=" + fastfoodId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            fastfood = new FastFood();
            fastfood.setFastfoodid(rs.getInt("fastfoodid"));
            fastfood.setFastfoodismi(rs.getString("fastfoodismi"));
            fastfood.setFastfoodkalori(rs.getInt("fastfoodkalori"));
            fastfood.setFastfoodfiyat(rs.getInt("fastfoodfiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return fastfood;
    }
}
