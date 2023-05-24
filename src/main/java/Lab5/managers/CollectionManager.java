package Lab5.managers;
import Lab5.InputData.Vehicle;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CollectionManager  {
    static LocalDate localDate = LocalDate.now();
    public LocalDate getDate(){
        return localDate;
    }

    static String envpath;

    public String getEnvpath(){
        return envpath;
    }
    private static HashMap<Integer, Vehicle> hashMap;
    public HashMap<Integer, Vehicle> getHashMap(){
        return hashMap;
    }
    public void inicialize() throws NoSuchElementException, NullPointerException {
        Scanner scn = new Scanner(System.in);
        JsonHandler jsHand = new JsonHandler();
        System.out.println("Enter name of environment variable");
        System.out.print("$");
        envpath = System.getenv(scn.nextLine().trim());
        File file;
        Scanner sc;
        boolean fileFound = false;
        boolean envFound = false;
        while (!envFound & !fileFound) {
            try {
                file = new File(envpath);
                envFound = true;
                try {
                    sc = new Scanner(file);
                    fileFound = true;
                    while(sc.hasNext()) {
                        String next = sc.nextLine();
                        if(next.length()>1) {
                            hashMap = jsHand.toHashmap(next);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("No such file");
                    System.out.print("$");
                    envpath = System.getenv(scn.nextLine().trim());
                }
            } catch(NullPointerException e){
                System.out.println("No such system environment");
                System.out.println("Enter env");
                System.out.print("$");
                envpath = System.getenv(scn.nextLine().trim());
            }
        }
        if(hashMap == null){
            hashMap = new HashMap<Integer,Vehicle>();
        }
    }
}
