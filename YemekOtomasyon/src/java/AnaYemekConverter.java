

import DAO.AnaYemekDAO;
import Entity.AnaYemek;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "anayemekConverter")
public class AnaYemekConverter implements Converter {

    private AnaYemekDAO anaYemekDAO;

    public void setAnaYemekDAO(AnaYemekDAO anaYemekDAO) {
        this.anaYemekDAO = anaYemekDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getAnaYemekDAO().anayemekIdBul(Integer.valueOf(value));
    }

    

    public AnaYemekDAO getAnaYemekDAO() {
        if (this.anaYemekDAO == null) {
            this.anaYemekDAO = new AnaYemekDAO();
        }
        return anaYemekDAO;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       AnaYemek anayemek =(AnaYemek)value;
       return String.valueOf(value);
    }
}