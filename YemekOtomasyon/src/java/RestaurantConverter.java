

import DAO.RestaurantDAO;

import Entity.Restaurant;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "restaurantConverter")
public class RestaurantConverter implements Converter {

    private RestaurantDAO restaurantDAO;

    public RestaurantDAO getRestaurantDAO() {
        if(this.restaurantDAO==null){
            restaurantDAO=new RestaurantDAO();
        }
        return restaurantDAO;
    }

    public void setRestaurantDAO(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

  
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getRestaurantDAO().restaurantIdBul(Integer.valueOf(value));
    }

    public Integer getAsInteger(FacesContext context, UIComponent component, Object value) {
       Restaurant restaurant = (Restaurant) value;
        return restaurant.getRestaurantid();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Restaurant restaurant =(Restaurant)value;
       return String.valueOf(value);
    }

    
    }

  