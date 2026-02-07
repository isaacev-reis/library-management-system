package view;

import model.BookModel;

public class LibraryView {
    public void showMenu() {
        System.out.println("======== MENU ========");
        System.out.println("1 - Add a book");
        System.out.println("2 - List all books");
        System.out.println("3 - List available books");
        System.out.println("4 - List books by author");
        System.out.println("5 - List books by year");
        System.out.println("6 - Lend a book");
        System.out.println("7 - Return a book");
        System.out.println("8 - Exit");
    }


    public void showBook(BookModel book) {
        System.out.println("Name: " + book.getName());
        System.out.println("ID: " + book.getId());
    }

    public void message(String message) {
        System.out.println(message);
    }

    public void erro(String message) {
        System.err.println(message);
    }

    public void exitProgram() {
        System.out.println("closing program");
    }
}
