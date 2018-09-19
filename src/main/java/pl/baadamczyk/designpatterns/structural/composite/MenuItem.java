package pl.baadamczyk.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuItem {

    protected String label;
    protected String url;
    protected List<MenuItem> menuComponents = new ArrayList<>();

    public MenuItem(String label, String url) {
        this.label = label;
        this.url = url;
    }

    public String getLabel() {
        return this.label;
    }

    public String getUrl() {
        return this.url;
    }
}
