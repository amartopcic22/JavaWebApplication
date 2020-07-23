package business.beans;

import business.entity.Country;
import business.entity.Town;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface AddressSessionBeanLocal {
    public List<Country> getAllCountry();
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean town(int countryId,String streetName,String streetNumber, String townName);
}
