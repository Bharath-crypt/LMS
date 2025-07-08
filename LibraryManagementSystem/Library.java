package LibraryManagementSystem;

import java.util.*;

public class Library {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();
    private int nextBookId = 1;
    private int nextUserId = 1;

    public void addBook(String title, String author) {
        Book b = new Book(nextBookId++, title, author);
        books.add(b);
        System.out.println("Book added with ID: " + b.getBookId());
    }

    public void removeBook(String title) {
        books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
        System.out.println("Book(s) removed.");
    }

    public void viewBooks() {
        for (Book b : books) {
            System.out.println("ID: " + b.getBookId() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", Available: " + b.isAvailable());
        }
    }

    public void registerUser(String name) {
        System.out.print("Is the user a student or teacher? (s/t): ");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        User u = type.equalsIgnoreCase("s") ? new Student(nextUserId++, name) : new Teacher(nextUserId++, name);
        users.add(u);
        System.out.println("User registered with ID: " + u.userId);
    }

    private User findUserByName(String name) {
        for (User u : users) {
            if (u.name.equalsIgnoreCase(name)) return u;
        }
        return null;
    }

    private Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    public void borrowBook(String userName, String title) {
        User u = findUserByName(userName);
        Book b = findBookByTitle(title);
        if (u != null && b != null) {
            if (u.borrowBook(b)) {
                System.out.println("Book borrowed.");
            } else {
                System.out.println("Borrow failed. Book may be unavailable or limit exceeded.");
            }
        } else {
            System.out.println("User or Book not found.");
        }
    }

    public void returnBook(String userName, String title) {
        User u = findUserByName(userName);
        Book b = findBookByTitle(title);
        if (u != null && b != null) {
            if (u.returnBook(b)) {
                System.out.println("Book returned.");
            } else {
                System.out.println("Return failed.");
            }
        } else {
            System.out.println("User or Book not found.");
        }
    }
}
