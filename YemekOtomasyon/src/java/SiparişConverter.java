

import DAO.SiparişDAO;
import Entity.Sipariş;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "SiparişConverter")
public class SiparişConverter implements Converter {

    private SiparişDAO SiparisDAO;

    public void setSiparişDAO(SiparişDAO SiparisDAO) {
        this.SiparisDAO = SiparisDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSiparişDAO().siparişIdBul(Integer.valueOf(value));
    }

    

    public SiparişDAO getSiparişDAO() {
        if (this.SiparisDAO == null) {
            this.SiparisDAO = new SiparişDAO();
        }
        return SiparisDAO;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Sipariş sipariş =(Sipariş)value;
       return String.valueOf(value);
    }
}