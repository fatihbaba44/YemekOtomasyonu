package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class İçecek   implements Serializable {

    private int içecekid;
    private String içecekismi;
    private int içecekkalori;
    private String içecekboyut;
    private int içecekfiyat;

    public int getIçecekfiyat() {
        return içecekfiyat;
    }

    public void setIçecekfiyat(int içecekfiyat) {
        this.içecekfiyat = içecekfiyat;
    }

    public İçecek(int içecekid, String içecekismi, int içecekkalori, String içecekboyut,int içecekfiyat) {
        this.içecekid = içecekid;
        this.içecekismi = içecekismi;
        this.içecekkalori = içecekkalori;
        this.içecekboyut = içecekboyut;
        this.içecekfiyat=içecekfiyat;
    }

    public İçecek() {
    }

    public int getIçecekid() {
        return içecekid;
    }

    public void setIçecekid(int içecekid) {
        this.içecekid = içecekid;
    }

    public String getIçecekismi() {
        return içecekismi;
    }

    public void setIçecekismi(String içecekismi) {
        this.içecekismi = içecekismi;
    }

    public int getIçecekkalori() {
        return içecekkalori;
    }

    public void setIçecekkalori(int içecekkalori) {
        this.içecekkalori = içecekkalori;
    }

    public String getIçecekboyut() {
        return içecekboyut;
    }

    public void setIçecekboyut(String içecekboyut) {
        this.içecekboyut = içecekboyut;
    }

    @Override
    public String toString() {
        return "\u0130\u00e7ecek{" + "i\u00e7ecekid=" + içecekid + ", i\u00e7ecekismi=" + içecekismi + ", i\u00e7ecekkalori=" + içecekkalori + ", i\u00e7ecekboyut=" + içecekboyut + '}';
    }
}
