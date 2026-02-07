package service;

import model.BookModel;
import repository.LibraryRepository;

import java.security.Provider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

public class LibraryService {
    LibraryRepository repository = new LibraryRepository();

    public void addBook(Long id, String name, String author, int year) {
        BookModel book = new BookModel(id, name, author, year);
        repository.getLibrary().put(id, book);
    }

    public void removeBook(Long key_id) {
        repository.getLibrary().remove(key_id);
    }

    public void toLend(Long id) {
        BookModel book = repository.getLibrary().get(id);
        if (book.isAvailable()) {
            book.setAvailable(false);
        }
    }

    public void toReturn(Long id) {
        BookModel book = repository.getLibrary().get(id);
        if (!(book.isAvailable())) {
            book.setAvailable(true);
        }
    }

    public List<BookModel> listAllBooks() {
        return repository.getLibrary().values().stream().toList();
    }

    public List<BookModel> listByAuthor(String author) {
        return repository.getLibrary().values().stream()
                .filter(x -> x.getAuthor().equals(author)).toList();
    }

    public List<BookModel> listAvailables() {
        return repository.getLibrary().values().stream()
                .filter(x -> x.isAvailable()).toList();
    }

    public List<BookModel> listByYear() {
        return repository.getLibrary().values().stream()
                .sorted(Comparator.comparing(BookModel::getYear)).toList();
    }
}
