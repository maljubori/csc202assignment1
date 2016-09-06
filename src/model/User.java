package model;

import java.io.Serializable;

/**
 * Created by m_al_ on 9/5/2016.
 */
public class User extends Person implements Serializable {
    private String username;
    private String password;
    private String phonenumber;
    private String email;
    private String profilepic;

    public User()
    {
        super();
    }
    public User(String username, String password) {

            this.username =username;
            this.password =password;
    }
    public User(String username, String password, String phonenumber, String email, String profilepic){
            this.username = username;
            this.password = password;
            this.phonenumber = phonenumber;
            this.email = email;
            this.profilepic = profilepic;
    }
    public User(String firstname, String lastname, String birthdate, String gender, String social, String username, String email, String phonenumber, String password, String profilepic) {
        super(firstname, lastname, birthdate, gender, social);
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhone(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public boolean equals(User user) {
        return(this.username.equals(user.username));
    }


    public int compareTo(User user) {
        return(this.username.compareTo(user.username));
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", password='" + password + '\'' +
                ", profilepic='" + profilepic + '\'' +
                '}';
    }

}
