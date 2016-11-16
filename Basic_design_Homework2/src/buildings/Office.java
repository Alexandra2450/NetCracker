package buildings;


public class Office implements Space {
    private double area;    //Площадь квартиры
    private int countRooms;    //Количество комнат
    static final double STANDART_AREA = 250;
    static final int STANDART_NUMBERS_OF_ROOMS = 1;

    public Office (){
        this.area = STANDART_AREA;
        this.countRooms = STANDART_NUMBERS_OF_ROOMS;
    }

    public Office (double area){
        try {
            if(area <= 0){
                throw new InvalidSpaceAreaException();
            }
            this.area = area;
            this.countRooms = STANDART_NUMBERS_OF_ROOMS;
        }
        catch(InvalidSpaceAreaException e){
            this.area = STANDART_AREA;
            throw e;
        }
    }

    public Office (double area, int count){
        try {
            if (area <= 0) throw new InvalidSpaceAreaException();
            if (count <= 0) throw new InvalidRoomsCountException();
            this.area = area;
            this.countRooms = count;
        }
        catch(InvalidSpaceAreaException e){
            this.area = STANDART_AREA;
            throw e;
        }
        catch(InvalidRoomsCountException e){
            this.countRooms = STANDART_NUMBERS_OF_ROOMS;
            throw e;
        }
    }

    public double getArea(){
        return this.area;
    }

    public int getCountRooms (){
        return this.countRooms;
    }

    public void setArea(double area) {
        try {
            if (area <= 0) {
                throw new InvalidSpaceAreaException();
            }
            this.area = area;
        }
        catch(InvalidSpaceAreaException e){
            this.area = STANDART_AREA;
            throw e;
        }
    }

    public void setCountRooms(int countRooms) {
        try {
            if (countRooms <= 0) {
                throw new InvalidRoomsCountException();
            }
            this.countRooms = countRooms;
        }
        catch(InvalidRoomsCountException e){
            this.countRooms = STANDART_NUMBERS_OF_ROOMS;
            throw e;
        }
    }

    public String toString (){
        StringBuffer buf = new StringBuffer();
        buf.append("Office (");
        buf.append(getArea());
        buf.append(", ");
        buf.append(getCountRooms());
        buf.append(")");
        return buf.toString();
    }

    public boolean equals(Object object){
        boolean ans = false;
        if(object instanceof Office){
            if((((Flat) object).getArea()==this.getArea())&&(((Flat) object).getCountRooms()==this.getCountRooms())){
                ans = true;
            }
        }return ans;
    }

    public int hashCode() {
        int result;
        long temp;
        long temp2;
        temp = Double.doubleToLongBits(countRooms);
        temp2 = Double.doubleToLongBits(getArea());
        result = (int) (temp ^ temp2);
        return result;
    }

    public Object clone(){
        try{
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
