

import DAO.AraYemekDAO;
import Entity.AraYemek;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class AraYemekBEAN implements Serializable {

    private List<AraYemek> list;
    private AraYemekDAO aradao;
    private AraYemek arayemek;
    
    
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
        this.pageCount=(int) Math.ceil(this.getAradao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<AraYemek> getList() {

        return this.getAradao().getList(page,pageSize);
       
    }

    public void setList(List<AraYemek> list) {
        this.list = list;
    }

    public AraYemekDAO getAradao() {
        if (this.aradao == null) {
            this.aradao = new AraYemekDAO();
        }
        return aradao;
    }

    public void setAradao(AraYemekDAO aradao) {
        this.aradao = aradao;
    }

    public AraYemek getArayemek() {
        if (this.arayemek == null) {
            this.arayemek = new AraYemek();
        }
        return arayemek;
    }

    public void setArayemek(AraYemek arayemek) {
        this.arayemek = arayemek;
    }

    public List<AraYemek> getRead() {
        return this.getAradao().getList(page, pageSize);

    }

    public void updateForm(AraYemek arayemek) {
        this.arayemek = arayemek;

    }

    public void clearForm() {
        this.arayemek = new AraYemek();
     
    }

    public void deleteConfirm(AraYemek arayemek) {

        this.arayemek = arayemek;
       
    }

    public void delete(AraYemek arayemek) {
        this.getAradao().delete(arayemek);
        this.arayemek = new AraYemek();

    }

    public void update(){
        this.getAradao().update(arayemek);
        this.arayemek=new AraYemek();
    }

    public void create() {
        this.getAradao().create(arayemek);
        
    }
}
