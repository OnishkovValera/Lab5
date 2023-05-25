package pack.Command;


import pack.managers.JsonHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Save implements Command{
    @Override
    public void execute(String argument, Scanner scn){
        try {
            JsonHandler jsh = new JsonHandler();
            String object = jsh.HashmapToJson(hashMap);
            BufferedWriter bw = new BufferedWriter(new FileWriter(envpath));
            bw.write(object);
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
            System.out.print("$");
        }
    }
}
