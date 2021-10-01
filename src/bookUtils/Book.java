package bookUtils;

import java.util.ArrayList;
import java.util.Locale;

public class Book implements Comparable{
    private ArrayList<Author> authors;

    private final String title;
    private final Genre genre;
    private Isbn isbn;
    private int rating;

    // Det finns konstruktorer i flera steg, beroende på hur mycket info man vill ge den från början
    // Jag hade kunnat tycka att man kunde bestämma genre senare men det står i labbspecen att den ska vara final, därför krävs den i alla konstruktorer

    public Book(String title, Isbn isbn, Genre genre) {
        authors = new ArrayList<Author>(0);
        this.title = title;
        this.genre = genre;
        this.isbn = isbn;
    }

    public Book(Author author, String title, Isbn isbn, Genre genre,  int rating) {
        this(title, isbn, genre);
        authors.add(author);
        this.rating = rating;
    }

    public Book(ArrayList<Author> authorsToAdd, String title, Isbn isbn, Genre genre,  int rating) { //you can get away with not entering genre and rating
        this( title, isbn, genre);
        authors.forEach((n) -> authors.add(n));
    }



    @Override // Gör en vanlig compareto på namnet, är det samma ger den sig på rating.
    public int compareTo(Object book) {
        int result = 0;
        if (!(book instanceof Book)){
            throw new IllegalArgumentException("Comparing books with apples");
        }
        String titleToComp = ((Book) book).getTitle().toLowerCase(Locale.ROOT);
        int ratingToComp = ((Book) book).getRating();

         if (titleToComp.compareTo(this.title.toString().toLowerCase(Locale.ROOT)) != 0){ // Sedan kollar man om de har samma titel
                return titleToComp.compareTo(this.title.toString());
            }
            else return ratingToComp - this.rating;
    }

    // Getters för alla värden
    public ArrayList<Author> getAuthors() {
        ArrayList<Author> tmpLst = new ArrayList<Author>();
        tmpLst.addAll(this.authors);
        return tmpLst;
    }

    public void addAuthor(Author a){ // TODO skydda mot dubletter
        authors.add(a);
        return;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public int getRating() {
        return rating;
    }

    // Setters för isbn och rating
    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    } //  (borde isbn vara final?)

    public void setRating(int rating) {
        this.rating = rating;
    }


    public boolean equals( Book book){
        String title1 = this.title.toLowerCase(Locale.ROOT);
        String title2 = book.getTitle().toLowerCase(Locale.ROOT);
        ArrayList<Author> auth1 = this.authors;
        ArrayList<Author> auth2 = book.getAuthors();


        if (title1.compareTo(title2) != 0){ // Har de inte samma titel är de olika
            return false;
        } else
        if(auth1.size() != auth2.size()){ // Har de olika antal författare är de olika
            return false;
        } else
        for (int i = 0; i < auth2.size(); i++) {
            if(! auth2.contains(auth1.get(i))){
                return false;
            }
        }
        return  true;
    }

    @Override
    public String toString() {
        String tmpStr = "Book{" +
                "author(s)=";
        for (int i = 0; i < authors.size(); i++) {
            Author a = authors.get(i);
            tmpStr +=", ";
            tmpStr += a.getName();
        }

        tmpStr += ", title='" + title + '\'';
        tmpStr += " genre = " + genre;
        tmpStr += ", Isbn = " + isbn.toString();
        tmpStr += ", rating = " + rating;
        tmpStr += "}";
        return tmpStr;
    }
}
