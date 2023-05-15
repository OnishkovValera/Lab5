package Lab5.Command;

public class Clear implements Command {

    @Override
    public void execute(Integer number) {
        cmd.clear();
    }
}
