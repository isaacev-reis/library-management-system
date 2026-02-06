package controller;

import model.BookModel;
import service.LibraryService;

import java.util.Scanner;

public class LibraryController {

    LibraryService service = new LibraryService();
    Scanner intScanner = new Scanner(System.in);
    Scanner textScanner = new Scanner(System.in);
    int option;

    public void receiveOption() {
        option = intScanner.nextInt();
    }

    public void handleOption() {
        switch (option) {
            case 1:
                BookModel book = new BookModel();
                Long id = intScanner.nextLong();
                String name = textScanner.nextLine();
                String author = textScanner.nextLine();
                int year = intScanner.nextInt();
                service.addBook(id, book, name, author, year);
                break;
            case 2:
                // fazer ainda
                break;
        }
    }
}
