package escapeReference;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Java","HeadFirst"));

        /*This kind of operation is not recomended. where it will  mutate the collection using get opetation*/
        library.getBooks().add(new Book("C","Balaguruswamy"));


        /*Here we are able to remove objects from collection*/
        Iterator iterator= library.getBooks().iterator();
        while(iterator.hasNext()){
            Book book = (Book) iterator.next();
            iterator.remove();
        }

        System.out.println(library.getBooks().size());
    }
}
