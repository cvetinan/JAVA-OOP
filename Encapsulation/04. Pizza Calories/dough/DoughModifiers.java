package pizzacalories.dough;

public enum DoughModifiers {
    CRISPY,
    CHEWY,
    HOMEMADE;

    static public boolean isMember(String name) {
        DoughModifiers[] doughModifiers = DoughModifiers.values();
        for (DoughModifiers modifiers : doughModifiers)
            if (modifiers.name().equals(name.toUpperCase())) {
                return true;
            }
        return false;
    }
}
