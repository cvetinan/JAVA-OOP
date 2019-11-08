package animals;

public class Kitten extends Cat {
    private final static String GENDER = "Female";
    private final static String SOUND = "Meow";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    public static String getSOUND() {
        return SOUND;
    }

    @Override
    public String produceSound(){
        return getSOUND();
    }
}
