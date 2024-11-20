package tus.library;

import tus.library.Interfaces.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book implements Payment {
    enum BookDepartment {
        CSE, ECE, EEE, MECHANICAL, CIVIL, AIML, DATASCIENCE;
    }

    private String bookName;
    private String author;
    private int bookId;
    private String bookDepartment;
    private boolean isAvailable;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Book(String bookName, String author, int bookId, String bookDepartment, boolean isAvailable) {
        this.bookName = bookName;
        this.author = author;
        this.bookId = bookId;
        this.bookDepartment = bookDepartment;
        this.isAvailable = isAvailable;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookDepartment() {
        return bookDepartment;
    }

    public void setBookDepartment(String bookDepartment) {
        this.bookDepartment = bookDepartment;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    @Override
    public float finePayment(User user) {
        long daysBetween = ChronoUnit.DAYS.between(returnDate, borrowDate);
        return (daysBetween - user.getMaxTime()) * user.getFineAmount();
    }
}
