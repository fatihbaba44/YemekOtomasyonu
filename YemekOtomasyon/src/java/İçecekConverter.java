

import DAO.İçecekDAO;
import Entity.İçecek;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "içecekConverter")
public class İçecekConverter implements Converter {

    private İçecekDAO içecekDAO;

    public void setİçecekDAO(İçecekDAO içecekDAO) {
        this.içecekDAO = içecekDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getIçecekDAO().içecekIdBul(Integer.valueOf(value));
    }

    

    public İçecekDAO getIçecekDAO() {
        if (this.içecekDAO == null) {
            this.içecekDAO = new İçecekDAO();
        }
        return içecekDAO;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       İçecek içecek =(İçecek)value;
       return String.valueOf(value);
    }
}