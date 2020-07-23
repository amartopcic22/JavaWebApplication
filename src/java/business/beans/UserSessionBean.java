package business.beans;

import business.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
    
    @PersistenceContext(unitName = "HotelWebApplicationPU")
    private EntityManager em;
   
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Query query = em.createNamedQuery("User.findByUsernameAndPassword");
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.getSingleResult();
        return user;
    }
}
