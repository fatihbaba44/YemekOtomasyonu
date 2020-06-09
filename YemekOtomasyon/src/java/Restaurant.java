

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
  
public class Restaurant implements Serializable{

    private int restaurantid;
    private String restaurantismi;
    private String restaurantadres;

    public Restaurant() {
    }

    public Restaurant(int restaurantid, String restaurantismi, String restaurantadres) {
        this.restaurantid = restaurantid;
        this.restaurantismi = restaurantismi;
        this.restaurantadres = restaurantadres;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    public String getRestaurantismi() {
        return restaurantismi;
    }

    public void setRestaurantismi(String restaurantismi) {
        this.restaurantismi = restaurantismi;
    }

    public String getRestaurantadres() {
        return restaurantadres;
    }

    public void setRestaurantadres(String restaurantadres) {
        this.restaurantadres = restaurantadres;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "restaurantid=" + restaurantid + ", restaurantismi=" + restaurantismi + ", restaurantadres=" + restaurantadres + '}';
    }
}
