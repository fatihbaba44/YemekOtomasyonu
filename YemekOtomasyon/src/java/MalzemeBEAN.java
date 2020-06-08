

import DAO.MalzemeDAO;
import Entity.Malzeme;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class MalzemeBEAN implements Serializable {

    private List<Malzeme> list;
    private MalzemeDAO mdao;
    private Malzeme malzeme;
    
    
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
        this.pageCount=(int) Math.ceil(this.getMdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<Malzeme> getList() {

        return this.getMdao().getList(page,pageSize);
       
    }

    public void setList(List<Malzeme> list) {
        this.list = list;
    }

    public MalzemeDAO getMdao() {
        if (this.mdao == null) {
            this.mdao = new MalzemeDAO();
        }
        return mdao;
    }

    public void setMdao(MalzemeDAO mdao) {
        this.mdao = mdao;
    }

    public Malzeme getMalzeme() {
        if (this.malzeme == null) {
            this.malzeme = new Malzeme();
        }
        return malzeme;
    }

    public void setMalzeme(Malzeme malzeme) {
        this.malzeme = malzeme;
    }

    public List<Malzeme> getRead() {
        return this.getMdao().getList(page, pageSize);

    }

    public void updateForm(Malzeme malzeme) {
        this.malzeme = malzeme;

    }

    public void clearForm() {
        this.malzeme = new Malzeme();
     
    }

    public void deleteConfirm(Malzeme malzeme) {

        this.malzeme = malzeme;
       
    }

    public void delete(Malzeme malzeme) {
        this.getMdao().delete(malzeme);
        this.malzeme = new Malzeme();

    }

    public void update(){
        this.getMdao().update(malzeme);
        this.malzeme=new Malzeme();
    }

    public void create() {
        this.getMdao().create(malzeme);
        
    }
}
