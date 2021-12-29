package escapeReference;

import java.util.Iterator;

public class MainEscapable {

    public static void main(String[] args) {
        LibraryEscapeable library = new LibraryEscapeable();
        library.addBook(new Book("Java","HeadFirst"));

        /*This kind of operation will fail*/
        library.getBooks().add(new Book("C","Balaguruswamy"));


    }
}
