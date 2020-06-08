package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Sağlıklı  implements Serializable {

    private int saglikliid;
    private String saglikliismi;
    private int sagliklikalori;
    private int sagliklifiyat;

    public Sağlıklı() {
    }

    public Sağlıklı(int saglikliid, String saglikliismi, int sagliklikalori, int sagliklifiyat) {
        this.saglikliid = saglikliid;
        this.saglikliismi = saglikliismi;
        this.sagliklikalori = sagliklikalori;
        this.sagliklifiyat = sagliklifiyat;
    }

    public int getSaglikliid() {
        return saglikliid;
    }

    public void setSaglikliid(int saglikliid) {
        this.saglikliid = saglikliid;
    }

    public String getSaglikliismi() {
        return saglikliismi;
    }

    public void setSaglikliismi(String saglikliismi) {
        this.saglikliismi = saglikliismi;
    }

    public int getSagliklikalori() {
        return sagliklikalori;
    }

    public void setSagliklikalori(int sagliklikalori) {
        this.sagliklikalori = sagliklikalori;
    }

    

    public int getSagliklifiyat() {
        return sagliklifiyat;
    }

    public void setSagliklifiyat(int sagliklifiyat) {
        this.sagliklifiyat = sagliklifiyat;
    }

    @Override
    public String toString() {
        return "Sa\u011fl\u0131kl\u0131{" + "saglikliid=" + saglikliid + ", saglikliismi=" + saglikliismi + ", sagliklikalori=" + sagliklikalori + ", sagliklifiyat=" + sagliklifiyat + '}';
    }
}

    