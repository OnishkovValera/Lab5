package pack.Command;
import pack.InputData.Vehicle;
import pack.InputData.VehicleType;
import java.util.Map;
import java.util.Scanner;


public class Update implements Command{
    @Override
    public void execute(String argument, Scanner scn) {
        boolean argumentFound = false;
        for (Map.Entry<Integer, Vehicle> entry: hashMap.entrySet()){
            Integer key = entry.getKey();
            int value = entry.getValue().getId();
            if(value == Integer.parseInt(argument)){
                argumentFound = true;
                System.out.println("Enter what you want to update: name/coordinate/LocalDate/enginePower/capacity/vehicleType/fuelType");
                System.out.print("$");
                String answer;

                switch (scn.nextLine().trim()) {
                    case ("name") -> {
                        System.out.println("Enter name");
                        System.out.print("$");
                        hashMap.get(key).setName(scn.nextLine());
                    }
                    case ("coordinate") -> {
                        System.out.println("Enter x");
                        System.out.print("$");
                        hashMap.get(key).getCoordinates().setX( scn.nextFloat());
                        System.out.println("Enter y");
                        System.out.print("$");
                        hashMap.get(key).getCoordinates().setY(scn.nextDouble());
                    }
                    case ("LocalDate") -> {
                        System.out.println("Enter LocalDate");
                        System.out.print("$");
                        answer = scn.nextLine();
                        hashMap.get(key).setId(Integer.parseInt(answer));
                    }
                    case ("enginePower") -> {
                        System.out.println("Enter engine power");
                        System.out.print("$");
                        answer = scn.nextLine();
                        hashMap.get(key).setEnginePower(Integer.parseInt(answer));
                    }
                    case ("capacity") -> {
                        System.out.println("Enter capacity");
                        System.out.print("$");
                        answer = scn.nextLine();
                        hashMap.get(key).setCapacity(Integer.parseInt(answer));
                    }
                    case ("vehicleType") -> {
                        System.out.println("Enter type of vehicle: helicopter/submarine/chopper/spaceship");
                        System.out.print("$");
                        String new_type = scn.nextLine();
                        hashMap.get(key).setType(VehicleType.valueOf(new_type.toUpperCase()));
                    }
                    case ("fuelType") -> {
                        System.out.println("Enter type of fuel: kerosene/alcohol/plasma");
                        System.out.print("$");
                        String new_fuel_type = scn.nextLine();
                        hashMap.get(key).setType(VehicleType.valueOf(new_fuel_type.toUpperCase()));
                    }
                }
            }
        }
        if(!argumentFound) {
            System.out.println("No elements with such id");
            System.out.print("$");
        }

    }
}
