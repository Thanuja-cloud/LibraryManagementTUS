package tus.library;

public class Admin {
    private String adminName;
    private String email;
    private int adminId;

    Admin(String adminName, String email, int adminId){
        this.adminName = adminName;
        this.email = email;
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", email='" + email + '\'' +
                ", adminId=" + adminId +
                '}';
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
