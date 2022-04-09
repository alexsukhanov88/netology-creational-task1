import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        if (age >= 0) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Неправильный возраст");
        }
    }

    public boolean hasAge() {
        return !age.isEmpty();
    }
    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
    public OptionalInt getAge() {
        return this.age;
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(getAge().getAsInt() + 1);
        } else {
            this.age = OptionalInt.of(0);
        }
    }

    @Override
    public String toString() {
        return getSurname() + " " + getName();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAge(0)
                .setSurname(this.getSurname())
                .setAddress(this.getAddress());
    }
}