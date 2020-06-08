package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
  
public class FastFood implements Serializable{

    private int fastfoodid;
    private String fastfoodismi;
    private int fastfoodkalori;
    private int fastfoodfiyat;

    public FastFood() {
    }

    public FastFood(int fastfoodid, String fastfoodismi, int fastfoodkalori, int fastfoodfiyat) {
        this.fastfoodid = fastfoodid;
        this.fastfoodismi = fastfoodismi;
        this.fastfoodkalori = fastfoodkalori;
        this.fastfoodfiyat = fastfoodfiyat;
    }

    public int getFastfoodid() {
        return fastfoodid;
    }

    public void setFastfoodid(int fastfoodid) {
        this.fastfoodid = fastfoodid;
    }

    public String getFastfoodismi() {
        return fastfoodismi;
    }

    public void setFastfoodismi(String fastfoodismi) {
        this.fastfoodismi = fastfoodismi;
    }

    public int getFastfoodkalori() {
        return fastfoodkalori;
    }

    public void setFastfoodkalori(int fastfoodkalori) {
        this.fastfoodkalori = fastfoodkalori;
    }

    public int getFastfoodfiyat() {
        return fastfoodfiyat;
    }

    public void setFastfoodfiyat(int fastfoodfiyat) {
        this.fastfoodfiyat = fastfoodfiyat;
    }

    @Override
    public String toString() {
        return "FastFood{" + "fastfoodid=" + fastfoodid + ", fastfoodismi=" + fastfoodismi + ", fastfoodkalori=" + fastfoodkalori + ", fastfoodfiyat=" + fastfoodfiyat + '}';
    }
    }
