package Entity;



import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AnaYemek  implements Serializable {
 
    private int anayemekid;
    private String anayemekismi;
    private int anayemekkalori;
    private int anayemekfiyat;

    public AnaYemek(int anayemekid, String anayemekismi, int anayemekkalori, int anayemekfiyat) {
        this.anayemekid = anayemekid;
        this.anayemekismi = anayemekismi;
        this.anayemekkalori = anayemekkalori;
        this.anayemekfiyat = anayemekfiyat;
    }

    public AnaYemek() {
    }

    public int getAnayemekid() {
        
        return anayemekid;
    }

    public void setAnayemekid(int anayemekid) {
        this.anayemekid = anayemekid;
    }

    public String getAnayemekismi() {
        return anayemekismi;
    }

    public void setAnayemekismi(String anayemekismi) {
        this.anayemekismi = anayemekismi;
    }

    public int getAnayemekkalori() {
        return anayemekkalori;
    }

    public void setAnayemekkalori(int anayemekkalori) {
        this.anayemekkalori = anayemekkalori;
    }

    public int getAnayemekfiyat() {
        return anayemekfiyat;
    }

    public void setAnayemekfiyat(int anayemekfiyat) {
        this.anayemekfiyat = anayemekfiyat;
    }

    @Override
    public String toString() {
        return "AnaYemek{" + "anayemekid=" + anayemekid + ", anayemekismi=" + anayemekismi + ", anayemekkalori=" + anayemekkalori + ", anayemekfiyat=" + anayemekfiyat + '}';
    }
}
