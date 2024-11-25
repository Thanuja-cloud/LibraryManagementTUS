package tus.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public sealed class User permits Student, Professor, OtherStaff {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    protected String uName;
    protected String email;
    protected String role;
    protected int userId;
    protected List<Book> booksBorrowed;
    protected boolean isStudent;
    protected int maxTime;
    protected int maxBooksToBorrow;

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getMaxBooksToBorrow() {
        return maxBooksToBorrow;
    }

    public void setMaxBooksToBorrow(int maxBooksToBorrow) {
        this.maxBooksToBorrow = maxBooksToBorrow;
    }

    public float getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(float fineAmount) {
        this.fineAmount = fineAmount;
    }

    protected float fineAmount;

    // Unchecked Exception to validate email
    public User(String uName, String email, String role, int userId, List<Book> booksBorrowed, boolean isStudent) throws Exception {
        this.uName = uName;
        if(isValidEmail(email)) {
            System.out.println("I have checked for valid email");
            this.email = email;
        }
        else{
            throw new Exception("Invalid email, cannot create user");
        }
        // New Switch Case from Java 23
        switch (role) {
            case "student", "otherstaff" ->{
                this.maxTime = 30;
                this.maxBooksToBorrow = 10;
                this.fineAmount = 0.5f;
            }
            case "professor" ->{
                this.maxTime = 100;
                this.maxBooksToBorrow = 5;
                this.fineAmount = 0.75f;
            }
        }
        this.userId = userId;
        this.booksBorrowed = booksBorrowed;
        this.isStudent = isStudent;
    }

    public User() {}

    public User(boolean isStudent) {
        this.isStudent = isStudent;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                ", booksBorrowed=" + booksBorrowed +
                '}';
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }
    public String donateToLibrary(){
        return "";
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Checked Exception - Compile Time
    public boolean validateIdCard(String fileName){
        try {
            File idCardFile = new File(fileName);
            Scanner sc = new Scanner(idCardFile);
            while(sc.hasNextLine()) {
                System.out.println("I am in reading file lines");
                String idNumber = sc.nextLine();
                if(idNumber.startsWith("A00")){
                    return true;
                }
            }
            return false;
        }
        catch (FileNotFoundException ex){
            System.out.println("Cannot read file: "+ ex.getMessage());
        }
        return false;
    }

}
