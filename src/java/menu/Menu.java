package menu;

import entity.Teacher;
import java.util.InputMismatchException;
import java.util.Scanner;
import restclient.RestClient;

public class Menu {

    Scanner sc = new Scanner(System.in);

    public int mainMenu() {
        while (true) {
            try {
                System.out.println("Welcome to the system that handles teachers in a database!");
                System.out.println("\n1. Create and add a teacher");
                System.out.println("2. View all teachers");
                System.out.println("3. View a specific teacher");
                System.out.println("4. Edit a existing teacher");
                System.out.println("5. Delete a teacher");
                System.out.println("0. Exit");
                System.out.println("\nEnter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                return choice;
            } catch (InputMismatchException ie) {
                System.out.println("Not a valid choice, try again");
            }
        }
    }

    public boolean menuSwitch(int menuChoice) {
        RestClient rc = new RestClient();
        switch (menuChoice) {
            case 1:
                System.out.println("Enter id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name:");
                String name = sc.nextLine();
                Teacher t = new Teacher(id, name);
                rc.createTeacher(t);
                System.out.println("The teacher is now added.");
                break;
            case 2:
                for (Teacher t1 : rc.getAllTeachers()) {
                    System.out.println(t1);
                }
                break;
            case 3:
                System.out.println("Enter id: ");
                System.out.println(rc.getTeacher(sc.nextLine()));
                break;
            case 4:
                System.out.println("Enter the id for the teacher you want to update: ");
                int id2 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the new name: ");
                String name1 = sc.nextLine();
                Teacher t1 = new Teacher(id2, name1);
                rc.updateTeacher(t1);
                System.out.println("The teacher is now updated");
                break;
            case 5:
                System.out.println("Enter the id for the teacher you want to delete: ");
                String id3 = sc.nextLine();
                rc.delete(id3);
                System.out.println("The teacher is now deleted.");
                break;
            case 0:
                return false;
            default:
                System.out.println("Wrong choice, try again");

        }
        return true;
    }
}
