import bookUtils.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Isbn i1 = new Isbn("012");
        Isbn i2 = new Isbn("234");
        Isbn i3 = new Isbn("345");

        Author satoshi = new Author("Satoshi Nakamoto", LocalDate.of(1984, 11, 5));
        Author khalil = new Author("Khalil Gibran", LocalDate.of(1984, 11, 5));
        Author orwell = new Author("George Orwell", LocalDate.of(1984, 11, 5));


        //Author satoshi = new Author("Satoshi Nakamoto", LocalDate.of(1984, 11, 5));
        Book b1 = new Book(satoshi, "crypto", i1, Genre.OTHER , 2);
        Book b2 = new Book(khalil, "the prophet", i2, Genre.OTHER , 5);
        Book b3 = new Book(satoshi, "CrYpTo", i3, Genre.OTHER , 5);
        b3.addAuthor(orwell);

        System.out.println(b1.toString());
        System.out.println(b3.toString());

        int comp = b1.compareTo(b3);
        System.out.println("comp = " + comp);
        System.out.println("b1 = b3? =" + b1.equals(b3));


    }
}