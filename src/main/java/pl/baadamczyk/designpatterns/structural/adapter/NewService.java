package pl.baadamczyk.designpatterns.structural.adapter;

//This service version (new) uses more moder Oobject-Oriented parameter as input
public class NewService {

    public static void setProperty(SystemProperty propertyWrapper) {
        LegacyServiceAdapter.setProperty(propertyWrapper);
    }
}
