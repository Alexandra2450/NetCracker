package buildings;

public class Flat implements Space {     //Класс квартира
    private double area;    //Площадь квартиры
    private int countRooms;    //Количество комнат
    static final double STANDART_AREA = 50;
    static final int STANDART_NUMBERS_OF_ROOMS = 2;

    public Flat() {       //Конструктор по умолчанию
        this.area = STANDART_AREA;     //Площадь = 50
        this.countRooms = STANDART_NUMBERS_OF_ROOMS;   //Количество комнат = 2
    }

    public Flat(double area){     //Конструктор, параметры: площадь
        try {
            if (area <= 0) {
                throw new IllegalArgumentException();
            }
            this.area = area;
            this.countRooms = STANDART_NUMBERS_OF_ROOMS;
        }//Количество комнат = 2
        catch(IllegalArgumentException e)
        {
            area = STANDART_AREA;
            throw e;
        }
    }

    public Flat(double area, int numbersOfRooms){//КОнструктор, параметры: площадь, количество комнат
        try {
            if(area <= 0) throw new InvalidSpaceAreaException();
            if(numbersOfRooms <= 0) throw new InvalidRoomsCountException();
            this.area = area;
            this.countRooms = numbersOfRooms;
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

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int numbersOfRooms) {
        try {
            if(numbersOfRooms <= 0){
                throw new InvalidRoomsCountException();
            }
            this.countRooms = numbersOfRooms;
        }
        catch(InvalidRoomsCountException e){
            this.countRooms = STANDART_NUMBERS_OF_ROOMS;
            throw e;
        }
    }

    public double getArea() {
        return area;
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

    public String toString (){
        StringBuffer buf = new StringBuffer();
        buf.append("Flat (");
        buf.append(getArea());
        buf.append(", ");
        buf.append(getCountRooms());
        buf.append(")");
        return buf.toString();
    }

    public boolean equals(Object object){
        boolean ans = false;
        if(object instanceof Flat){
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
