package pl.baadamczyk.designpatterns.structural.facade;

public class LegacyAPI {

    private static String key;
    private static String value;
    private static int interval;
    private static String owner;


    public static void setKey(String key) {
        LegacyAPI.key = key;
    }

    public static String getValue(String key) {
        return value;
    }

    public static void setValue(String value) {
        LegacyAPI.value = value;
    }

    public static int getInterval(String key) {
        return interval;
    }

    public static void setInterval(int interval) {
        LegacyAPI.interval = interval;
    }

    public static String getOwner(String key) {
        return owner;
    }

    public static void setOwner(String owner) {
        LegacyAPI.owner = owner;
    }
}
