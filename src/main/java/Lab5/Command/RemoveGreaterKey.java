package Lab5.Command;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveGreaterKey implements Command{
    @Override
    public void execute(String argument, Scanner scn) {
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(int i: hashMap.keySet()){
            if (i > Integer.parseInt(argument)){
                correctKeys.add(i);
            }
        }
        for(int key:correctKeys){
            hashMap.remove(key);
        }
    }
}