package tus.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Catalogue {
    private List<Book> collection;

    public List<Book> getCollection() {
        return collection;
    }

    public void setCollection(List<Book> collection) {
        this.collection = collection;
    }

    // Used defensive copying for booklist
    public Catalogue(List<Book> collection) {
        this.collection = new ArrayList<>(collection);
        //this.collection = collection;
    }
}
