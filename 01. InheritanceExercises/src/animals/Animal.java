package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        return output.append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append(String.format("%s %d %s", this.getName(), this.getAge(), this.getGender())).append(System.lineSeparator())
                .append(this.produceSound())
                .toString();
    }
}
