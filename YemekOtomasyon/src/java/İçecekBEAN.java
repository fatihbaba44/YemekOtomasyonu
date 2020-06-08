

import DAO.İçecekDAO;
import Entity.İçecek;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class İçecekBEAN implements Serializable {

    private List<İçecek> list;
    private İçecekDAO idao;
    private İçecek içecek;
    
    
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
        this.pageCount=(int) Math.ceil(this.getİdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<İçecek> getList() {

        return this.getİdao().getList(page,pageSize);
       
    }

    public void setList(List<İçecek> list) {
        this.list = list;
    }

    public İçecekDAO getİdao() {
        if (this.idao == null) {
            this.idao = new İçecekDAO();
        }
        return idao;
    }

    public void setİdao(İçecekDAO idao) {
        this.idao = idao;
    }

    public İçecek getIçecek() {
        if (this.içecek == null) {
            this.içecek = new İçecek();
        }
        return içecek;
    }

    public void setIçecek(İçecek içecek) {
        this.içecek = içecek;
    }

    public List<İçecek> getRead() {
        return this.getİdao().getList(page, pageSize);

    }

    public void updateForm(İçecek içecek) {
        this.içecek = içecek;

    }

    public void clearForm() {
        this.içecek = new İçecek();
     
    }

    public void deleteConfirm(İçecek içecek) {

        this.içecek = içecek;
       
    }

    public void delete(İçecek içecek) {
        this.getİdao().delete(içecek);
        this.içecek = new İçecek();

    }

    public void update(){
        this.getİdao().update(içecek);
        this.içecek=new İçecek();
    }

    public void create() {
        this.getİdao().create(içecek);
        
    }
}
