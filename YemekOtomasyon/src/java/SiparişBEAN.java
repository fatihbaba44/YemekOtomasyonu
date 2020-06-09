

import DAO.SiparişDAO;
import Entity.Sipariş;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class SiparişBEAN implements Serializable {

    private List<Sipariş> list;
    private SiparişDAO sipdao;
    private Sipariş sipariş;
    
    
    private int page=1;
    private int pageSize=10;
    private int pageCount;

    public void next(){
        if(this.page==this.getPageCount())
            this.page=1;
        else
        page++;
    }
    
    public void previous(){
        if(this.page==1)
            this.page=this.getPageCount();
        else
        page--;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=(int) Math.ceil(this.getSipdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<Sipariş> getList() {

        return this.getSipdao().getList(page,pageSize);
       
    }

    public void setList(List<Sipariş> list) {
        this.list = list;
    }

    public SiparişDAO getSipdao() {
        if (this.sipdao == null) {
            this.sipdao = new SiparişDAO();
        }
        return sipdao;
    }

    public void setSipdao(SiparişDAO sipdao) {
        this.sipdao = sipdao;
    }

    public Sipariş getSipariş() {
        if (this.sipariş == null) {
            this.sipariş = new Sipariş();
        }
        return sipariş;
    }

    public void setSipariş(Sipariş sipariş) {
        this.sipariş = sipariş;
    }

    public List<Sipariş> getRead() {
        return this.getSipdao().getList(page, pageSize);

    }

    public void updateForm(Sipariş sipariş) {
        this.sipariş = sipariş;

    }

    public void clearForm() {
        this.sipariş = new Sipariş();
     
    }

    public void deleteConfirm(Sipariş sipariş) {

        this.sipariş = sipariş;
       
    }

    public void delete(Sipariş sipariş) {
        this.getSipdao().delete(sipariş);
        this.sipariş = new Sipariş();

    }

    public void update(){
        this.getSipdao().update(sipariş);
        this.sipariş=new Sipariş();
    }

    public void create() {
        this.getSipdao().create(sipariş);
        
    }
}
