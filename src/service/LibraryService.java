package service;

import model.BookModel;
import repository.LibraryRepository;
import java.util.Comparator;
import java.util.List;

public class LibraryService {
    LibraryRepository repository = new LibraryRepository();

    public void addBook(Long id, String name, String author, int year) {
        BookModel book = new BookModel(id, name, author, year);
        repository.getLibrary().put(id, book);
    }

    public void removeBook(Long key_id) {
        repository.getLibrary().remove(key_id);
    }

    public void lendBook(Long id) {
        BookModel book = repository.getLibrary().get(id);
        if (book.isAvailable()) {
            book.setAvailable(false);
        }
    }

    public void returnBook(Long id) {
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

    public List<BookModel> listAvailable() {
        return repository.getLibrary().values().stream()
                .filter(x -> x.isAvailable()).toList();
    }

    public List<BookModel> listByYear() {
        return repository.getLibrary().values().stream()
                .sorted(Comparator.comparing(BookModel::getYear)).toList();
    }
}
