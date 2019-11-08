package animals;

public class Cat extends Animal{
    private final static String SOUND = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    public static String getSOUND() {
        return SOUND;
    }

    @Override
    public String produceSound(){
        return getSOUND();
    }
}
