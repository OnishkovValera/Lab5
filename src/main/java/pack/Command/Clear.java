package pack.Command;

import java.util.Scanner;

public class Clear implements Command {

    @Override
    public void execute(String argument, Scanner scn) {
        hashMap.clear();
    }
}
