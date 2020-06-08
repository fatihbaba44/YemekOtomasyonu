

import DAO.FastFoodDAO;
import Entity.FastFood;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class FastFoodBEAN implements Serializable {

    private List<FastFood> list;
    private FastFoodDAO fdao;
    private FastFood fastfood;
    
    
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
        this.pageCount=(int) Math.ceil(this.getFdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<FastFood> getList() {

        return this.getFdao().getList(page,pageSize);
       
    }

    public void setList(List<FastFood> list) {
        this.list = list;
    }

    public FastFoodDAO getFdao() {
        if (this.fdao == null) {
            this.fdao = new FastFoodDAO();
        }
        return fdao;
    }

    public void setFdao(FastFoodDAO fdao) {
        this.fdao = fdao;
    }

    public FastFood getFastfood() {
        if (this.fastfood == null) {
            this.fastfood = new FastFood();
        }
        return fastfood;
    }

    public void setFastfood(FastFood fastfood) {
        this.fastfood = fastfood;
    }

    public List<FastFood> getRead() {
        return this.getFdao().getList(page, pageSize);

    }

    public void updateForm(FastFood fastfood) {
        this.fastfood = fastfood;

    }

    public void clearForm() {
        this.fastfood = new FastFood();
     
    }

    public void deleteConfirm(FastFood fastfood) {

        this.fastfood = fastfood;
       
    }

    public void delete(FastFood fastfood) {
        this.getFdao().delete(fastfood);
        this.fastfood = new FastFood();

    }

    public void update(){
        this.getFdao().update(fastfood);
        this.fastfood=new FastFood();
    }

    public void create() {
        this.getFdao().create(fastfood);
        
    }
}
