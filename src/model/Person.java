package model;

/**
 * Created by m_al_ on 9/5/2016.
 */
import java.io.Serializable;

public class Person implements Serializable {
    private String firstname;
    private String lastname;
    private String birthdate;
    private String gender;
    private String social;

    public Person() {
        this.firstname = "Firstname temp";
        this.lastname = "Lastname temp";
        this.birthdate = "mo/dy/yr";
        this.gender = "m/f";
        this.social = "xxx-xx-xxxx";
    }
    public Person(String firstname, String lastname, String birthdate, String gender, String social) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.social = social;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setDob(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", dob='" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
