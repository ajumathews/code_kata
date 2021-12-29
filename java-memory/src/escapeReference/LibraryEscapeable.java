package escapeReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LibraryEscapeable{

    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }


}


