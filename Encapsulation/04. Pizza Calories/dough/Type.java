package pizzacalories.dough;

public enum Type {
    WHITE,
    WHOLEGRAIN;

    static public boolean isMember(String name) {
        Type[] types = Type.values();
        for (Type type : types)
            if (type.name().equals(name.toUpperCase())) {
                return true;
            }
        return false;
    }
}
