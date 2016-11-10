package buildings;

public class DwellingFloor implements Floor{   //Класс этаж жилого здания
    private Space[] arrFlats;    //Массив квартир

    public DwellingFloor (int numbersOfFlats){     //Конструктор, принимающий количество квартир на этаже
            this.arrFlats = new Flat[numbersOfFlats];
            for (int i = 0; i < numbersOfFlats; i++) {
                this.arrFlats[i] = new Flat();
            }

    }

    public DwellingFloor (Flat[]arrFlats){      //Конструктор, принимающий массив квартир
        int lengthArrFlats = arrFlats.length;
        this.arrFlats = new Flat[lengthArrFlats];
        /*for (int i = 0; i < lengthArrFlats; i++) {
            this.arrFlats[i] = new Flat();
        }*/
        for (int i = 0; i < lengthArrFlats; i++){
            this.arrFlats[i] = arrFlats[i];
        }
    }

    public int countSpace(){   //Метод получения количества квартир на этаже
        return arrFlats.length;
    }   //Получение количества помещений на этаже

    public double totalAreaOfSpace(){         //Метод получения общей площади квартир этажа
        int lengthArrFlats = arrFlats.length;
        double totalArea = 0;
        for (int i = 0; i < lengthArrFlats; i++){
            totalArea += arrFlats[i].getArea();
        }
        return totalArea;
    }

    public int totalCountOfRooms(){   //Метод получения общего количества комнат этажа
        int lengthArrFlats = arrFlats.length;
        int totalNumberRooms = 0;
        for (int i = 0; i < lengthArrFlats; i++){
            totalNumberRooms += arrFlats[i].getCountRooms();
        }
        return totalNumberRooms;
    }

    public Space[] getArrSpace(){  //Метод получения массива квартир этажа
        /*int lengthArrFlats = arrFlats.length;
        Flat[] a = new Flat[lengthArrFlats];
        for (int i = 0; i < lengthArrFlats; i++){
            a[i] = arrFlats[i];
        }*/
        return arrFlats;
    }

    public Space getSpace(int number){   //Метод получения объекта квартиры по ее номеру на этаже
        return arrFlats[number];
    }

    public void setSpace(int number, Space a){
        try {
            if ((number < 0) || (number >= arrFlats.length)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            arrFlats[number] = a;
        }
        catch(SpaceIndexOutOfBoundsException e ){
            throw e;
        }
    }

    public void addSpace(int num, Space a) {
        try {
            if((num < 0)||(num >= arrFlats.length )){
                throw new SpaceIndexOutOfBoundsException();
            }
            int length = arrFlats.length;
            if (num == 0) {
                Space[] arrFlats1 = new Flat[arrFlats.length + 1];
                arrFlats1[0] = a;
                System.arraycopy(arrFlats, 0, arrFlats1, 1, arrFlats.length);
                arrFlats = arrFlats1;
            } else if (num == length) {
                Space[] arrFlats1 = new Flat[arrFlats.length + 1];
                for (int i = 0; i < length + 1; i++) {
                    arrFlats1[i] = new Flat();
                }
                System.arraycopy(arrFlats, 0, arrFlats1, 0, arrFlats.length);
                arrFlats1[num] = a;
                arrFlats = arrFlats1;
            } else if ((num > 0) && (num < length)) {
                Space[] arrFlats1 = new Flat[arrFlats.length + 1];
                for (int i = 0; i < length + 1; i++) {
                    arrFlats1[i] = new Flat();
                }
                System.arraycopy(arrFlats, 0, arrFlats1, 0, arrFlats.length);
                System.arraycopy(arrFlats, num, arrFlats1, num + 1, arrFlats.length - num);
                arrFlats1[num] = a;
                arrFlats = arrFlats1;
            } else {
                System.out.println("ERROR!!!");
            }
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void deleteSpace(int num){
        try {
            if((num < 0)||(num >= arrFlats.length )){
                throw new SpaceIndexOutOfBoundsException();
            }
            int length = arrFlats.length - 1;
            if (num == 0) {
                Flat[] arrFlats1 = new Flat[arrFlats.length - 1];
                System.arraycopy(arrFlats, 1, arrFlats1, 0, arrFlats.length - 1);
                arrFlats = arrFlats1;
            } else if (num == length) {
                Flat[] arrFlats1 = new Flat[arrFlats.length - 1];
                System.arraycopy(arrFlats, 0, arrFlats1, 0, arrFlats.length - 1);
                arrFlats = arrFlats1;
            } else if ((num > 0) && (num < length)) {
                Flat[] arrFlats1 = new Flat[arrFlats.length - 1];
                for (int i = 0; i < length; i++) {
                    arrFlats1[i] = new Flat();
                }
                System.arraycopy(arrFlats, 0, arrFlats1, 0, num);
                System.arraycopy(arrFlats, num + 1, arrFlats1, num, arrFlats.length - num - 1);
                arrFlats = arrFlats1;
            } else {
                System.out.println("ERROR!!!");

            }
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public Space getBestSpace (){
        double maxArea = 0;
        int numberOfFlat = 0;
        int a = arrFlats.length;
        for (int i = 0; i < a ; i++) {
            if (arrFlats[i].getArea() > maxArea) {
                maxArea = arrFlats[i].getArea();
                numberOfFlat = i;
            }
            else {}
        }
        return arrFlats[numberOfFlat];
    }

    public String toString (){
        StringBuffer buf = new StringBuffer();
        buf.append("DwellingFloor (");
        buf.append(countSpace());
        for (int i = 0; i < countSpace(); i++) {
            buf.append(", ");
            buf.append(arrFlats[i].toString());
        }
        buf.append(")");
        return buf.toString();
    }

}
