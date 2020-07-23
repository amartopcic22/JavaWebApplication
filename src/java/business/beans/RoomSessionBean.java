package business.beans;

import business.entity.Room;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RoomSessionBean implements RoomSessionBeanLocal {

    @PersistenceContext(unitName = "HotelWebApplicationPU")
    private EntityManager entityManager;

    @Override
    public boolean room(String code, int numberOfBeds, long price) {
        try {
            Query query = entityManager.createNamedQuery("Room.findByCode");
            query.setParameter("code", code);
            List<Room> rooms = query.getResultList();
            if (rooms.isEmpty()) {
                Room newRoom = new Room();
                newRoom.setCode(code);
                newRoom.setNumberOfBeds(numberOfBeds);
                newRoom.setPrice(price);
                entityManager.persist(newRoom);
                return true;
            } else {
                return false;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Room> getAllRoom() {
         try {
            Query query = entityManager.createNamedQuery("Room.findAll");
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }

}
