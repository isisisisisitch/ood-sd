package ca.bytetube.ood._06_bookreservation;

public class Book extends Resource {
    private String author;
    private String isbn;


    public Book(String id, String name, int quantity, String author, String isbn) {
        super(id, name, quantity);
        this.author = author;
        this.isbn = isbn;
    }
}
