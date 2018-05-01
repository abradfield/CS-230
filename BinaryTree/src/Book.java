import java.util.Scanner;
import java.io.*;

public class Book {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        FileReader file = new FileReader("phonebook.txt");
        Scanner fileIn = new Scanner(file);
        String name, number, response, nextLine;
        BinarySearchTree<Person> PhoneBook = new BinarySearchTree<>();
        FileWriter toFile;
        Person temp;
        boolean continueForBook = true;

        while (fileIn.hasNext()) {
            nextLine = fileIn.nextLine();

            name = nextLine.substring(nextLine.lastIndexOf(" "));
            number = nextLine.substring(nextLine.lastIndexOf( ""), nextLine.length());

            PhoneBook.insert(new Person(name, number));
        }

        System.out.println("Welcome to your address book.");
        System.out.println("-----------------------------\n\n");

        while (continueForBook) {
            System.out.println("MAIN MENU: ");
            System.out.println("1: Add person to phone book");
            System.out.println("2: Delete person from phone book.");
            System.out.println("3: Find a person using their name.");
            System.out.println("4: Change a persons number. ");
            System.out.println("5: Quit\n");
            System.out.println("Select option using either the corresponding number.");
            System.out.print("Selection: ");
            response = keyboard.nextLine();
            System.out.println();

            switch (Integer.parseInt(response)) {
                case 1:
                    System.out.println("You have selected to add someone to your phone book.");
                    System.out.print("Please enter the name: ");
                    name = keyboard.nextLine();
                    System.out.print("Please enter the number: ");
                    number = keyboard.nextLine();

                    PhoneBook.insert(new Person(name, number));
                    System.out.println("Successfully added.\n\n");
                    break;
                case 2:
                    System.out.println("You have selected to delete someone from your phone book.");
                    System.out.print("Please enter the name: ");
                    name = keyboard.nextLine();
                    System.out.print("Please enter the number: ");
                    number = keyboard.nextLine();

                    temp = new Person(name, number);

                    if (PhoneBook.searchFor(temp)) {
                        System.out.println("Deleting " + temp.returnName());
                        PhoneBook.delete(temp);
                        System.out.println("Deletion successful.");
                    }
                    else {
                        System.out.println("The person searched for is not in the tree.");
                    }

                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("You have selected to write the phone book to a file.");
                    System.out.print("Writing to file...");
                    writeToFile(PhoneBook);

                    break;
                case 5:
                    System.out.println("You have selected to exit your phone book.");
                    System.out.println("Exiting.");
                    continueForBook = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    System.out.println("Please use a valid option.\n\n");
            }
        }
    }

    public static void writeToFile(BinarySearchTree bookToPrint) throws IOException{
        boolean completed = false;
        FileWriter toFile = new FileWriter("newphonebook.txt");

        System.out.println("Printing to file..");
    }
}
