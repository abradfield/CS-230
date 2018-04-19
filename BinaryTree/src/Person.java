public class Person implements Comparable<Person> {
    private String name;
    private String phoneNumber;

    public Person() {
        this.name = "Bob";
        this.phoneNumber = "000-000-0000";
    }

    public Person(String newName, String newNumber) {
        this.name = newName;
        this.phoneNumber = newNumber;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeNumber(String newNumber) {
        this.phoneNumber = newNumber;
    }

    public String returnName() {
        return name;
    }

    public String returnPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        String message = name + "\t\t" + phoneNumber;
        return message;
    }

    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}