import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write your name: ");
        String name = scanner.nextLine();
        System.out.println("Write your last name: ");
        String lname = scanner.nextLine();
        System.out.println("Write your age: ");
        int age = Integer.parseInt(scanner.nextLine());
        
        Person person = new Person(name, lname, age);
        Person person2 = new Person("John", "Doe", 30);
    
        System.out.println("Your name is: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Your age is: " + person.getAge());
        System.out.println(person2.getFirstName() + " " + person2.getLastName() + " is " + person2.getAge() + " years old.");
    }
}
