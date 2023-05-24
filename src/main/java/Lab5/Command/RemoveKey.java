package Lab5.Command;

import java.util.Scanner;

public class RemoveKey implements Command{
    @Override
    public void execute(String argument, Scanner scn) {
        hashMap.remove(Integer.parseInt(argument));

    }
}
