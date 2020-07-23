package business.beans;

import business.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RegisterSessionBean implements RegisterSessionBeanLocal {

    @PersistenceContext(unitName = "HotelWebApplicationPU")
    private EntityManager entityManager;

    @Override
    public boolean register(String username, String password, String name, String surname) {
        try {
            Query query = entityManager.createNamedQuery("User.findByUsername");
            query.setParameter("username", username);
            List<User> users = query.getResultList();
            if (users.isEmpty()) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setName(name);
                user.setSurname(surname);
                entityManager.persist(user);
                return true;
            } else {
                return false;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
