package Lab5;
import Lab5.managers.CollectionManager;
import Lab5.managers.CommandManager;
import Lab5.managers.MessageHandler;

import java.util.NoSuchElementException;
import java.util.Scanner;

//lab5file

public class Main {
    public static void main(String[] args) {

        try {
            CollectionManager collectionManager = new CollectionManager();
            CommandManager commandManager = new CommandManager();
            MessageHandler messageHandler = new MessageHandler(new Scanner(System.in));
            collectionManager.inicialize();
            commandManager.initializeBase();
            messageHandler.processMessage();

        } catch (NoSuchElementException exception){
            System.out.println("This is empty file");
            System.out.print("$");
        }
    }
}
