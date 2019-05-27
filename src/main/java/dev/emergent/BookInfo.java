package dev.emergent;

public class BookInfo {
    private final String ISBN_10;
    private final String ISBN_13;
    private final String author;
    public String title;

    public BookInfo(String title) {
        this(title, null, null, null);
    }

    public BookInfo(String title, String author, String ISBN_10, String ISBN_13) {
        this.title = title;
        this.author = author;
        this.ISBN_10 = ISBN_10;
        this.ISBN_13 = ISBN_13;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        sb.append(", ");
        sb.append(author);
        sb.append(", ");
        sb.append(ISBN_10);
        sb.append(", ");
        sb.append(ISBN_13);
        return sb.toString();
    }

    public String isbn10() {
        return ISBN_10;
    }

    public String isbn13() {
        return ISBN_13;
    }
}
