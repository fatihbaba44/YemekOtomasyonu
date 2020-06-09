

import DAO.TatlıDAO;
import Entity.Tatlı;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class TatlıBEAN implements Serializable {

    private List<Tatlı> list;
    private TatlıDAO tdao;
    private Tatlı tatlı;
    
    
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
        this.pageCount=(int) Math.ceil(this.getTdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<Tatlı> getList() {

        return this.getTdao().getList(page,pageSize);
       
    }

    public void setList(List<Tatlı> list) {
        this.list = list;
    }

    public TatlıDAO getTdao() {
        if (this.tdao == null) {
            this.tdao = new TatlıDAO();
        }
        return tdao;
    }

    public void setTdao(TatlıDAO tdao) {
        this.tdao = tdao;
    }

    public Tatlı getTatlı() {
        if (this.tatlı == null) {
            this.tatlı = new Tatlı();
        }
        return tatlı;
    }

    public void setTatlı(Tatlı tatlı) {
        this.tatlı = tatlı;
    }

    public List<Tatlı> getRead() {
        return this.getTdao().getList(page, pageSize);

    }

    public void updateForm(Tatlı tatlı) {
        this.tatlı = tatlı;

    }

    public void clearForm() {
        this.tatlı = new Tatlı();
     
    }

    public void deleteConfirm(Tatlı tatlı) {

        this.tatlı = tatlı;
       
    }

    public void delete(Tatlı tatlı) {
        this.getTdao().delete(tatlı);
        this.tatlı = new Tatlı();

    }

    public void update(){
        this.getTdao().update(tatlı);
        this.tatlı=new Tatlı();
    }

    public void create() {
        this.getTdao().create(tatlı);
        
    }
}
