package tus.library;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
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

    public User(String uName, String email, String role, int userId, List<Book> booksBorrowed, boolean isStudent) throws Exception {
        this.uName = uName;
        if(isValidEmail(email)) {
            this.email = email;
        }
        else{
            throw new Exception("Invalid email, cannot create user");
        }
        switch (role) {
            case "student":
                this.maxTime = 30;
                this.maxBooksToBorrow = 10;
                this.fineAmount = 0.5f;
            case "professor":
                this.maxTime = 100;
                this.maxBooksToBorrow = 5;
                this.fineAmount = 0.75f;
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

}
