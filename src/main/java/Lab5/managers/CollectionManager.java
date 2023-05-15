package Lab5.managers;
import Lab5.InputData.Coordinates;
import Lab5.InputData.FuelType;
import Lab5.InputData.Vehicle;
import Lab5.InputData.VehicleType;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CollectionManager  {
    boolean filescript = true;
    public void setScanner(Scanner scn){
        this.scn = scn;
    }
    static Scanner scn = new Scanner(System.in);
    static String envpath;
    static HashMap<Integer, Vehicle> hashMap;
    public void inicialize() throws NoSuchElementException, NullPointerException {
        JsonHandler jsHand = new JsonHandler();
        System.out.println("Enter name of environment variable");
        envpath = System.getenv(scn.nextLine().trim());
        File file;
        Scanner sc;
        boolean fileFound = false;
        boolean envFound = false;
        while (!envFound & !fileFound) {
            try {
                file = new File(envpath);
                envFound = true;
                    try {
                        sc = new Scanner(file);
                        fileFound = true;
                        hashMap = jsHand.toHashmap(sc.nextLine());
                    } catch (FileNotFoundException e) {
                        System.out.println("No such file");
                        envpath = System.getenv(scn.nextLine().trim());
                    }
                } catch(NullPointerException e){
                    System.out.println("No such system environment");
                    System.out.println("Enter env");
                    envpath = System.getenv(scn.nextLine().trim());
                }
        }
    }
    LocalDate localDate = LocalDate.now();
    public void help(){
        System.out.println("""
                help : вывести справку по доступным командам\s
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                insert null {element} : добавить новый элемент с заданным ключом
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_key null : удалить элемент из коллекции по его ключу
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
                replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого
                remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный
                remove_all_by_capacity capacity : удалить из коллекции все элементы, значение поля capacity которого эквивалентно заданному
                average_of_engine_power : вывести среднее значение поля enginePower для всех элементов коллекции
                filter_less_than_engine_power enginePower : вывести элементы, значение поля enginePower которых меньше заданного
                """

        );
    }

    public void insert(Integer argument){
        int id = argument;
        System.out.println("Enter name");
        String name = scn.nextLine();
        System.out.println("Enter coordinate x");
        float coordinate_x = scn.nextFloat();
        System.out.println("Enter coordinate y");
        double coordinate_y = scn.nextDouble();
        System.out.println("Enter engine power");
        Integer engine_power = scn.nextInt();
        System.out.println("Enter capacity");
        double capacity = scn.nextDouble();
        System.out.println("Enter type of vehicle: helicopter/submarine/chopper/spaceship");
        String vehicleType = scn.nextLine().toLowerCase();
        while (!(vehicleType.equals("helicopter") || vehicleType.equals("submarine") || vehicleType.equals("chopper") || vehicleType.equals("spaceship"))){
            System.out.println("No such vehicle type, try another");
            vehicleType = scn.nextLine();
        }

        System.out.println("Enter type of fuel: kerosene/alcohol/plasma");
        String fuelType = scn.nextLine();
        hashMap.put(id , new Vehicle(id, name, new Coordinates(coordinate_x, coordinate_y), LocalDate.now(), engine_power, capacity, VehicleType.valueOf(vehicleType.toUpperCase()), FuelType.valueOf(fuelType.toUpperCase())));
    }
    public void info(){
        System.out.println("type: "+hashMap.getClass());
        System.out.println("date: "+localDate);
        System.out.println("size: "+hashMap.size());
    }

    public void show (){
        for (Vehicle vehicle : hashMap.values()) {
            System.out.println(vehicle);
        }
    }
    public void update(Integer argument){
        boolean argumentFound = false;
        for (Map.Entry<Integer, Vehicle> entry: hashMap.entrySet()){
            Integer key = entry.getKey();
            int value = entry.getValue().getId();
            if(value == argument){
                argumentFound = true;
                System.out.println("Enter what you want to update: name/coordinate/LocalDate/enginePower/capacity/vehicleType/fuelType");
                String answer;

                switch (scn.nextLine().trim()) {
                    case ("name") -> {
                        System.out.println("Enter name");
                        hashMap.get(key).setName(scn.nextLine());
                    }
                    case ("coordinate") -> {
                        System.out.println("Enter x");
                        hashMap.get(key).getCoordinates().setX( scn.nextFloat());
                        System.out.println("Enter y");
                        hashMap.get(key).getCoordinates().setY(scn.nextDouble());
                    }
                    case ("LocalDate") -> {
                        System.out.println("Enter LocalDate");
                        answer = scn.nextLine();
                        hashMap.get(key).setId(Integer.parseInt(answer));
                    }
                    case ("enginePower") -> {
                        System.out.println("Enter engine power");
                        answer = scn.nextLine();
                        hashMap.get(key).setEnginePower(Integer.parseInt(answer));
                    }
                    case ("capacity") -> {
                        System.out.println("Enter capacity");
                        answer = scn.nextLine();
                        hashMap.get(key).setCapacity(Integer.parseInt(answer));
                    }
                    case ("vehicleType") -> {
                        System.out.println("Enter type of vehicle: helicopter/submarine/chopper/spaceship");
                        String new_type = scn.nextLine();
                        hashMap.get(key).setType(VehicleType.valueOf(new_type.toUpperCase()));
                    }
                    case ("fuelType") -> {
                        System.out.println("Enter type of fuel: kerosene/alcohol/plasma");
                        String new_fuel_type = scn.nextLine();
                        hashMap.get(key).setType(VehicleType.valueOf(new_fuel_type.toUpperCase()));
                    }
                }

            }
        }
        if(!argumentFound) {
            System.out.println("No elements with such id");
        }

    }
    public void remove_key(Integer argument){
        hashMap.remove(argument);
    }

    public void clear(){
        hashMap.clear();
    }
    public void save() throws IOException {
        JsonHandler jsh = new JsonHandler();
        String object = jsh.HashmapToJson(hashMap);
        BufferedWriter bw = new BufferedWriter(new FileWriter(envpath));
        bw.write(object);
        bw.close();
    }
    public void remove_greater(Integer argument){
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(Vehicle i: hashMap.values()){
            if(i.getId() > argument){
                correctKeys.add(i.getId());
            }
        }
        for(int key:correctKeys){
            hashMap.remove(key);
        }
    }
    public void replace_if_greater(Integer argument){
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(Map.Entry<Integer, Vehicle> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer vehiclePower = entry.getValue().getEnginePower();
            if(vehiclePower < argument){
                correctKeys.add(key);
            }
        }
        for(int key: correctKeys){
            hashMap.remove(key);
        }
    }
    public void remove_greater_key(Integer argument){
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(int i: hashMap.keySet()){
            if (i > argument){
                correctKeys.add(i);
            }
        }
        for(int key:correctKeys){
            hashMap.remove(key);
        }
    }

    public void remove_all_by_capacity(double argument){
        ArrayList<Integer> correctKeys = new ArrayList<>();
        for(Map.Entry<Integer, Vehicle> entry : hashMap.entrySet()){
            Integer key = entry.getKey();
            double value = entry.getValue().getCapacity();
            if(value == argument){
                correctKeys.add(key);
            }
        }
        for(int key:correctKeys){
            hashMap.remove(key);
        }
    }

    public void average_of_engine_power(){
        int sum = 0;
        for(Map.Entry<Integer, Vehicle> entry: hashMap.entrySet()){
            Integer power = entry.getValue().getEnginePower();
            sum+= power;
        }
        System.out.println(sum/ hashMap.size());
    }
    public void filter_less_than_engine_power(Integer argument){
        for(Map.Entry<Integer, Vehicle> entry: hashMap.entrySet()){
            Integer key = entry.getKey();
            Integer engine_power = entry.getValue().getEnginePower();
            if (engine_power < argument){
                System.out.println(hashMap.get(key));
            }
        }
    }



}
