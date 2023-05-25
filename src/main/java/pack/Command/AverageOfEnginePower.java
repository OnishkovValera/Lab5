package pack.Command;

import pack.InputData.Vehicle;

import java.util.Map;
import java.util.Scanner;

public class AverageOfEnginePower implements Command {

    @Override
    public void execute(String argument, Scanner scn) {
        int sum = 0;
        for(Map.Entry<Integer, Vehicle> entry: cmd.getHashMap().entrySet()){
            Integer power = entry.getValue().getEnginePower();
            sum+= power;
        }
        System.out.println(sum/ cmd.getHashMap().size());;
    }
}
