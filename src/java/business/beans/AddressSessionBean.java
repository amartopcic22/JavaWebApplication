package business.beans;

import business.entity.Address;
import business.entity.Country;
import business.entity.Town;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AddressSessionBean implements AddressSessionBeanLocal {
    
    @PersistenceContext(unitName = "HotelWebApplicationPU")
    private EntityManager entityManager;

    @Override
    public boolean town(int countryId,String streetName,String streetNumber,String townName) {
         try {
                Country country = findCountryById(countryId);
                Town town = new Town();
                town.setName(townName);
                town.setIdCountry(country);
                Address newAddress = new Address();
                newAddress.setStreet(streetName);
                newAddress.setNumber(streetNumber);
                newAddress.setIdTown(town);
                entityManager.persist(newAddress);
                entityManager.persist(town);
                return true;
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Country> getAllCountry() {
        try {
            Query query = entityManager.createNamedQuery("Country.findAll");
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    
    public Country findCountryById(int id) {
        Query query = entityManager.createNamedQuery("Country.findById");
        query.setParameter("id", id);
        Country country = (Country) query.getSingleResult();
        return country;
    }
    
    public Town findTownById(int id) {
        Query query = entityManager.createNamedQuery("Town.findById");
        query.setParameter("id", id);
        Town town = (Town) query.getSingleResult();
        return town;
    }
    
}
