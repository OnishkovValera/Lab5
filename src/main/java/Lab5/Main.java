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
            collectionManager.inicialize();
            CommandManager commandManager = new CommandManager();
            commandManager.initialize();
            MessageHandler messageHandler = new MessageHandler();
            messageHandler.processMessage();
        } catch (NoSuchElementException exception) {
            System.out.println("Stream is closed, interrupting application");
        } catch (NullPointerException exception){
            System.out.println("This is empty file");
        }
    }
}
