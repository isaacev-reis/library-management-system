import controller.LibraryController;
import model.BookModel;
import repository.LibraryRepository;
import service.LibraryService;

public class LibraryApplication {
    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        controller.handleOption();
    }
}