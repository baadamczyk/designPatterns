package pl.baadamczyk.designpatterns.creational.builder;

import lombok.Value;

@Value
public class CarConfiguration {

    private final String color;
    private final String fuelType;
    private final String tyreType;

    private CarConfiguration(Builder builder) {
        this.color = builder.color;
        this.fuelType = builder.fuelType;
        this.tyreType = builder.tyreType;
    }

    // Builder implementes in simmilar fashion as in Lombok
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String color;
        private String fuelType;
        private String tyreType;

        private Builder() {
            //Default values
            this.color = "White";
            this.fuelType = "Gasoline";
            this.tyreType = "AllWeather";
        }

        // Builder segments are returning the builder itself as long as we want to actually retreive the object
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder fuelType(String type) {
            this.fuelType = type;
            return this;
        }

        public Builder tyreType(String type) {
            this.tyreType = type;
            return this;
        }

        public CarConfiguration build() {
            return new CarConfiguration(this);
        }
    }
}
