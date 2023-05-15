package Lab5.Command;


import java.io.IOException;

public class Save implements Command{
    @Override
    public void execute(Integer number){
        try {
            cmd.save();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
