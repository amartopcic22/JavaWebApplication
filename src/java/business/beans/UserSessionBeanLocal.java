package business.beans;

import business.entity.User;
import javax.ejb.Local;

@Local
public interface UserSessionBeanLocal {
public User findByUsernameAndPassword(String username, String password);
}
