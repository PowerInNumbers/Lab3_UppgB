package bookUtils;

import bookUtils.BookMatcher;

import java.util.ArrayList;

public class CollectionOfBooks implements BookMatcher {
    //TODO: den här klassen har inte mycket funktionalitet än.
    //TODO: Den ska kunna kunna lägga till och ta bort böcker
    //TODO: Den ska kunna lista alla böcker
    //TODO: Den ska kunna göra en sökning
    //TODO:
    private ArrayList<Book> collection;

    public CollectionOfBooks(){
        collection = new ArrayList(0);
    }
    public boolean add(Book book){
        collection.add(book); // TODO: returnera faslse om boken redan finns. Inga dubletter
    return true;
    }

    @Override
    public boolean matches(Book bookToMatch) { // TODO skapa denna metod
        return false;
    }
}
