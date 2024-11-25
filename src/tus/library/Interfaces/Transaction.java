package tus.library.Interfaces;

import tus.library.Book;

public interface Transaction {
    void borrowBook(Book book);
    void returnBook(Book book);
}
