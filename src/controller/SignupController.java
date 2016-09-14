package controller;



/**
 * Created by m_al_ on 9/2/2016.
 */
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.User;
import model.Userdatabase;
import model.UserIO;
import sample.LoginJavaFXView;
import sample.SignUpJavaFXView;
import java.net.MalformedURLException;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sample.AccountJavaFXView;

import static sample.SignUpJavaFXView.signupStage;

public class SignupController{
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField confirmpassword;
    @FXML
    TextField firstname;
    @FXML
    TextField lastname;
    @FXML
    TextField birthdate;
    @FXML
    TextField email;
    @FXML
    TextField phonenumber;
    @FXML
    TextField ssn;
    @FXML
    TextField gender;
    @FXML
    ImageView imageviewsign;
    public String imageviewpath;

    boolean correct = false;
    boolean usernameexists = false;
    public boolean isLegalPassword(String pass) {
        if (!pass.matches(".*[A-Z].*")) return false;
        if (!pass.matches(".*[a-z].*")) return false;
        if (!pass.matches(".*\\d.*")) return false;
        if (!pass.matches(".*[ ~!@#$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*")) return false;
        return true;
    }

   public boolean isValidEmail(String enteredemail){
       Pattern emailpattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
       Matcher mat = emailpattern.matcher(enteredemail);
       if(mat.matches())
           return true;
       else
           return false;
   }
   public boolean isValidPhone(String enteredphone) {
       Pattern phonepattern = Pattern.compile("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$");
       Matcher mat = phonepattern.matcher(enteredphone);
       if(mat.matches())
           return true;
       else
           return false;
   }
   public boolean isValidDate(String entereddate) {
       Pattern datepattern = Pattern.compile("\\-?[0-9]{2}\\-[0-9]{2}\\-?[0-9]{4}$");
       Matcher mat = datepattern.matcher(entereddate);
       if(mat.matches())
           return true;
       else
           return false;
   }
   public boolean isValidSsn(String enteredssn) {
       Pattern ssnpattern = Pattern.compile("\\-?[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{4}$");
       Matcher mat = ssnpattern.matcher(enteredssn);
       if(mat.matches())
           return true;
       else
           return false;
   }

    public void createAccount() {
        User newuser = new User(firstname.getText(), lastname.getText(), gender.getText(), birthdate.getText(), email.getText(), phonenumber.getText(), ssn.getText(), password.getText(), username.getText());
            for (int i = 0; i < Userdatabase.getUsers().size(); i++) {
                if (username.getText().equals(Userdatabase.getUsers().get(i).getUsername())) {
                    System.out.println("Username already exists");
                    usernameexists= true;
                 }
                 }
            if (!newuser.getPassword().equals(confirmpassword.getText())) {
                System.out.println("Passwords do not match");
                 }
            if(!isLegalPassword(password.getText())) {
                System.out.println("Please make sure your password contains atleast 1 number, 1 uppercase letter, 1 lowercase letter, and one special symbol.");
                 }
            if(!isValidEmail(email.getText())) {
                System.out.println("Please make sure your email is of format xxx@xxx.xxx");
                 }
            if(!isValidPhone(phonenumber.getText())) {
                System.out.println("Please make sure you have a valid phone number format.");
                 }
            if(!isValidDate(birthdate.getText())) {
                System.out.println("Please make sure you have a valid birthdate format.");
                 }
            if(!isValidSsn(ssn.getText())) {
                System.out.println("Please make sure you have a valid SSN format.");
                 }
            if(!gender.getText().equalsIgnoreCase("male")&&!gender.getText().equalsIgnoreCase("female")) {
                System.out.println("Please enter Male or Female for gender");
                 }
            if(!usernameexists&&newuser.getPassword().equals(confirmpassword.getText())&&isLegalPassword(password.getText())&&isValidEmail(email.getText())&&isValidPhone(phonenumber.getText())&&isValidDate(birthdate.getText())&&isValidSsn(ssn.getText())&&gender.getText().equalsIgnoreCase("male")&&!gender.getText().equalsIgnoreCase("female"))
            try {
                newuser.setProfilepic(imageviewpath);
                Userdatabase.users.add(newuser);
                UserIO.writeUsers(Userdatabase.getUsers());
                System.out.println("Database succesfuly updated!");
                signupStage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void createFileChooser() throws MalformedURLException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a profile picture.");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
        File picture = fileChooser.showOpenDialog(SignUpJavaFXView.getSignupStage());
        System.out.println(picture.getPath());
        String imagepath = picture.toURI().toURL().toString();
        imageviewpath = picture.toURI().toURL().toString();
        Image image = new Image(imagepath);
        imageviewsign.setImage(image);
        imageviewsign.setFitHeight(100);
        imageviewsign.setFitWidth(100);

    }
}

