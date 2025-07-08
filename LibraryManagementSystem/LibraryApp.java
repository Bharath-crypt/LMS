package LibraryManagementSystem;

import java.util.*;


public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Book\n2. Remove Book\n3. View Books\n4. Register User\n5. Borrow Book\n6. Return Book\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                }
                case 2 -> {
                    System.out.print("Enter title to remove: ");
                    String title = sc.nextLine();
                    lib.removeBook(title);
                }
                case 3 -> lib.viewBooks();
                case 4 -> {
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    lib.registerUser(name);
                }
                case 5 -> {
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter book title to borrow: ");
                    String title = sc.nextLine();
                    lib.borrowBook(name, title);
                }
                case 6 -> {
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter book title to return: ");
                    String title = sc.nextLine();
                    lib.returnBook(name, title);
                }
                case 7 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
