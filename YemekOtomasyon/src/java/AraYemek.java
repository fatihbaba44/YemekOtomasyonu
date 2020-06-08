

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
  
public class AraYemek implements Serializable{
    private int arayemekid;
    private String arayemekismi;
    private int arayemekkalori;
    private int arayemekfiyat;

    public AraYemek() {
    }

    public AraYemek(int arayemekid, String arayemekismi, int arayemekkalori, int arayemekfiyat) {
        this.arayemekid = arayemekid;
        this.arayemekismi = arayemekismi;
        this.arayemekkalori = arayemekkalori;
        this.arayemekfiyat=arayemekfiyat;
    }

    public int getArayemekid() {
        return arayemekid;
    }

    public void setArayemekid(int arayemekid) {
        this.arayemekid = arayemekid;
    }

    public String getArayemekismi() {
        return arayemekismi;
    }

    public void setArayemekismi(String arayemekismi) {
        this.arayemekismi = arayemekismi;
    }

    public int getArayemekkalori() {
        return arayemekkalori;
    }

    public void setArayemekkalori(int arayemekkalori) {
        this.arayemekkalori = arayemekkalori;
    }

    public int getArayemekfiyat() {
        return arayemekfiyat;
    }

    public void setArayemekfiyat(int arayemekfiyat) {
        this.arayemekfiyat = arayemekfiyat;
    }

    @Override
    public String toString() {
        return "AraYemek{" + "arayemekid=" + arayemekid + ", arayemekismi=" + arayemekismi + ", arayemekkalori=" + arayemekkalori + ", arayemekfiyat=" + arayemekfiyat + '}';
    }
}
