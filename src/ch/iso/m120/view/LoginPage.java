package ch.iso.m120.view;

import ch.iso.m120.model.AddressOvservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage {

    private VBox root;

    private TextField textField;
    private PasswordField passwordField;
    private Button login;

    public LoginPage(){
        initialize();
    }

    void initialize(){
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Label label = new Label("Login Page");
        label.setFont(Font.font("Arial",22));


        textField = new TextField();
        textField.setPromptText("username");
        textField.setAlignment(Pos.CENTER);
        textField.setFont(Font.font("Arial",18));
        textField.setPrefWidth(300);
        textField.setMaxWidth(300);

        passwordField = new PasswordField();
        passwordField.setPromptText("password");
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setFont(Font.font("Arial",18));
        passwordField.setPrefWidth(300);
        passwordField.setMaxWidth(300);

        login = new Button("Login");
        login.setOnAction(e->{
            if(textField.getText().isEmpty() || passwordField.getText().isEmpty()) return;

            String username = textField.getText();
            String pass = passwordField.getText();

            if(username.equals("user") && pass.equals("pass")){
                Main.window.setScene(new HomePage().getScene());
                Main.window.centerOnScreen();
            }

//            String query = "SELECT * tUser WHERE username = '"+username+"';";
//            try {
//                ResultSet rs = new AddressOvservableList().getConnection().prepareStatement(query).executeQuery();
//                while(rs.next()){
//                    if(rs.getString("usePassword").equals(pass)){
//                        // load the main menu.
//                        Main.window.setScene(new HomePage().getScene());
//                        Main.window.centerOnScreen();
//                    }
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
        });

        Hyperlink register = new Hyperlink("Create new Account.");
        register.setFont(Font.font("Arial",14));
        register.setOnAction(e->{
            Main.window.setScene(new Scene(new RegisterPage().getRoot(),400,600));
            Main.window.centerOnScreen();
        });

        root.getChildren().addAll(label,textField,passwordField,login,register);
    }

    public VBox getRoot() {
        return root;
    }
}
