package Lab5.Command;

public class RemoveGreater implements Command{
    @Override
    public void execute(Integer number) {
        cmd.remove_greater(number);
    }
}
