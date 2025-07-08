package LibraryManagementSystem;

import java.util.*;

abstract class User {
    int userId;
    String name;
    List<Integer> borrowedBooks = new ArrayList<>();

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public abstract int getLimit();

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < getLimit() && book.isAvailable()) {
            borrowedBooks.add(book.getBookId());
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book.getBookId())) {
            borrowedBooks.remove(Integer.valueOf(book.getBookId()));
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}

