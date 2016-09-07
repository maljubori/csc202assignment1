package controller;



/**
 * Created by m_al_ on 9/2/2016.
 */
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.User;
import model.Userdatabase;
import model.UserIO;
import sample.SignUpJavaFXView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sample.AccountJavaFXView;

import static sample.SignUpJavaFXView.signupStage;

public class SignupController {
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
                Userdatabase.users.add(newuser);
                UserIO.writeUsers(Userdatabase.getUsers());
                System.out.println("Database succesfuly updated!");
                signupStage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void createFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(SignUpJavaFXView.getSignupStage());
        System.out.println(selectedFile.getPath());

    }
}

