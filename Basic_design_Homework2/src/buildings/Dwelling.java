package buildings;

public class Dwelling implements Building, Cloneable {   //Класс жилого здания
    private Floor[] arrFloors;

    public Dwelling (int numberOfFloors, int[] numberOfFlats){    //Конструктор, принимающий количество этажей
        this.arrFloors = new DwellingFloor[numberOfFloors];    //и массив количества квартир
        for (int i = 0; i < arrFloors.length; i++) {
            arrFloors[i] = new DwellingFloor(numberOfFlats[i]);
        }
    }

    public Dwelling (Floor[] arrFloors1){    //Конструктор, принимающий массив этажей дома
        this.arrFloors = arrFloors1;
    }

    public int getCountFloors(){
        return arrFloors.length;
    }   //Количество этажей в доме

    public int getCountSpace(){     //Количество комнат в доме
        int count = 0;
        int a = arrFloors.length;
        for (int i = 0; i < a; i++) {
            count = count + arrFloors[i].countSpace();
        }
        return count;
    }

    public double getTotalArea(){     //Общая площадь квартир в доме
        double totalArea = 0;
        int a = arrFloors.length;
            for (int i = 0; i < a; i++) {
                totalArea = totalArea + arrFloors[i].totalAreaOfSpace();
            }
        return totalArea;

    }

    public int getCountRooms(){   //Общее количество комнат в доме
        int count = 0;
        int a = arrFloors.length;
        for (int i = 0; i < a; i++) {
            count = count + arrFloors[i].totalCountOfRooms();
        }
        return count;
    }

    public Floor[] getArrFloors() {
        return arrFloors;
    }   //Получение массива этажей

    public Floor getFloor(int number){
        return arrFloors[number];
    }    //Получение этажа по номеру в доме

    public void setFloor (int number, Floor a){  //Изменение этажа по номеру в доме
        try {
            if((number < 1)||(number >= arrFloors.length)){
                throw new FloorIndexOutOfBoundsException();
            }
            arrFloors[number] = a;
        }
        catch(FloorIndexOutOfBoundsException e){
            throw e;
        }
    }

    public Space getSpace(int number)//stop
    {

        try {
            if ((number < 1) || (number >= this.getCountSpace())) {
                throw new SpaceIndexOutOfBoundsException();
            }
            int numberFloor = 0;
            int numberFlat = -1;
            int num = -1;
            for (int i = 0; i < arrFloors.length; i++) {
                int length = arrFloors[i].getArrSpace().length;
                numberFloor = i;
                for (int j = 0; j < length; j++) {
                    numberFlat = j;
                    num++;
                    if (num == number) {
                        break;
                    }
                }
                if (num == number) {
                    break;
                }
            }
            return arrFloors[numberFloor].getSpace(numberFlat);
        }
            catch(SpaceIndexOutOfBoundsException e){
                throw e;
            }
    }

    public void setSpace(int number, Space a){

        try {
            if ((number < 1) || (number >= this.getCountSpace())) {
                throw new SpaceIndexOutOfBoundsException();
            }
            int numberFloor = 0;
            int numberFlat = -1;
            int num = -1;
            for (int i = 0; i < arrFloors.length; i++) {
                int length = arrFloors[i].getArrSpace().length;
                numberFloor = i;
                for (int j = 0; j < length; j++) {
                    numberFlat = j;
                    num++;
                    if (num == number) {
                        break;
                    }
                }
                if (num == number) {
                    break;
                }

            }
            arrFloors[numberFloor].setSpace(numberFlat, a);
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void addSpace(int number, Space a) {

        try{
        if ((number < 1) || (number >= this.getCountSpace())) {
            throw new SpaceIndexOutOfBoundsException();
        }
        int numberFloor = 0;
        int numberFlat = -1;
        int num = -1;
        for (int i = 0; i < arrFloors.length; i++) {
            int length = arrFloors[i].getArrSpace().length;
            numberFloor = i;
            for (int j = 0; j < length; j++) {
                numberFlat = j;
                num++;
                if (num == number) {
                    break;
                }
            }
            if (num == number) {
                break;
            }
        }
        arrFloors[numberFloor].addSpace(numberFlat, a);
    }
    catch(SpaceIndexOutOfBoundsException e){
        throw e;
    }

    }

    public  void deleteSpace(int number){

        try {
            if ((number < 1) || (number >= this.getCountSpace())) {
                throw new SpaceIndexOutOfBoundsException();
            }
            int numberFloor = 0;
            int numberFlat = -1;
            int num = -1;
            for (int i = 0; i < arrFloors.length; i++) {
                int length = arrFloors[i].getArrSpace().length;
                numberFloor = i;
                for (int j = 0; j < length; j++) {
                    numberFlat = j;
                    num++;
                    if (num == number) {
                        break;
                    }
                }
                if (num == number) {
                    break;
                }

            }
            arrFloors[numberFloor].deleteSpace(numberFlat);
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public Space getBestSpace(){
        Space flat1 = new Flat();
        double maxArea = 0;
        int numberFlat = 0;
        int numberFloor = 0;
        int a = arrFloors.length;
        for (int i = 0; i < a ; i++) {
            if (arrFloors[i].getBestSpace().getArea() > maxArea) {
                maxArea = arrFloors[i].getBestSpace().getArea();
                flat1 = arrFloors[i].getBestSpace();
            }
            else {}
        }
        return flat1;
    }

   public Space[] getArrSortSpace() {
        int countFlats = 0;
        for (int i = 0; i < arrFloors.length ; i++) {
             countFlats = countFlats + arrFloors[i].countSpace();
        }
        Space[] flats = new Space[countFlats];
       for (int i = 0; i < countFlats; i++) {
           flats[i] = new Flat();
       }
        int index = 0;
        for (int i = 0; i < arrFloors.length; i++) {
            for (int j = 0; j < arrFloors[i].countSpace(); j++) {
                flats[index] = arrFloors[i].getSpace(j);
                index++;
            }
        }
       for(int i = flats.length-1 ; i > 0 ; i--){
           for(int j = 0 ; j < i ; j++){
               if( flats[j].getArea() < flats[j+1].getArea() ){
                Space tmp = new Flat();
                   tmp = flats[j];
                flats[j] = flats[j+1];
                flats[j+1] = tmp;
            }
        }
    }
        return flats;
    }

    public String toString (){
        StringBuffer buf = new StringBuffer();
        buf.append("Dwelling (");
        buf.append(getCountFloors());
        for (int i = 0; i < getCountFloors(); i++) {
            buf.append(", ");
            buf.append(arrFloors[i].toString());
        }
        buf.append(")");
        return buf.toString();
    }

    public boolean equals(Object object) {
        boolean ans = false;
        if (object instanceof Dwelling) {
            if (((Dwelling) object).getCountFloors() == this.getCountFloors()) {
                for (int i = 0; i < ((Dwelling) object).getCountFloors(); i++) {
                    if (arrFloors[i].equals(this.arrFloors[i])) {
                        ans = true;
                    }
                }
            }
        }
        return ans;
    }

    public int hashCode() {
        long temp = Double.doubleToLongBits(getCountFloors());
        for (int i = 0; i < getCountFloors(); i++)
            temp = temp ^ Double.doubleToLongBits(getFloor(i).hashCode());
        return (int) temp;
    }

    public Object clone() {
        Object[] result = new Floor[getCountFloors()];
        for (int i = 0; i < getCountFloors(); i++) {
            result[i] = getFloor(i).clone();
        }
        return new Dwelling((Floor[]) result);
    }


}
