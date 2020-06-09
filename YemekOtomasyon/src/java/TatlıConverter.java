

import DAO.TatlıDAO;
import Entity.Tatlı;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "TatlıConverter")
public class TatlıConverter implements Converter {

    private TatlıDAO TatlıDAO;

    public void setTatlıDAO(TatlıDAO TatlıDAO) {
        this.TatlıDAO = TatlıDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTatlıDAO().tatlıIdBul(Integer.valueOf(value));
    }

    

    public TatlıDAO getTatlıDAO() {
        if (this.TatlıDAO == null) {
            this.TatlıDAO = new TatlıDAO();
        }
        return TatlıDAO;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Tatlı Tatlı =(Tatlı)value;
       return String.valueOf(value);
    }
}