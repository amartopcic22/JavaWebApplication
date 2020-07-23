package servlet.beans;

import business.entity.Room;
import business.beans.RoomSessionBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "roomManagedBean", eager = true)
@SessionScoped
public class RoomManagedBean implements Serializable{
    
    @EJB
    private RoomSessionBeanLocal roomSessionBeanLocal;

    private String code;
    private int numberOfBeds;
    private long price;
    
    public RoomManagedBean() {
    }
    
     public String room(){
    
        boolean roomCreated = roomSessionBeanLocal.room(code, numberOfBeds, price);
        if(roomCreated){
            return "edit_room";
        }
        return "edit_room";
    }
     
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
      public List<Room> getAllRoom() {
        return roomSessionBeanLocal.getAllRoom();
    }
}
