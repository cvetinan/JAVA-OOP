package pizzacalories.toppings;

public enum  ToppingsModifiers {
    MEAT,
    VEGGIES,
    CHEESE,
    SAUCE;

    static public boolean isMember(String name) {
        ToppingsModifiers[] types = ToppingsModifiers.values();
        for (ToppingsModifiers type : types)
            if (type.name().equals(name.toUpperCase())) {
                return true;
            }
        return false;
    }

}
