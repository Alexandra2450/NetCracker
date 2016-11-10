package buildings;

import java.io.Serializable;

public interface Space extends Serializable {
    double getArea();
    int getCountRooms();
    void setCountRooms(int a);
    void setArea(double a);
}

