package Lab5.Command;
import Lab5.InputData.Vehicle;
import Lab5.managers.CollectionManager;

import java.io.IOException;
import java.util.HashMap;

public interface Command {
    CollectionManager cmd = new CollectionManager();

    void execute(Integer number);
}

