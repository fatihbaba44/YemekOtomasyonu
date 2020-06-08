

import DAO.MalzemeDAO;

import Entity.Malzeme;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "malzemeConverter")
public class MalzemeConverter implements Converter {

    private MalzemeDAO malzemeDAO;

    public void setMalzemeDAO(MalzemeDAO malzemeDAO) {
        this.malzemeDAO = malzemeDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMalzemeDAO().malzemeIdBul(Integer.valueOf(value));
    }

    public Integer getAsInteger(FacesContext context, UIComponent component, Object value) {
        Malzeme malzeme = (Malzeme) value;
        return malzeme.getMalzemeid();
    }

    public MalzemeDAO getMalzemeDAO() {
        if (this.malzemeDAO == null) {
            this.malzemeDAO = new MalzemeDAO();
        }
        return malzemeDAO;
    }

     @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Malzeme malzeme=(Malzeme)value;
       return String.valueOf(value);
    }

}