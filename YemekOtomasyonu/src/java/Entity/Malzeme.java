package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
  
public class Malzeme implements Serializable{

    private int malzemeid;
    private String malzemeismi;
    private int malzemekalori;
    private int malzemefiyat;

    public Malzeme() {
    }

    public Malzeme(int malzemeid, String malzemeismi, int malzemekalori, int malzemefiyat) {
        this.malzemeid = malzemeid;
        this.malzemeismi = malzemeismi;
        this.malzemekalori = malzemekalori;
        this.malzemefiyat = malzemefiyat;
    }

    public int getMalzemeid() {
        return malzemeid;
    }

    public void setMalzemeid(int malzemeid) {
        this.malzemeid = malzemeid;
    }

    public String getMalzemeismi() {
        return malzemeismi;
    }

    public void setMalzemeismi(String malzemeismi) {
        this.malzemeismi = malzemeismi;
    }

    public int getMalzemekalori() {
        return malzemekalori;
    }

    public void setMalzemekalori(int malzemekalori) {
        this.malzemekalori = malzemekalori;
    }

    public int getMalzemefiyat() {
        return malzemefiyat;
    }

    public void setMalzemefiyat(int malzemefiyat) {
        this.malzemefiyat = malzemefiyat;
    }

    @Override
    public String toString() {
        return "Malzeme{" + "malzemeid=" + malzemeid + ", malzemeismi=" + malzemeismi + ", malzemekalori=" + malzemekalori + ", malzemefiyat=" + malzemefiyat + '}';
    }
}
