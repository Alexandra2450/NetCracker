package buildings;


import java.io.Serializable;

public interface Building extends Serializable {

    int getCountFloors();
    int getCountSpace();
    double getTotalArea();
    int getCountRooms();
    Floor[] getArrFloors();
    Floor getFloor(int index);
    Space getSpace(int number);
    void setSpace(int number, Space a);
    void addSpace(int number, Space a);
    void deleteSpace(int number);
    Space getBestSpace();
    Space[] getArrSortSpace();
    void setFloor(int index, Floor a);


}
