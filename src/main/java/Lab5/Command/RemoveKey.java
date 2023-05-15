package Lab5.Command;

public class RemoveKey implements Command{
    @Override
    public void execute(Integer number) {
        cmd.remove_key(number);
    }
}
