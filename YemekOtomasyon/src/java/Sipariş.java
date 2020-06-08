

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Sipariş  implements Serializable {

    private int siparisid;
    private String siparisverenkisiad;
    private String siparisverenkisisoyad;
    private Date siparisalınmatarihi;
    private Date siparisverilmetarihi;
    private int siparisverentelno;

    public Sipariş() {
    }

    public Sipariş(int siparisid, String siparisverenkisiad, String siparisverenkisisoyad, Date siparisalınmatarihi, Date siparisverilmetarihi, int siparisverentelno) {
        this.siparisid = siparisid;
        this.siparisverenkisiad = siparisverenkisiad;
        this.siparisverenkisisoyad = siparisverenkisisoyad;
        this.siparisalınmatarihi = siparisalınmatarihi;
        this.siparisverilmetarihi = siparisverilmetarihi;
        this.siparisverentelno = siparisverentelno;
    }

    public int getSiparisid() {
        return siparisid;
    }

    public void setSiparisid(int siparisid) {
        this.siparisid = siparisid;
    }

    public String getSiparisverenkisiad() {
        return siparisverenkisiad;
    }

    public void setSiparisverenkisiad(String siparisverenkisiad) {
        this.siparisverenkisiad = siparisverenkisiad;
    }

    public String getSiparisverenkisisoyad() {
        return siparisverenkisisoyad;
    }

    public void setSiparisverenkisisoyad(String siparisverenkisisoyad) {
        this.siparisverenkisisoyad = siparisverenkisisoyad;
    }

    public Date getSiparisalınmatarihi() {
        return siparisalınmatarihi;
    }

    public void setSiparisalınmatarihi(Date siparisalınmatarihi) {
        this.siparisalınmatarihi = siparisalınmatarihi;
    }

    public Date getSiparisverilmetarihi() {
        return siparisverilmetarihi;
    }

    public void setSiparisverilmetarihi(Date siparisverilmetarihi) {
        this.siparisverilmetarihi = siparisverilmetarihi;
    }

    public int getSiparisverentelno() {
        return siparisverentelno;
    }

    public void setSiparisverentelno(int siparisverentelno) {
        this.siparisverentelno = siparisverentelno;
    }

    @Override
    public String toString() {
        return "Sipari\u015f{" + "siparisid=" + siparisid + ", siparisverenkisiad=" + siparisverenkisiad + ", siparisverenkisisoyad=" + siparisverenkisisoyad + ", siparisal\u0131nmatarihi=" + siparisalınmatarihi + ", siparisverilmetarihi=" + siparisverilmetarihi + ", siparisverentelno=" + siparisverentelno + '}';
    }
}
