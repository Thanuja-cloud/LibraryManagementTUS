package tus.library.Interfaces;

import tus.library.Book;
import tus.library.User;

import java.time.LocalDate;

public interface Payment  {
        float finePayment(User user);

        // Default method
        default void showTransaction(float amount, String userId, Book book,  LocalDate transactionDate){
                System.out.println("Log: " + processTransactionData(book, transactionDate) + "for user: "+ userId + " amount: "+ amount );

        }

        // Private method
        private String processTransactionData(Book book, LocalDate transactionDate){
                return  book.getBookName() + transactionDate.toString();
        }

        // Static method
        static String defaultPayment(){
                return "This is a default payment";
        }
}
