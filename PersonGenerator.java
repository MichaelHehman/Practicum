
//PersonClass
public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;  // Year of Birth

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }


    public String toCSVDataRecord() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }
}

//MainStructure

  import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        
    
    }
}

//input collection
String ID;
String firstName;
String lastName;
String title;
int YOB;
boolean done = false;

do {
    // Get the person data using SafeInput methods
    ID = SafeInput.getNonZeroLenString(in, "Enter ID (6 digits)");
    firstName = SafeInput.getNonZeroLenString(in, "Enter first name");
    lastName = SafeInput.getNonZeroLenString(in, "Enter last name");
    title = SafeInput.getNonZeroLenString(in, "Enter title");
    YOB = SafeInput.getRangedInt(in, "Enter year of birth", 1000, 9999);

    // Create and add the person to the ArrayList
    Person person = new Person(ID, firstName, lastName, title, YOB);
    people.add(person);

    // Ask if user wants to add another record
    done = !SafeInput.getYNConfirm(in, "Do you want to add another person?");
} while (!done);

//file writing
String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save");

try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
    // Write each person to the file
    for (Person person : people) {
        writer.println(person.toCSVDataRecord());
    }
    System.out.println("Data written to file successfully!");
} catch (IOException e) {
    System.out.println("Error writing to file: " + e.getMessage());
}
