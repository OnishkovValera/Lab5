package pack.Command;

import pack.InputData.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveGreater implements Command{
    @Override
    public void execute(String argument, Scanner scn) {
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(Vehicle i: hashMap.values()){
            if(i.getId() > Integer.parseInt(argument)){
                correctKeys.add(i.getId());
            }
        }
        for(int key:correctKeys){
            hashMap.remove(key);
        }
    }
}
