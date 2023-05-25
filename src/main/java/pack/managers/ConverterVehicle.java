package pack.managers;

import com.google.gson.*;
import org.jetbrains.annotations.NotNull;
import pack.InputData.Coordinates;
import pack.InputData.FuelType;
import pack.InputData.Vehicle;
import pack.InputData.VehicleType;

import java.lang.reflect.Type;
import java.time.LocalDate;
public class ConverterVehicle implements JsonSerializer<Vehicle>, JsonDeserializer<Vehicle> {

    @Override
    public Vehicle deserialize(@NotNull JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        int id = object.get("ID").getAsInt();
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