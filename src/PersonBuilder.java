import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Неправильный возраст");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Фамилия и имя обязательны");
        } else if (this.age.isEmpty()) {
            return new Person(this.name, this.surname);
        } else
        return new Person(this.name, this.surname, this.age.getAsInt());
    }
}