package Lab5.managers;
import Lab5.Command.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class MessageHandler {
    Stack<Scanner> scanners = new Stack<>();
    CommandManager commandManager = new CommandManager();
    CollectionManager collectionManager = new CollectionManager();
    public void processMessage(){
        scanners.push(new Scanner(System.in));
        boolean readingFromFile = false;
        String filePath="";
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter command:");
        String message = scn.nextLine();
        while (!message.equals("exit")) {
            String[] com = message.toLowerCase().split(" ");
            if (com[0].equals("execute_script")) {
                File file;
                String fileName = com[1];
                if(!(readingFromFile & filePath.equals(fileName))) {
                    filePath = fileName;
                    try {
                        file = new File(fileName);
                        try {
                            scanners.push(scn);
                            scn = new Scanner(file);
                            collectionManager.setScanner(scn);
                            readingFromFile = true;
                        } catch (FileNotFoundException e) {
                            System.out.println("File isn't exist");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("File isn't exist");
                    }
                }else{
                    System.out.println("Such file is executing right now");
                }
            } else if (CommandManager.commands.containsKey(com[0])) {
                Command command = commandManager.getCommand(com[0]);
                if (commandManager.isArgumentExists(com[0])) {
                    try {
                        command.execute(Integer.parseInt(com[1].trim()));
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("You need to enter a index");
                    }
                } else {
                    command.execute(0);
                }

            } else {
                if (!com[0].equals("")) {
                    System.out.println("Entered wrong command, use \"help\"");
                }
            }
            System.out.print("Enter command:");
            try{
                message = scn.nextLine();
            }catch(NoSuchElementException exception){
                scn = scanners.pop();
                collectionManager.setScanner(scn);
                message = scn.nextLine();
            }
        }
    }
}
