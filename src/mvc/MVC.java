package mvc;

import java.util.ArrayList;
import java.util.List;
import model.Author;
import model.Book;
import view.MainView;

public class MVC {
    
    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.display();
    }
    
}
