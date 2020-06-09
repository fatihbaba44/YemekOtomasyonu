

import Entity.Restaurant;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

    private Connection connection;
    private DBConnection db;

    public List<Restaurant> getList(int page,int pageSize) {
        List<Restaurant> restaurantdaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from restaurant order by restaurantid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantid(rs.getInt("restaurantid"));
                restaurant.setRestaurantismi(rs.getString("restaurantismi"));
                restaurant.setRestaurantadres(rs.getString("restaurantadres"));
              
                restaurantdaolist.add(restaurant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return restaurantdaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(restaurantid) as restaurantcount from restaurant");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("restaurantcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(Restaurant restaurant) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into restaurant (restaurantismi) values ('" + restaurant.getRestaurantismi());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(Restaurant restaurant) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into restaurant(restaurantid,restaurantismi,restaurantadres) values('" + restaurant.getRestaurantid() + "','" + restaurant.getRestaurantismi() + "','" + restaurant.getRestaurantadres() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Restaurant restaurant) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from restaurant where restaurantid=?");
            pst.setInt(1, restaurant.getRestaurantid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Restaurant restaurant) {
        String query = "update from restaurant set restaurantismi,restaurantadres(?,?) where restaurantid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, restaurant.getRestaurantismi());
            pst.setString(2, restaurant.getRestaurantadres());
           
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

    public Restaurant restaurantIdBul(Integer restaurantId) {
        Restaurant restaurant = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from restaurantid=" + restaurantId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            restaurant = new Restaurant();
            restaurant.setRestaurantid(rs.getInt("restaurantid"));
            restaurant.setRestaurantismi(rs.getString("restaurantismi"));
            restaurant.setRestaurantadres(rs.getString("restaurantadres"));
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return restaurant;
    }
}
