package buildings;

import java.io.Serializable;

public class OfficeBuilding implements Building {

    private class Node implements Serializable{
        Floor floor = null;
        Node next;
        Node prev;
    }

    private Node head = new Node();
    {
        head.next = head;
        head.prev = head;
    }

    private int size = 0;
    private Node current = head;

    private Node gotoNumber(int index){
        current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current;
    }

    private void addOfficePr(int index){
        Node newNode = new Node();
        newNode.floor = new OfficeFloor(4);    //!!!!!
        if(index == size){
            newNode.next = head;
            Node t1 = gotoNumber(index - 1);
            t1.next = newNode;
            newNode.prev = t1;
            head.prev = newNode;
        }
        else if(index == 0){
            Node t2 = gotoNumber(index);
            newNode.next = t2;
            head.next = newNode;
            newNode.prev = head;
            newNode.next.prev = newNode;
        }
        else {
            Node t2 = gotoNumber(index);
            newNode.next = t2;
            Node t1 = gotoNumber(index - 1);
            t1.next = newNode;
            newNode.prev = t1;
            newNode.next.prev = newNode;
        }
        size++;
    }

    private void deleteOfficePr(int index){
        Node t1 = gotoNumber(index - 1);
        Node t2 = gotoNumber(index + 1);
        t1.next = t2;
        t2.prev = t1;
        size--;
    }

    public OfficeBuilding (int count, int[] countOffice){//!АААА
            for (int i = 0; i < count; i++) {
                addOfficePr(i);
                gotoNumber(i).floor = new OfficeFloor(countOffice[i]);
            }

    }

    public OfficeBuilding (Floor[] a){
        int length = a.length;
        for (int i = 0; i < length; i++) {
            addOfficePr(i);
            gotoNumber(i).floor = a[i];
        }
    }

    public int getCountFloors(){
        return size;
    }

    public int getCountSpace(){
        int countOffice = 0;
        for (int i = 0; i < size; i++) {
            countOffice += gotoNumber(i).floor.countSpace();
        }
        return countOffice;
    }

    public double getTotalArea(){
        double totalArea = 0;
        for (int i = 0; i < size; i++) {
            totalArea += gotoNumber(i).floor.totalAreaOfSpace();
        }
        return totalArea;
    }

    public int getCountRooms(){
        int totalRooms = 0;
        for (int i = 0; i < size; i++) {
            totalRooms += gotoNumber(i).floor.totalCountOfRooms();
        }
        return totalRooms;
    }

    public Floor[] getArrFloors(){
        Floor[] a = new Floor[size];
        for (int i = 0; i < size; i++) {
            a[i] = gotoNumber(i).floor;
        }
        return a;
    }

    public Floor getFloor(int index){
        try {
            if((index >= size)||(index < 0)){throw new FloorIndexOutOfBoundsException();}
            Floor a = gotoNumber(index).floor;   //???
            return a;
        }
        catch(FloorIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void setFloor(int index, Floor a){
        try {
            if ((index >= size) || (index < 0)) {
                throw new FloorIndexOutOfBoundsException();
            }
            gotoNumber(index).floor = a;
        }
        catch(FloorIndexOutOfBoundsException e){
            throw e;
        }
    }

    public Space getSpace(int index){
        try {
            if ((index >= this.getCountSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            int numberOffice = 0;
            int numberFloor = -1;
            int num = -1;
            for (int i = 0; i < size; i++) {
                int length = gotoNumber(i).floor.countSpace();
                numberFloor = i;
                for (int j = 0; j < length; j++) {
                    numberOffice = j;
                    num++;
                    if (num == index) {
                        break;
                    }
                }
                if (num == index) {
                    break;
                }
            }
            return gotoNumber(numberFloor).floor.getSpace(numberOffice);
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void setSpace(int index, Space a){
        try {
            if ((index >= this.getCountSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            int numberOffice = 0;
            int numberFloor = -1;
            int num = -1;
            for (int i = 0; i < size; i++) {
                int length = gotoNumber(i).floor.countSpace();
                numberFloor = i;
                for (int j = 0; j < length; j++) {
                    numberOffice = j;
                    num++;
                    if (num == index) {
                        break;
                    }
                }
                if (num == index) {
                    break;
                }
            }
            gotoNumber(numberFloor).floor.setSpace(numberOffice, a);
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void addSpace(int index, Space a){
        try {
            if ((index >= this.getCountSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            int numberOffice = 0;
            int numberFloor = -1;
            int num = -1;
            for (int i = 0; i < size; i++) {
                int length = gotoNumber(i).floor.countSpace();
                numberFloor = i;
                for (int j = 0; j < length; j++) {
                    numberOffice = j;
                    num++;
                    if (num == index) {
                        break;
                    }
                }
                if (num == index) {
                    break;
                }
            }
            gotoNumber(numberFloor).floor.addSpace(numberOffice, a);
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }
    }

    public void deleteSpace(int index){
        try {
            if ((index >= this.getCountSpace()) || (index < 0)) {
                throw new SpaceIndexOutOfBoundsException();
            }
            int numberOffice = 0;
            int numberFloor = -1;
            int num = -1;
            for (int i = 0; i < size; i++) {
                int length = gotoNumber(i).floor.countSpace();
                numberFloor = i;
                for (int j = 0; j < length; j++) {
                    numberOffice = j;
                    num++;
                    if (num == index) {
                        break;
                    }
                }
                if (num == index) {
                    break;
                }
            }
            gotoNumber(numberFloor).floor.deleteSpace(numberOffice);
        }
        catch(SpaceIndexOutOfBoundsException e){
            throw e;
        }

    }

    public Space getBestSpace(){
        Space office = new Office();
        double maxArea = 0;
        int numberOffice = 0;
        int numberFloor = 0;
        for (int i = 0; i < size ; i++) {
            if (gotoNumber(i).floor.getBestSpace().getArea() > maxArea) {
                maxArea = gotoNumber(i).floor.getBestSpace().getArea();
                office = gotoNumber(i).floor.getBestSpace();
            }
            else {}
        }
        return office;
    }

    public Space[] getArrSortSpace() {
        int countOffice = 0;
        for (int i = 0; i < size; i++) {
            countOffice += gotoNumber(i).floor.countSpace();
        }
        Space[] office = new Space[countOffice];
        for (int i = 0; i < countOffice; i++) {
            office[i] = new Office();
        }
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < gotoNumber(i).floor.countSpace(); j++) {
                office[index] = gotoNumber(i).floor.getSpace(j);
                index++;
            }
        }
        for(int i = office.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( office[j].getArea() < office[j+1].getArea() ){
                    Space tmp = new Office();
                    tmp = office[j];
                    office[j] = office[j+1];
                    office[j+1] = tmp;
                }
            }
        }
        return office;
    }

    public String toString () {
        StringBuffer buf = new StringBuffer();
        buf.append("OfficeBuilding (");
        buf.append(getCountFloors());
        for (int i = 0; i < getCountFloors(); i++) {
            buf.append(", ");
            buf.append(gotoNumber(i).toString());
        }
        buf.append(")");
        return buf.toString();
    }





}
