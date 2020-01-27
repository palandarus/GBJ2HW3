import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, ArrayList<Person>> pages;

    public PhoneBook(ArrayList<Person> notes) {
        pages = new HashMap<>();
        ArrayList<Person> temp;
        for (Person person : notes
        ) {
            if (pages.get(person.getLastName()) != null) {

                temp = pages.get(person.getLastName());
                temp.add(person);
            } else {
                temp = new ArrayList<>();
                temp.add(person);
                pages.put(person.getLastName(), temp);
            }
        }
    }

    public ArrayList<String> searchEmail(String lname) {
        ArrayList<Person> owners = pages.get(lname);
        ArrayList<String> emails = new ArrayList<>();
        for (Person person : owners
        ) {
            emails.add(person.getEmail());
        }
        return emails;
    }

    public ArrayList<String> searchPhone(String lname) {
        ArrayList<Person> owners = pages.get(lname);
        ArrayList<String> phones = new ArrayList<>();
        for (Person person : owners
        ) {
            phones.add(person.getPhone());
        }
        return phones;
    }

    public void print() {
        for (Map.Entry<String, ArrayList<Person>> entry : pages.entrySet()) {
            System.out.println("Key - " + entry.getKey());
            for (Person person : entry.getValue()
            ) {
                person.print();
            }
        }
    }

}
