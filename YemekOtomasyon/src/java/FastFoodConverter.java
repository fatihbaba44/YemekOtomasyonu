

import DAO.FastFoodDAO;

import Entity.FastFood;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "fastfoodConverter")
public class FastFoodConverter implements Converter {

    private FastFoodDAO fastFoodDAO;

    public void setFastFoodDAO(FastFoodDAO fastFoodDAO) {
        this.fastFoodDAO = fastFoodDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getFastFoodDAO().fastfoodIdBul(Integer.valueOf(value));
    }

   

    public FastFoodDAO getFastFoodDAO() {
        if (this.fastFoodDAO == null) {
            this.fastFoodDAO = new FastFoodDAO();
        }
        return fastFoodDAO;
    }

     @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      FastFood fastfood =(FastFood)value;
       return String.valueOf(value);
    }

}