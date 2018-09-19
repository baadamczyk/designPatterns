package pl.baadamczyk.designpatterns.structural.decorator;

// Implements Augmentable so it can be easily passed through decorator's argument
public class DataWrapper implements Augmentable {

    private String dataString;

    public DataWrapper(String dataString) {
        this.dataString = dataString;
    }

    @Override
    public String getDataString() {
        return dataString;
    }
}
