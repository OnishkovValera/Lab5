package pack.Command;

import pack.InputData.Vehicle;

import java.util.Map;
import java.util.Scanner;

public class FilterLessThanEnginePower implements Command {
    @Override
    public void execute(String argument, Scanner scn) {
        for(Map.Entry<Integer, Vehicle> entry: hashMap.entrySet()){
            Integer key = entry.getKey();
            Integer engine_power = entry.getValue().getEnginePower();
            if (engine_power < Integer.parseInt(argument)){
                System.out.println(hashMap.get(key));
                System.out.print("$");
            }
        }
    }
}
