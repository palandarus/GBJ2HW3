public class Person {
    private String name = "-", lastName = "-", surname = "-", email = "-", phone = "-";

    public Person(String name, String lastName, String surname) {
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.phone = Integer.toString((int) (Math.random() * 100000 + 100000));
        this.email = Integer.toString((int) (Math.random() * 100000 + 100000)) + "@" + Integer.toString((int) (Math.random() * 100000 + 100000)) + ".ru";
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.phone = Integer.toString((int) (Math.random() * 100000 + 100000));
        this.email = Integer.toString((int) (Math.random() * 100000 + 100000)) + "@" + Integer.toString((int) (Math.random() * 100000 + 100000)) + ".ru";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void print() {
        System.out.println("          " + this.name + " " + this.lastName + " " + this.phone + " " + this.email);
    }
}
