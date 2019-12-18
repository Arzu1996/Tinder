package app.entity;

public class User {
    public boolean valid;
    private int userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String image;

    public User(String email, String pass) {
        this.email = email;
        this.password = pass;
    }

    public User(String firstName, String lastName, int age, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.image = image;
    }

    public User(String email, String password, String firstName, String lastName, int age, String image) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.image = image;
    }


    public User(int userId, String email, String password, String firstName, String lastName, int age, String image) {
        this.userId=userId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.image = image;
    }


    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean newValid) {
        valid = newValid;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
