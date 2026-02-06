package service;

import model.BookModel;
import repository.LibraryRepository;

public class LibraryService {
    LibraryRepository repository = new LibraryRepository();

    public void addBook(Long key_id, BookModel book, String name, String author, int year) {
        book.setName(name);
        book.setAuthor(author);
        book.setYear(year);
        repository.getLibrary().put(key_id, book);
    }

    public void removeBook(Long key_id) {
        repository.getLibrary().remove(key_id);
    }

    public void toLend(BookModel book) {
        if (book.isAvailable()) {
            System.out.println("SUCCESSFUL!");
            book.setAvailable(false);
        } else {
            System.out.println("This book is unavailable!");
        }
    }

    public void toReturn(BookModel book) {
        if (!(book.isAvailable())) {
            System.out.println("SUCCESSFUL!");
            book.setAvailable(true);
        } else {
            System.out.println("You don't have this book!");
        }
    }
}
