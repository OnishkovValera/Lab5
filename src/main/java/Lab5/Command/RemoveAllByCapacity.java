package Lab5.Command;

public class RemoveAllByCapacity implements Command{
    @Override
    public void execute(Integer number) {
        cmd.remove_all_by_capacity(number);
    }
}
