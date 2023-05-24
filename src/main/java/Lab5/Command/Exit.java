package Lab5.Command;

import java.util.Scanner;

public class Exit implements Command{
    @Override
    public void execute(String argument, Scanner scn) {
        System.exit(1);
    }
}
