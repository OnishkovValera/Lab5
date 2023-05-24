package Lab5.Command;

import Lab5.InputData.Vehicle;

import java.util.Scanner;

public class Show implements Command {
    @Override
    public void execute(String argument, Scanner scn) {
        for (Vehicle vehicle : cmd.getHashMap().values()) {
            System.out.println(vehicle);
        }
    }
}
