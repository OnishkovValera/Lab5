package Lab5.Command;

import Lab5.managers.CollectionManager;

public class Update implements Command{
    @Override
    public void execute(Integer number) {
        cmd.update(number);
    }
}
