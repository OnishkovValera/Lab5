package Lab5.Command;

import Lab5.InputData.Vehicle;
import Lab5.managers.CollectionManager;

import java.util.HashMap;

public class Info implements Command {

    @Override
    public void execute(Integer number) {
        cmd.info();
    }
}
