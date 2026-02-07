package repository;

import model.BookModel;

import java.util.HashMap;
import java.util.Map;

public class LibraryRepository {
    private Map<Long, BookModel> library = new HashMap<>();

    public Map<Long, BookModel> getLibrary() {
        return library;
    }
}
