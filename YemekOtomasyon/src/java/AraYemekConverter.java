


import DAO.AraYemekDAO;

import Entity.AraYemek;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "arayemekConverter")
public class AraYemekConverter implements Converter {

    private AraYemekDAO araYemekDAO;

    public void setAraYemekDAO(AraYemekDAO araYemekDAO) {
        this.araYemekDAO = araYemekDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getAnaYemekDAO().arayemekIdBul(Integer.valueOf(value));
    }
   
   
    public AraYemekDAO getAnaYemekDAO() {
        if (this.araYemekDAO == null) {
            this.araYemekDAO = new AraYemekDAO();
        }
        return araYemekDAO;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       AraYemek arayemek =(AraYemek)value;
       return String.valueOf(value);
    }
}
  
