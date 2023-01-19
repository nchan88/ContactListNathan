public class Superhero extends Person {
    // TODO: Modify and complete this class
    private String power;

    public Superhero(String firstName, String lastName, String phoneNumber, String power)
    {
        super(firstName, lastName, phoneNumber);
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString() + "Power: " + power;
    }
}

