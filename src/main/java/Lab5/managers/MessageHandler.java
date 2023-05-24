package Lab5.managers;
import Lab5.Command.Command;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MessageHandler {
    public MessageHandler(Scanner scn) {
        this.scn = scn;
    }

    private final Scanner scn;
    public Scanner getScanner(){
        return this.scn;
    }
    CommandManager commandManager = new CommandManager();

    public void processMessage(){
        String message;
        while (true) {
            System.out.println("Enter command ");
            System.out.print("$");
            try{
                message = scn.nextLine();
            }catch(NoSuchElementException exception){
                System.out.println("End of file");
                break;
            }
            String[] com = message.toLowerCase().split(" ");
            if (CommandManager.commands.containsKey(com[0])) {
                Command command = commandManager.getCommand(com[0]);
                if (commandManager.isArgumentExists(com[0])) {
                    try {
                        command.execute(com[1].trim(),scn);
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("You need to enter a index");
                    }
                } else {
                    try {
                        command.execute("", scn);
                    }catch (NullPointerException exception){
                        System.out.println("hashmap is null");
                    }
                }

            } else {
                if (!com[0].equals("")) {
                    System.out.println("Entered wrong command, use \"help\"");
                }
            }
        }
    }
}
