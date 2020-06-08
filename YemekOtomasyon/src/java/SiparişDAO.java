

import Entity.Sipariş;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SiparişDAO {

    private Connection connection;
    private DBConnection db;

    public List<Sipariş> getList(int page,int pageSize) {
        List<Sipariş> siparişdaolist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select * from sipariş order by siparisid asc limit"+start+","+pageSize);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                Sipariş sipariş = new Sipariş();
                sipariş.setSiparisid(rs.getInt("siparisid"));
                sipariş.setSiparisverenkisiad(rs.getString("siparisverenkisiad"));
                sipariş.setSiparisverenkisisoyad(rs.getString("siparisverenkisisoyad"));
                sipariş.setSiparisalınmatarihi(rs.getDate("siparisalınmatarihi"));
               sipariş.setSiparisverilmetarihi(rs.getDate("siparisverilmetarihi"));
               sipariş.setSiparisverentelno(rs.getInt("siparisverentelno"));
         



                siparişdaolist.add(sipariş);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return siparişdaolist;
    }
    
    public int count() {
       int count=0;
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(siparisid) as siparişcount from sipariş");
            ResultSet rs= pst.executeQuery();
            rs.next();
            count=rs.getInt("siparişcount");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void insert(Sipariş sipariş) {
        try {
            Connection c = DBConnection.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into sipariş (siparisverenkisiad) values ('" + sipariş.getSiparisverenkisiad());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(Sipariş sipariş) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into sipariş(siparisid,siparişismi,siparişkalori,siparişfiyat) values('" + sipariş.getSiparisid() + "','" + sipariş.getSiparisverenkisiad() + "','" + sipariş.getSiparisverenkisisoyad()+ "','" + sipariş.getSiparisalınmatarihi() + "','"+sipariş.getSiparisverilmetarihi()+"','"+sipariş.getSiparisverentelno()+"')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Sipariş sipariş) {

       try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from sipariş where siparisid=?");
            pst.setInt(1, sipariş.getSiparisid());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Sipariş sipariş) {
        String query = "update from sipariş set siparisverenkisiad,siparisverenkisisoyad,siparisalınmatarihi,siparisverilmetarihi,siparisverentelno (?,?,?,?,?) where siparisid=?";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, sipariş.getSiparisverenkisiad());
            pst.setString(2, sipariş.getSiparisverenkisisoyad());
            pst.setDate(3, (Date) sipariş.getSiparisalınmatarihi());
            pst.setDate(4, (Date) sipariş.getSiparisverilmetarihi());
            pst.setInt(5, sipariş.getSiparisverentelno());
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

    public Sipariş siparişIdBul(Integer siparişId) {
        Sipariş sipariş = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from siparisid=" + siparişId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            sipariş = new Sipariş();
            sipariş.setSiparisid(rs.getInt("siparisid"));
            sipariş.setSiparisverenkisiad(rs.getString("siparisverenkisiad"));
            sipariş.setSiparisverenkisisoyad(rs.getString("siparisverenkisisoyad"));
            sipariş.setSiparisalınmatarihi(rs.getDate("siparisalınmatarihi"));
            sipariş.setSiparisverilmetarihi(rs.getDate("siparisverilmetarihi"));
            sipariş.setSiparisverentelno(rs.getInt("siparisverentelno"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sipariş;
    }
}
