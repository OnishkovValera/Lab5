package pack;
import pack.managers.CollectionManager;
import pack.managers.CommandManager;
import pack.managers.MessageHandler;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
