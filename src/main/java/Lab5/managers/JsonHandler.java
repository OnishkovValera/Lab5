package Lab5.managers;
import java.util.HashMap;
import Lab5.InputData.Coordinates;
import Lab5.InputData.FuelType;
import Lab5.InputData.Vehicle;
import Lab5.InputData.VehicleType;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class JsonHandler {

    static public class ConverterVehicle implements JsonSerializer<Vehicle>, JsonDeserializer<Vehicle> {

        @Override
        public Vehicle deserialize(@NotNull JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject object = jsonElement.getAsJsonObject();

            Integer id = object.get("ID").getAsInt();
            String name = object.get("Name").getAsString();
            float coordinateX = object.get("Coordinate_x").getAsFloat();
            double coordinateY = object.get("Coordinate_x").getAsDouble();
            Integer EnginePower = object.get("EnginePower").getAsInt();
            LocalDate date = LocalDate.parse(object.get("CreationDate").getAsString());
            double capacity = object.get("Capacity").getAsDouble();
            String vehicleType = object.get("Type").getAsString();
            String fuelType = object.get("FuelType").getAsString();
            return new Vehicle(id, name, new Coordinates(coordinateX, coordinateY), date, EnginePower, capacity, VehicleType.valueOf(vehicleType.toUpperCase()), FuelType.valueOf(fuelType.toUpperCase()));
        }

        @Override
        public JsonElement serialize(Vehicle vehicle, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject object = new JsonObject();
            object.addProperty("ID", vehicle.getId());
            object.addProperty("Name", vehicle.getName());
            object.addProperty("Coordinate_x", vehicle.getCoordinates().getX());
            object.addProperty("Coordinate_y", vehicle.getCoordinates().getY());
            object.addProperty("CreationDate", vehicle.getCreationDate().toString());
            object.addProperty("EnginePower", vehicle.getEnginePower());
            object.addProperty("Capacity", vehicle.getCapacity());
            object.addProperty("Type", vehicle.getType().toString());
            object.addProperty("FuelType", vehicle.getFuelType().toString());

            return object;
        }
    }

    public String HashmapToJson(HashMap<Integer, Vehicle> hashMap){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Vehicle.class, new ConverterVehicle());
        Gson gson = builder.create();
        String hashson;
        hashson = gson.toJson(hashMap);
        return hashson;
    }
    public HashMap<Integer, Vehicle> toHashmap(String object){
        Type type = new TypeToken<HashMap<Integer, Vehicle>>(){}.getType();
        HashMap<Integer, Vehicle> hashMap;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Vehicle.class, new ConverterVehicle());
        Gson gson = builder.create();
        hashMap = gson.fromJson(object, type);
        return hashMap;
    }
}

