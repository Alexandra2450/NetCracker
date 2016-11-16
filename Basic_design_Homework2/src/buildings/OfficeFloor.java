package buildings;


import java.io.Serializable;

public class OfficeFloor implements Floor, java.io.Serializable {
    private class Node implements Serializable{
        Space office = null;
        Node next;
    }

    private  Node head = new Node();
    {
        head.next = head;
    }
    private int size = 0;
    private Node current = head;

    private  Node gotoNumber(int index){   //Метод получения узла по его номеру
        current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current;
    }

    private void addOfficePr(int index){
        Node newNode = new Node();
        newNode.office = new Office();
        if(index == size){
            newNode.next = head;
            Node t1 = gotoNumber(index - 1);
            t1.next = newNode;
        }
        else if(index == 0){
            Node t2 = gotoNumber(index);
            newNode.next = t2;
            head.next = newNode;
        }
        else {
            Node t2 = gotoNumber(index);
            newNode.next = t2;
            Node t1 = gotoNumber(index - 1);
            t1.next = newNode;
        }
        size++;
    }

    private void deleteOfficePr(int index){
        Node t1 = gotoNumber(index - 1);
        Node t2 = gotoNumber(index + 1);
        t1.next = t2;
        size--;
    }

    public OfficeFloor(int countOffice){
        for (int i = 0; i < countOffice; i++) {
            addOfficePr(i);
        }
    }

    public OfficeFloor(Space[] office){
        int length = office.length;
        for (int i = 0; i < length; i++) {
            addOfficePr(i);
        }
        current = head.next;
        for (int i = 0; i < length; i++) {
            current.office = office[i];
            current = current.next;
        }
    }

    public int countSpace(){
        return size;
    }   //Вычисление количества помещений на этаже

    public double totalAreaOfSpace(){
        double totalArea = 0;
        for (int i = 0; i < size; i++) {
            totalArea += gotoNumber(i).office.getArea();
        }
        return totalArea;
    }

    public int totalCountOfRooms(){
        int totalCountRooms = 0;
        for (int i = 0; i < size; i++) {
            totalCountRooms += gotoNumber(i).office.getCountRooms();
        }
        return totalCountRooms;
    }

    public Space[] getArrSpace(){
        Space[] arrOffice = new Space[size];   //ПРоверь!!!
        for (int i = 0; i < size; i++) {
            arrOffice[i] = gotoNumber(i).office;
        }
        return arrOffice;
    }

    public Space getSpace(int index){
        try {
            if ((index >= this.countSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            Space a = new Office();
            a = gotoNumber(index).office;
            return a;
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }

    }

    public void setSpace(int index, Space a){
        try {
            if ((index >= this.countSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            gotoNumber(index).office = a;
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void addSpace(int index, Space a){
        try {
            if ((index >= this.countSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            addOfficePr(index);
            gotoNumber(index).office = a;

        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void deleteSpace(int index){
        try {
            if ((index >= this.countSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            deleteOfficePr(index);
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public Space getBestSpace(){
        int index = 0;
        double maxArea = 0;
        for (int i = 0; i < size; i++) {
            if(gotoNumber(i).office.getArea()>maxArea){
                maxArea = gotoNumber(i).office.getArea();
                index = i;
            }
        }
        return gotoNumber(index).office;
    }

    public String toString (){
        StringBuffer buf = new StringBuffer();
        buf.append("OfficeFloor (");
        buf.append(countSpace());
        for (int i = 0; i < countSpace(); i++) {
            buf.append(", ");
            buf.append(gotoNumber(i).office.toString());
        }
        buf.append(")");
        return buf.toString();
    }

    public boolean equals(Object object) {
        boolean ans = false;
        if (object instanceof OfficeFloor) {
            if (((OfficeFloor) object).countSpace() == this.countSpace()) {
                for (int i = 0; i < ((OfficeFloor) object).countSpace(); i++) {
                    if (gotoNumber(i).equals(this.gotoNumber(i))) {
                        ans = true;
                    }
                }
            }
        }
        return ans;
    }

    public int hashCode() {
        long temp = Double.doubleToLongBits(countSpace());
        for (int i = 0; i < countSpace(); i++)
            temp = temp ^ Double.doubleToLongBits(getSpace(i).hashCode());
        return (int) temp;
    }

    public Object clone() {
        Object[] result = new Space[countSpace()];
        for (int i = 0; i < countSpace(); i++) {
            result[i] = getSpace(i).clone();
        }
        return new OfficeFloor((Space[]) result);
    }

}
