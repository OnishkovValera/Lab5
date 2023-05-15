package Lab5.Command;

import Lab5.managers.CollectionManager;

public class Show implements Command {
    @Override
    public void execute(Integer number) {
        cmd.show();
    }
}
