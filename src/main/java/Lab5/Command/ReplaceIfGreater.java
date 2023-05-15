package Lab5.Command;

public class ReplaceIfGreater implements Command{

    @Override
    public void execute(Integer number) {
        cmd.replace_if_greater(number);
    }
}
