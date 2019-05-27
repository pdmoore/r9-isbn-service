package dev.emergent;

public interface BookInfoProvider {
    BookInfo retrieve(String isbn);
}
