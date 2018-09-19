package pl.baadamczyk.designpatterns.structural.decorator;

/*
    Thanks to overriden "getDataString" method we are NEVER returning actual input object.
    Instead, we are using its data, enriching them and returns in a new form.
*/

public class InputFormatter extends Augmentor {

    public InputFormatter(Augmentable component) {
        super(component);
    }

    @Override
    public String getDataString() {
        return format(componentInstance.getDataString());
    }

    private String format(String dataString) {
        return new StringBuilder(dataString)
                .insert(0, "**** ")
                .append(" ****")
                .toString();
    }
}
