package pack.Command;
import pack.InputData.Vehicle;
import pack.managers.CollectionManager;

import java.util.HashMap;
import java.util.Scanner;
public interface Command {

    CollectionManager cmd = new CollectionManager();

    String envpath = cmd.getEnvpath();

    HashMap<Integer, Vehicle> hashMap = cmd.getHashMap();

    void execute(String argument, Scanner scn);
}

