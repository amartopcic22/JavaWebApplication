package business.beans;

import business.entity.Room;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface RoomSessionBeanLocal {
    public List<Room> getAllRoom();
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean room(String code, int numberOfBeds, long price);
}
