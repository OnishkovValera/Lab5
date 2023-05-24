package Lab5.Command;

import Lab5.InputData.Vehicle;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class RemoveAllByCapacity implements Command{
    @Override
    public void execute(String argument, Scanner scn) {
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(Map.Entry<Integer, Vehicle> entry : hashMap.entrySet()){
            Integer key = entry.getKey();
            double value = entry.getValue().getCapacity();
            if(value == Integer.parseInt(argument)){
                correctKeys.add(key);
            }
        }
        for(int key:correctKeys){
            hashMap.remove(key);
        }
    }
}
