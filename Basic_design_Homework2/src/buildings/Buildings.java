package buildings;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class Buildings {

    public static void outputBuilding (Building building, OutputStream out) throws IOException {
        DataOutputStream outp = new DataOutputStream(out);
        int a = building.getCountFloors();
        outp.writeInt(a);
        for (int i = 0; i < a; i++) {
            int b = building.getFloor(i).countSpace();
            outp.writeInt(b);
            for (int j = 0; j < b; j++) {
                int c = building.getFloor(i).getSpace(j).getCountRooms();
                outp.writeInt(c);
                double d = building.getFloor(i).getSpace(j).getArea();
                outp.writeDouble(d);
            }
        }
        outp.flush();
    }

    public static Building inputBuilding (InputStream in) throws IOException {
        DataInputStream inp = new DataInputStream(in);
        int countfloors = inp.readInt();
        Floor[] fl = new Floor[countfloors];
        for (int i = 0; i < countfloors; i++) {
            int countspace = inp.readInt();
            fl[i] = new OfficeFloor(countspace);
            for (int j = 0; j < countspace; j++) {
                int countrooms = inp.readInt();
                double totalarea = inp.readDouble();
                Space office = new Office(totalarea, countrooms);
                fl[i].setSpace(j, office);
            }
        }
        Building build = new OfficeBuilding(fl);
        return build;
    }

    public static void writeBuilding (Building building, Writer out) throws IOException {
        PrintWriter outp = new PrintWriter(out);
        int a = building.getCountFloors();
        outp.print(a);
        for (int i = 0; i < a; i++) {
            int b = building.getFloor(i).countSpace();
            outp.print(" ");
            outp.print(b);
            for (int j = 0; j < b; j++) {
                int c = building.getFloor(i).getSpace(j).getCountRooms();
                outp.print(" ");
                outp.print(c);
                double d = building.getFloor(i).getSpace(j).getArea();
                outp.print(" ");
                outp.print(String.valueOf(d));
            }
        }
        out.flush();
    }

    public static Building readBuilding (Reader in) throws IOException {
        StreamTokenizer inp = new StreamTokenizer(in);
        inp.nextToken();
        int countfloors = (int) inp.nval;
        Floor[] fl = new Floor[countfloors];
        for (int i = 0; i < countfloors; i++) {
            int b = inp.nextToken();
            int countspace = (int) inp.nval;
            fl[i] = new OfficeFloor(countspace);
            for (int j = 0; j < countspace; j++) {
                int c = inp.nextToken();
                int countrooms = (int) inp.nval;
                double d = inp.nextToken();
                double totalarea = inp.nval;
                Space office = new Office(totalarea, countrooms);
                fl[i].setSpace(j, office);
            }
        }
        Building build = new OfficeBuilding(fl);
        return build;

    }

    public static void writeBuildingFormat(Building building, Writer out) throws IOException{
        PrintWriter stream = new PrintWriter(out);
        stream.printf("%d",building.getCountFloors());
        for(int i = 0; i< building.getCountFloors(); i++){
            stream.printf("%d",building.getFloor(i).countSpace());
            for(int j = 0; j<building.getFloor(i).countSpace(); j++){
                stream.printf("%f",building.getFloor(i).getSpace(j).getArea());
                stream.printf("%d",building.getFloor(i).getSpace(j).getCountRooms());
            }
        }
        out.flush();
    }



    public static Building readBuilding(Scanner in)throws IOException{
        Floor[] result = new Floor[in.nextInt()];
        for(Floor temp : result){
            int size = in.nextInt();
            for(int j =0; j<size; j++) {
                temp.addSpace(j,new Flat(in.nextDouble(), in.nextInt()));
            }
        }
        return new Dwelling(result);
    }


}
