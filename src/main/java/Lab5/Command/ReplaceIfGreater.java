package Lab5.Command;

import Lab5.InputData.Vehicle;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ReplaceIfGreater implements Command{
    @Override
    public void execute(String argument, Scanner scn) {
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(Map.Entry<Integer, Vehicle> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer vehiclePower = entry.getValue().getEnginePower();
            if(vehiclePower < Integer.parseInt(argument)){
                correctKeys.add(key);
            }
        }
        for(int key: correctKeys){
            hashMap.remove(key);
        }
    }
}
