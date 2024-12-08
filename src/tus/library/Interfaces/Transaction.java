package tus.library.Interfaces;

import tus.library.Book;

public interface Transaction {
    void borrowBook(Book book);
    void returnBook(Book book);
    // Use of default method
    default void showTransactions(){
        System.out.println("I am a default transaction");
    }
}
