package controller;

import service.LibraryService;
import view.LibraryView;

import java.util.Scanner;

public class LibraryController {
    LibraryView view = new LibraryView();
    LibraryService service = new LibraryService();
    Scanner scanner = new Scanner(System.in);
    int option;

    public void receiveOption() {
        option = scanner.nextInt();
        scanner.nextLine();
    }

    public void handleOption() {
        while (option != 8) {
            view.showMenu();
            receiveOption();
            try {
                switch (option) {
                    case 1 -> addBook();
                    case 2 -> listAllBooks();
                    case 3 -> listAvailables();
                    case 4 -> listByAuthor();
                    case 5 -> listByYear();
                    case 6 -> lendBook();
                    case 7 -> returnBook();
                    default -> view.erro("INVALID OPTION");
                }
            } catch (RuntimeException e) {
                view.erro(e.getMessage());
            }
        }
    }

    private void addBook() {
        view.message("ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        view.message("Name:");
        String name = scanner.nextLine();

        view.message("Author:");
        String author = scanner.nextLine();

        view.message("Year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        service.addBook(id, name, author, year);
    }

    private void listAllBooks() {
        view.message("Book list: ");
        service.listAllBooks().forEach(x -> view.showBook(x));
    }

    private void listAvailables() {
        view.message("Available books: ");
        service.listAvailable().forEach(x -> view.showBook(x));
    }

    private void listByAuthor() {
        view.message("Author: ");
        String autor = scanner.nextLine();
        service.listByAuthor(autor).forEach(x -> view.showBook(x));
    }

    private void listByYear() {
        service.listByYear().forEach(x -> view.showBook(x));
    }

    private void lendBook() {
        view.message("Enter the ID of the book you want to borrow: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        service.lendBook(id);
    }

    private void returnBook() {
        view.message("Enter the ID of the book you want to return: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        service.returnBook(id);
    }
}
