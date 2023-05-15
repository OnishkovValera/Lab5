package Lab5.Command;

public class RemoveGreaterKey implements Command{
    @Override
    public void execute(Integer number) {
        cmd.remove_greater_key(number);
    }
}
