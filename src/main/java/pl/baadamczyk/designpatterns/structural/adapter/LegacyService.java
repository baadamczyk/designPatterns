package pl.baadamczyk.designpatterns.structural.adapter;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//This service version (legacy) uses obsolete String/Json parameter as input
public class LegacyService {

    private static Map<String, String> propertyMap = new ConcurrentHashMap<>();
    private static Gson gson = new Gson();

    public static void setProperty(String jsonString) {
        SystemProperty property = gson.fromJson(jsonString, SystemProperty.class);

        if(property != null) {
            propertyMap.put(property.name, property.value);
        } else {
            throw new JsonParseException("Property object has not been parsed properly");
        }
    }

    public static SystemProperty getProperty(String property) {
        return propertyMap.containsKey(property) ? SystemProperty.of(property, propertyMap.get(property)) : null;
    }
}
