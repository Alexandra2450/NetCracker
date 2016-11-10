import buildings.*;
import java.io.*;


public class Build {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        int[] arr = {2, 3, 1, 2};
        Building a = new OfficeBuilding(4, arr);
        /*FileOutputStream out = new FileOutputStream("C://Users//Alexandra//Desktop//dataOut.txt");
        Buildings.outputBuilding(a, out);
        out.close();

        FileInputStream in = new FileInputStream("C://Users//Alexandra//Desktop//dataOut.txt");
        Building bb = Buildings.inputBuilding(in);
        in.close();*/
        //FileWriter output = new FileWriter("C://Users//Alexandra//Desktop//dataOut.txt");
        //Buildings.writeBuilding(a, output);
        //output.close();
        //System.out.println(a.getFloor(0).countSpace());
        //FileReader v = new FileReader("C://Users//Alexandra//Desktop//dataOut.txt");
        //Building nn = Buildings.readBuilding(v);
        ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("C://Users//Alexandra//Desktop//dataOut.txt"));
        out3.writeObject(a);
        out3.close();
        ObjectInputStream inp3 = new ObjectInputStream(new FileInputStream("C://Users//Alexandra//Desktop//dataOut.txt"));
        Building b = (Building) inp3.readObject();
        inp3.close();
        Flat flat = new Flat();
        //System.out.print(flat.toString());
        OfficeFloor floor = new OfficeFloor(3);
        System.out.print(floor.toString());
    }
}
