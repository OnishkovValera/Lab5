package Lab5.Command;

public class Insert implements Command {
    @Override
    public void execute(Integer number) {
        cmd.insert(number);
    }
}
