package Lab5.Command;

import java.util.Scanner;

public class Info implements Command {

    @Override
    public void execute(String argument, Scanner scn) {
        System.out.println("type: "+cmd.getHashMap().getClass());
        System.out.println("date: "+cmd.getDate());
        System.out.println("size: "+cmd.getHashMap().size());
        System.out.print("$");
    }
}
