package pl.baadamczyk.designpatterns.structural.decorator;

/*
    Thanks to overriden "getDataString" method we are NEVER returning actual input object.
    Instead, we are using its data, enriching them and returns in a new form.
*/

public class InputDelimiter extends Augmentor {


    public InputDelimiter(Augmentable component) {
        super(component);
    }

    @Override
    public String getDataString() {
        return delimit(componentInstance.getDataString());
    }

    private String delimit(String dataString) {
        return dataString.replace(":", " - ").replace("|", " | ");
    }
}
