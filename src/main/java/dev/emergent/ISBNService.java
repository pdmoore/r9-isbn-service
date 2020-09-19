package dev.emergent;

import java.util.HashMap;

public class ISBNService implements BookInfoProvider {

    private static BookInfoProvider singleton = null;
    private final HashMap<String, BookInfo> booksByIsbn10;
    private final HashMap<String, BookInfo> booksByIsbn13;

    String[][] books = new String[][] {
            {"97 Things Every Programmer Should Know", "Kevlin Henney",   "0596809484", "9780596809485"},
            {"Accelerate", "Forsgren, Humble, Kim",                       "1942788339", "9781942788331"},
            {"Pattern-Oriented SW Architecture Vol 1", "Frank Buschmann", "0471958697", "9780471958697"},
            {"Pattern-Oriented SW Architecture Vol 2", "Douglas Schmidt", "0471606952", "9780471606956"},
            {"Pattern-Oriented SW Architecture Vol 3", "Michael Kircher", "0478084525", "9780470845257"},
            {"Pattern-Oriented SW Architecture Vol 4", "Frank Buschmann", "0470059028", "9780470059029"},
            {"Pattern-Oriented SW Architecture Vol 5", "Frank Buschmann", "0471486485", "9780471486480"},
            {"Refactoring", "Martin Fowler",                              "0201485672", "9780201485677"},
            {"Refactoring 2nd Edition", "Martin Fowler",                  "0134757599", "9780134757599"},
            {"Test Driven Development by Example", "Kent Beck",           "0321146530", "9780321146533"},
            {"The Laws of Simplicity", "John Maeda",                      "0262134721", "9780262134729"},
            {"The Thief Lord", "Cornelia Funke",                          "043942089X", "9780439420891"},
            {"Working Effectively with Legacy Code", "Michael Feathers",  "0131177052", "9780131177055"},
            {"xUnit Test Patterns", "Gerard Meszaros",                    "0131495054", "9780131495050"},
    };

    public static BookInfoProvider getInstance() {
        if (singleton == null) {
            singleton = new ISBNService();
        }

        return singleton;
    }

    private ISBNService() {
        // private constructor
        booksByIsbn10 = new HashMap<String, BookInfo>();
        booksByIsbn13 = new HashMap<String, BookInfo>();

        for (String[] book:
              books) {
            BookInfo bi = new BookInfo(book[0], book[1], book[2], book[3]);
            booksByIsbn10.put(bi.isbn10(), bi);
            booksByIsbn13.put(bi.isbn13(), bi);
        }
    }

    public BookInfo retrieve(String isbn) {
        if (10 == isbn.length()) {
            return booksByIsbn10.get(isbn);
        }

        return booksByIsbn13.get(isbn);
    }
}
