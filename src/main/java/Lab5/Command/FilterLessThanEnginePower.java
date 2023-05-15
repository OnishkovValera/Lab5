package Lab5.Command;

public class FilterLessThanEnginePower implements Command {
    @Override
    public void execute(Integer number) {
        cmd.filter_less_than_engine_power(number);
    }
}
