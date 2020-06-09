

import DAO.RestaurantDAO;
import Entity.Restaurant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class RestaurantBEAN implements Serializable {

    private List<Restaurant> list;
    private RestaurantDAO rdao;
    private Restaurant restaurant;
    
    
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
        this.pageCount=(int) Math.ceil(this.getRdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    public List<Restaurant> getList() {

        return this.getRdao().getList(page,pageSize);
       
    }

    public void setList(List<Restaurant> list) {
        this.list = list;
    }

    public RestaurantDAO getRdao() {
        if (this.rdao == null) {
            this.rdao = new RestaurantDAO();
        }
        return rdao;
    }

    public void setRdao(RestaurantDAO rdao) {
        this.rdao = rdao;
    }

    public Restaurant getRestaurant() {
        if (this.restaurant == null) {
            this.restaurant = new Restaurant();
        }
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Restaurant> getRead() {
        return this.getRdao().getList(page, pageSize);

    }

    public void updateForm(Restaurant restaurant) {
        this.restaurant = restaurant;

    }

    public void clearForm() {
        this.restaurant = new Restaurant();
     
    }

    public void deleteConfirm(Restaurant restaurant) {

        this.restaurant = restaurant;
       
    }

    public void delete(Restaurant restaurant) {
        this.getRdao().delete(restaurant);
        this.restaurant = new Restaurant();

    }

    public void update(){
        this.getRdao().update(restaurant);
        this.restaurant=new Restaurant();
    }

    public void create() {
        this.getRdao().create(restaurant);
        
    }
}
