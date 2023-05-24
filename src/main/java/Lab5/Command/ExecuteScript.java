package Lab5.Command;

import Lab5.managers.MessageHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScript implements Command{
    @Override
    public void execute(String argument, Scanner scn){
        File file = new File(argument);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
        MessageHandler messageHandler = new MessageHandler(scanner);
        messageHandler.processMessage();
    }
}
