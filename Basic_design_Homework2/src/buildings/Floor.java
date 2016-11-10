package buildings;


import java.io.Serializable;

public interface Floor extends Serializable {

    int countSpace();
    double totalAreaOfSpace();
    int totalCountOfRooms();
    Space[] getArrSpace();
    Space getSpace(int index);
    void setSpace(int index, Space a);
    void addSpace(int index, Space a);
    void deleteSpace(int index);
    Space getBestSpace();

}
