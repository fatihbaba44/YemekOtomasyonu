

import DAO.AnaYemekDAO;
import Entity.AnaYemek;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class AnaYemekBEAN implements Serializable {

    private List<AnaYemek> list;
    private AnaYemekDAO anadao;
    private AnaYemek anayemek;
    
    
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
        this.pageCount=(int) Math.ceil(this.getAnadao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<AnaYemek> getList() {

        return this.getAnadao().getList(page,pageSize);
       
    }

    public void setList(List<AnaYemek> list) {
        this.list = list;
    }

    public AnaYemekDAO getAnadao() {
        if (this.anadao == null) {
            this.anadao = new AnaYemekDAO();
        }
        return anadao;
    }

    public void setAnadao(AnaYemekDAO anadao) {
        this.anadao = anadao;
    }

    public AnaYemek getAnayemek() {
        if (this.anayemek == null) {
            this.anayemek = new AnaYemek();
        }
        return anayemek;
    }

    public void setAnayemek(AnaYemek anayemek) {
        this.anayemek = anayemek;
    }

    public List<AnaYemek> getRead() {
        return this.getAnadao().getList(page, pageSize);

    }

    public void updateForm(AnaYemek anayemek) {
        this.anayemek = anayemek;

    }

    public void clearForm() {
        this.anayemek = new AnaYemek();
     
    }

    public void deleteConfirm(AnaYemek anayemek) {

        this.anayemek = anayemek;
       
    }

    public void delete(AnaYemek anayemek) {
        this.getAnadao().delete(anayemek);
        this.anayemek = new AnaYemek();

    }

    public void update(){
        this.getAnadao().update(anayemek);
        this.anayemek=new AnaYemek();
    }

    public void create() {
        this.getAnadao().create(anayemek);
        
    }
}
