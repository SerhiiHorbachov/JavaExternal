package ua.externaljava.droid_wars.services;

import ua.externaljava.droid_wars.exceptions.AccessDatabaseException;
import ua.externaljava.droid_wars.exceptions.NoRecordException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DatabaseManipulator {

    private static final String FILE_PATH = "./src/main/resources/users.txt";
    private static final String DELIMITER = ",";
    private static final String ROLE_ADMIN = "admin";
    private static final String ROLE_USER = "user";

    public static void saveRecord(String name, String role, String email, String password) {

        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println(name + DELIMITER + role + DELIMITER + email + DELIMITER + password);
        pw.flush();
        pw.close();
    }

    public static boolean checkRecordByEmail(String email) {
        boolean isRegistered = false;
        List<String> lines = null;
        String [] data = null;
        File users = new File(FILE_PATH);

        if(users.length()<3){
            return isRegistered;
        }


        try {
            lines = Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            throw new AccessDatabaseException();
        }



        for(String line : lines) {

            data = line.split(DELIMITER);

                if(data[2].equals(email)){
                    isRegistered = true;
                }
            }

        return isRegistered;
    }

    public static String[] getAdminData(String email, String password) throws NoRecordException{
        List<String> lines = null;
        String [] adminData = null;
        boolean isFound = false;

        try {
            lines = Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            throw new AccessDatabaseException();
        }

        for(String line : lines){
            adminData = line.split(DELIMITER);

            if(adminData[1].equals(ROLE_ADMIN) && adminData[2].equals(email) && adminData[3].equals(password)){
                isFound = true;
                break;
            }
        }

        if(!isFound) {
            throw new NoRecordException();
        }
        return adminData;
    }

    public static String[] getUserData(String email, String password) throws NoRecordException{
        List<String> lines = null;
        String [] userData = null;
        boolean isFound = false;

        try {
            lines = Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            throw new AccessDatabaseException();
        }

        for(String line : lines){
            userData = line.split(DELIMITER);

            if(userData[1].equals(ROLE_USER) && userData[2].equals(email) && userData[3].equals(password)){
                isFound = true;
                break;
            }
        }

        if(!isFound) {
            throw new NoRecordException();
        }
        return userData;
    }
}
