package buildings;


public class InvalidRoomsCountException extends IllegalArgumentException {
    public InvalidRoomsCountException(){}
    public InvalidRoomsCountException(String msg){
        super(msg);
    }

}
