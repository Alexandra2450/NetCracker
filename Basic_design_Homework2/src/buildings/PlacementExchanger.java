package buildings;


public class PlacementExchanger {

    static public boolean spacesCanExchanged(Space a, Space b) {
        if ((a.getCountRooms() == b.getCountRooms()) && (a.getArea() == b.getArea())) {
            return true;
        } else {
            return false;
        }
    }

    static public boolean floorsCanExchanged(Floor a, Floor b){
        if((a.countSpace() == b.countSpace())&&(a.totalAreaOfSpace() == b.totalAreaOfSpace())){
            return  true;
        }
        else{
            return false;
        }
    }

    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2)
            throws InexchangeableSpacesException {
        try {

            boolean ans = spacesCanExchanged(floor1.getSpace(index1), floor2.getSpace(index2));
            if (ans == false) {
                throw new InexchangeableSpacesException();
            }
            //Space space = new Office();
            Space space = floor1.getSpace(index1);     ///Спросить Спросить!!!!!
            floor1.setSpace(index1, floor2.getSpace(index2));
            floor2.setSpace(index2, space);
        }
        catch (InexchangeableSpacesException e){
            throw e;
        }
    }

    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2)
        throws InexchangeableFloorsException {
        try {
            boolean ans = floorsCanExchanged(building1.getFloor(index1), building2.getFloor(index2));
            if (ans == false) {
                throw new InexchangeableFloorsException();
            }
            //Space space = new Office();
            Floor floor = building1.getFloor(index1);
            building1.setFloor(index1, building2.getFloor(index2));
            building2.setFloor(index2, floor);
        }
        catch (InexchangeableFloorsException e){
            throw e;
        }
    }

    


}
