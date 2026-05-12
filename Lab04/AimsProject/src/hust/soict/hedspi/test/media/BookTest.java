package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book();
        System.out.println(book.getAuthors());

        book.addAuthor("KND");
        System.out.println(book.getAuthors());

        book.addAuthor("KND");
        System.out.println(book.getAuthors());

        book.removeAuthor("PVA");
        System.out.println(book.getAuthors());

        book.removeAuthor("KND");
        System.out.println(book.getAuthors());
    }
}
