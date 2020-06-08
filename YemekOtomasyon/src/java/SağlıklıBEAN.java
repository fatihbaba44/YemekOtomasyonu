

import DAO.SağlıklıDAO;
import Entity.Sağlıklı;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class SağlıklıBEAN implements Serializable {

    private List<Sağlıklı> list;
    private SağlıklıDAO sagdao;
    private Sağlıklı sağlıklı;
    
    
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
        this.pageCount=(int) Math.ceil(this.getSagdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<Sağlıklı> getList() {

        return this.getSagdao().getList(page,pageSize);
       
    }

    public void setList(List<Sağlıklı> list) {
        this.list = list;
    }

    public SağlıklıDAO getSagdao() {
        if (this.sagdao == null) {
            this.sagdao = new SağlıklıDAO();
        }
        return sagdao;
    }

    public void setSagdao(SağlıklıDAO sagdao) {
        this.sagdao = sagdao;
    }

    public Sağlıklı getSaglikli() {
        if (this.sağlıklı == null) {
            this.sağlıklı = new Sağlıklı();
        }
        return sağlıklı;
    }

    public void setSaglikli(Sağlıklı sağlıklı) {
        this.sağlıklı = sağlıklı;
    }

    public List<Sağlıklı> getRead() {
        return this.getSagdao().getList(page, pageSize);

    }

    public void updateForm(Sağlıklı sağlıklı) {
        this.sağlıklı = sağlıklı;

    }

    public void clearForm() {
        this.sağlıklı = new Sağlıklı();
     
    }

    public void deleteConfirm(Sağlıklı sağlıklı) {

        this.sağlıklı = sağlıklı;
       
    }

    public void delete(Sağlıklı sağlıklı) {
        this.getSagdao().delete(sağlıklı);
        this.sağlıklı = new Sağlıklı();

    }

    public void update(){
        this.getSagdao().update(sağlıklı);
        this.sağlıklı=new Sağlıklı();
    }

    public void create() {
        this.getSagdao().create(sağlıklı);
        
    }
}
