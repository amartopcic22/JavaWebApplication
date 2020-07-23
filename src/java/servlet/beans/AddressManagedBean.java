package servlet.beans;

import business.beans.AddressSessionBeanLocal;
import business.entity.Country;
import business.entity.Town;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "addressManagedBean", eager = true)
@SessionScoped
public class AddressManagedBean implements Serializable {

    @EJB
    private AddressSessionBeanLocal addressSessionBeanLocal;

    private int countryId;
    private String streetName;
    private String streetNumber;
    private String townName;
    
    public AddressManagedBean() {
    }

    public String town() {

        boolean townCreated = addressSessionBeanLocal.town(countryId, streetName, streetNumber, townName);
        if (townCreated) {
            return "reservation";
        }
        return "reservation";
    }

    public int getIdCountry() {
        return countryId;
    }

    public void setIdCountry(int countryId) {
        this.countryId = countryId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    
    

    public List<Country> getAllCountry() {
        return addressSessionBeanLocal.getAllCountry();
    }

}
