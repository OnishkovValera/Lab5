package pack.Command;

import pack.InputData.Coordinates;
import pack.InputData.FuelType;
import pack.InputData.Vehicle;
import pack.InputData.VehicleType;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Insert implements Command {
    @Override
    public void execute(String argument, Scanner scn) {
        String name;
        float coordinate_x;
        double coordinate_y;
        int engine_power;
        double capacity;
        int value = Integer.parseInt(argument);
        while(true){
            try{
                System.out.println("Enter name");
                System.out.print("$");
                name = scn.nextLine();
                break;
            }catch (InputMismatchException exception){
                System.out.println("Wrong enter");
                scn.nextLine();
            }
        }

        while(true){
            try{
                System.out.println("Enter coordinate x");
                System.out.print("$");
                coordinate_x = scn.nextFloat();
                break;
            }catch (InputMismatchException exception){
                System.out.println("Wrong enter");
                scn.nextLine();
            }
        }
        while(true){
            try{
                System.out.println("Enter coordinate y");
                System.out.print("$");
                coordinate_y = scn.nextDouble();
                break;

            }catch (InputMismatchException exception){
                System.out.println("Wrong enter");
                scn.nextLine();
            }
        }
        while(true){
            try{
                System.out.println("Enter engine power");
                System.out.print("$");
                engine_power = scn.nextInt();
                break;
            }catch (InputMismatchException exception){
                System.out.println("Wrong enter");
                scn.nextLine();
            }
        }
        while(true){
            try{
                System.out.println("Enter capacity");
                System.out.print("$");
                capacity = scn.nextDouble();
                break;
            }catch (InputMismatchException exception){
                System.out.println("Wrong enter");
                scn.nextLine();
            }
        }

        System.out.println("Enter type of vehicle: helicopter/submarine/chopper/spaceship");
        System.out.print("$");
        scn.nextLine();
        String vehicleType = scn.nextLine().toLowerCase();
        if(!(vehicleType.equals("helicopter") || vehicleType.equals("submarine") || vehicleType.equals("chopper") || vehicleType.equals("spaceship"))) {
            scn.nextLine();
            while (!(vehicleType.equals("helicopter") || vehicleType.equals("submarine") || vehicleType.equals("chopper") || vehicleType.equals("spaceship"))) {
                System.out.println("No such vehicle type, try another");
                System.out.print("$");
                vehicleType = scn.nextLine();
            }
        }
        System.out.println("Enter type of fuel: kerosene/alcohol/plasma");
        System.out.print("$");
        String fuelType = scn.nextLine().toLowerCase();
        if(!(fuelType.equals("kerosene") || fuelType.equals("alcohol") || fuelType.equals("plasma"))) {
            while (!(fuelType.equals("kerosene") || fuelType.equals("alcohol") || fuelType.equals("plasma"))) {
                System.out.println("No such vehicle type, try another");
                System.out.print("$");
                fuelType = scn.nextLine();
            }
        }
        cmd.getHashMap().put(value, new Vehicle(value, name, new Coordinates(coordinate_x, coordinate_y), LocalDate.now(), engine_power, capacity, VehicleType.valueOf(vehicleType.toUpperCase()), FuelType.valueOf(fuelType.toUpperCase())));
    }
}
