package model;

public class UserInfo {

    private int userId;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private boolean isManager;

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean isManager() {
        return isManager;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserInfo(int userId, String login, String password, String firstName,
                    String lastName, String email, String phone, boolean isManager) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.isManager = isManager;
    }
}
