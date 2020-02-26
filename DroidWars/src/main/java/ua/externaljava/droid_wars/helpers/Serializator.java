package ua.externaljava.droid_wars.helpers;

import ua.externaljava.droid_wars.models.droids.BattleDroid;

import java.io.*;
import java.util.List;

public class Serializator {

    public static boolean serializationDroidList(List<BattleDroid> battleDroidList, String fileName){
        boolean flag = false;
        File fileToWriteTo = new File(fileName);
        ObjectOutputStream ostream = null;

        try {
            FileOutputStream fos = new FileOutputStream(fileToWriteTo);
            if(fos != null){
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(battleDroidList);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File cannot be read " + e);
        } catch (NotSerializableException e) {
            System.err.println("Class doesn't support serialization " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if(ostream != null){
                    ostream.close();
                }
            } catch (IOException e) {
                System.err.println("Stream closing error");
            }
        }

        return flag;
    }

    public static List<BattleDroid> deserialization(String fileName) throws InvalidObjectException {
        File fr = new File(fileName);
        FileInputStream fis = null;
        ObjectInputStream inputStream = null;

        try {
            fis = new FileInputStream(fr);
            inputStream = new ObjectInputStream(fis);
            List<BattleDroid> battleDroidList = (List<BattleDroid>) inputStream.readObject();
            return battleDroidList;

        } catch (ClassNotFoundException e) {
            System.err.println("Class doesn't exist: " + e);
        } catch (FileNotFoundException e) {
            System.err.println("File for serialization doesn't exist: " + e);
        } catch (IOException e) {
            System.err.println("General IO exception: " + e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new InvalidObjectException("Object hasn't been deserialized");
    }


}
