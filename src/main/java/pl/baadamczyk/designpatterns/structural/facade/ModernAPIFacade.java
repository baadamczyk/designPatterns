package pl.baadamczyk.designpatterns.structural.facade;

public class ModernAPIFacade {
    public static void setProperties(PropertyWrapper inputWrapper) {
        LegacyAPI.setKey(inputWrapper.getKey());
        LegacyAPI.setValue(inputWrapper.getValue());
        LegacyAPI.setInterval(inputWrapper.getInterval());
        LegacyAPI.setOwner(inputWrapper.getOwner());
    }

    public static PropertyWrapper getProperties(String key) {
        return PropertyWrapper.of(
          key,
          LegacyAPI.getValue(key),
          LegacyAPI.getInterval(key),
          LegacyAPI.getOwner(key)
        );
    }
}
