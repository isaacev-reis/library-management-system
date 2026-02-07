package controller;

import model.BookModel;
import repository.LibraryRepository;
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
                    case 6 -> toLend();
                    case 7 -> toReturn();
                    default -> view.erro();
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

        view.message("Nome:");
        String name = scanner.nextLine();

        view.message("Autor:");
        String author = scanner.nextLine();

        view.message("Ano:");
        int year = scanner.nextInt();
        scanner.nextLine();

        service.addBook(id, name, author, year);
    }

    private void listAllBooks() {
        view.message("Lista de livros: ");
        service.listAllBooks().forEach(x -> view.showBook(x));
    }

    private void listAvailables() {
        view.message("Livros disponíveis: ");
        service.listAvailables().forEach(x -> view.showBook(x));
    }

    private void listByAuthor() {
        view.message("Autor: ");
        String autor = scanner.nextLine();
        service.listByAuthor(autor).forEach(x -> view.showBook(x));
    }

    private void listByYear() {
        service.listByYear().forEach(x -> view.showBook(x));
    }

    private void toLend() {
        view.message("Digite o id do livro que deseja pegar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        service.toLend(id);
    }

    private void toReturn() {
        view.message("Digite o id do livro que deseja devolver: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        service.toReturn(id);
    }
}
