

import DAO.SağlıklıDAO;

import Entity.Sağlıklı;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "anaYemekConverter")
public class SağlıklıConverter implements Converter {

    private SağlıklıDAO sağlıklıDAO;

    public SağlıklıDAO getSağlıklıDAO() {
        if(this.sağlıklıDAO==null){
            sağlıklıDAO=new SağlıklıDAO();
        }
        return sağlıklıDAO;
    }

    public void setSağlıklıDAO(SağlıklıDAO sağlıklıDAO) {
        this.sağlıklıDAO = sağlıklıDAO;
    }

    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSağlıklıDAO().sağlıklıIdBul(Integer.valueOf(value));
    }

    public Integer getAsInteger(FacesContext context, UIComponent component, Object value) {
        Sağlıklı sağlıklı = (Sağlıklı) value;
        return sağlıklı.getSaglikliid();
    }

    
    

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Sağlıklı sağlıklı =(Sağlıklı)value;
       return String.valueOf(value);
    }

}