package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // instance properties
    private List<String> authors = new ArrayList<String>();

    // classifier properties
    private static int nbDBooks = 0;

    // constructors
    public Book() {
        this(null, null, 0);
    }

    public Book(String title, String category, double cost) {
        super(++nbDBooks, title, category, cost);
    }

    // getters, setters
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // instance methods
    public void addAuthor(String authorName) {
        List<String> auths = getAuthors();
        if (auths.contains(authorName)) {
            System.out.println("Author is already existed.");
            return;
        }
        auths.add(authorName);
        System.out.println("Added to authors.");
    }

    public void removeAuthor(String authorName) {
        List<String> auths = getAuthors();
        if (auths.contains(authorName)) {
            auths.remove(authorName);
            System.out.println("Removed from authors.");
        } else System.out.println("Author is not present.");
    }
}