package pack.managers;
import java.util.HashMap;
import pack.InputData.Vehicle;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class JsonHandler {



    public String HashmapToJson(HashMap<Integer, Vehicle> hashMap){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Vehicle.class, new ConverterVehicle());
        Gson gson = builder.create();
        String hashson;
        hashson = gson.toJson(hashMap);
        return hashson;
    }
    public HashMap<Integer, Vehicle> toHashmap(String path){
        Type type = new TypeToken<HashMap<Integer, Vehicle>>(){}.getType();
        HashMap<Integer, Vehicle> hashMap;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Vehicle.class, new ConverterVehicle());
        Gson gson = builder.create();
        try {
            hashMap = gson.fromJson(path, type);
        }catch(JsonSyntaxException exception){
            System.out.println("File is incorrect");
            hashMap = new HashMap<Integer, Vehicle>();
        }
        return hashMap;
    }
}

