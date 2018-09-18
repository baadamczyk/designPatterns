package pl.baadamczyk.designpatterns.structural.adapter;

import com.google.gson.Gson;

public class LegacyServiceAdapter {

    // Adapter in this case allows new service to set properties
    private static Gson gson = new Gson();

    public static void setProperty(SystemProperty propertyWrapper) {
        String propertyJson = gson.toJson(propertyWrapper);
        LegacyService.setProperty(propertyJson);
    }
}
