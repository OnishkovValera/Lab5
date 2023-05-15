package Lab5.managers;

import Lab5.Command.*;

import java.util.HashMap;


public class CommandManager {
    public static HashMap<String, Command> commands = new HashMap<String, Command>();
    public void initialize(){
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("average_of_engine_power", new AverageOfEnginePower());
        commands.put("insert", new Insert());
        commands.put("update", new Update());
        commands.put("remove_key", new RemoveKey());
        commands.put("remove_greater", new RemoveGreater());
        commands.put("replase_if_greater", new ReplaceIfGreater());
        commands.put("remove_greater_key", new RemoveGreaterKey());
        commands.put("remove_all_by_capacity", new RemoveAllByCapacity());
        commands.put("filter_less_than_engine_power", new FilterLessThanEnginePower());
    }
    public Command getCommand(String name){
        return commands.get(name);
    }
    public boolean isCommandExists(String name){
        return commands.containsKey(name);
    }

    public boolean isArgumentExists(String name){
        return switch (name) {
            case "help", "info", "show", "clear", "save", "exit", "average_of_engine_power" -> false;
            case "insert", "update", "remove_key", "execute_script", "remove_greater", "replase_if_greater", "remove_greater_key", "remove_all_by_capacity", "filter_less_than_engine_power" ->
                    true;
            default -> throw new IllegalArgumentException("Wrong command");
        };
    }

}
