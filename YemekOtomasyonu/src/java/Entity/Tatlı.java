package Entity;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Tatlı  implements Serializable  {
    private int tatlıid;
    private String tatlıismi;
    private int tatlıkalori;
    private int tatlıfiyat;

    public Tatlı() {
    }

    public Tatlı(int tatlıid, String tatlıismi, int tatlıkalori, int tatlıfiyat) {
        this.tatlıid = tatlıid;
        this.tatlıismi = tatlıismi;
        this.tatlıkalori = tatlıkalori;
        this.tatlıfiyat = tatlıfiyat;
    }

    public int getTatlıid() {
        return tatlıid;
    }

    public void setTatlıid(int tatlıid) {
        this.tatlıid = tatlıid;
    }

    public String getTatlıismi() {
        return tatlıismi;
    }

    public void setTatlıismi(String tatlıismi) {
        this.tatlıismi = tatlıismi;
    }

    public int getTatlıkalori() {
        return tatlıkalori;
    }

    public void setTatlıkalori(int tatlıkalori) {
        this.tatlıkalori = tatlıkalori;
    }

    public int getTatlıfiyat() {
        return tatlıfiyat;
    }

    public void setTatlıfiyat(int tatlıfiyat) {
        this.tatlıfiyat = tatlıfiyat;
    }

    @Override
    public String toString() {
        return "Tatl\u0131{" + "tatl\u0131id=" + tatlıid + ", tatl\u0131ismi=" + tatlıismi + ", tatl\u0131kalori=" + tatlıkalori + ", tatl\u0131fiyat=" + tatlıfiyat + '}';
    }
}
