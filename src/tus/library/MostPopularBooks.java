package tus.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Immutable Type
public final class MostPopularBooks {
     private final List<Book> popularBooks;

     // Defensive Copies
    public List<Book> getPopularBooks() {
        return popularBooks;
    }

    public MostPopularBooks(List<Book> popularBooks) {
        this.popularBooks = Collections.unmodifiableList(new ArrayList<>(popularBooks));
    }

    @Override
    public String toString() {
        return "MostPopularBooks{" +
                "popularBooks=" + popularBooks +
                '}';
    }
}
