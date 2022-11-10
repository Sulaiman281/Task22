package ch.iso.m120.view;

import ch.iso.m120.model.AddressOvservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterPage {

    private VBox root;

    public RegisterPage(){
        initialize();
    }

    void initialize(){
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Label label = new Label("Register User.");
        label.setFont(Font.font("Arial",18));
        TextField nameInput = getTextField("Name");
        TextField username = getTextField("Username");
        TextField email = getTextField("Email");

        PasswordField pass = new PasswordField();
        pass.setPromptText("Password");
        pass.setFont(Font.font("Arial",14));
        pass.setPrefWidth(300);
        pass.setMaxWidth(300);

        Button register = new Button("Register");

        register.setOnAction(e->{
            if(nameInput.getText().isEmpty() || username.getText().isEmpty() || email.getText().isEmpty() || pass.getText().isEmpty()) return;
            String query = "INSERT INTO tUser (name,username,password,email) VALUES(?,?,?,?);";
            try {
                PreparedStatement statement = new AddressOvservableList().getConnection().prepareStatement(query);
                statement.setString(1,nameInput.getText());
                statement.setString(2,username.getText());
                statement.setString(3,email.getText());
                statement.setString(4,pass.getText());
                statement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        Hyperlink toLoginPage = new Hyperlink("Already Have Account");
        toLoginPage.setFont(Font.font("Arial",14));
        toLoginPage.setOnAction(e->{
            Main.window.setScene(new Scene(new LoginPage().getRoot(),400,600));
            Main.window.centerOnScreen();
        });

        root.getChildren().addAll(label,nameInput,username,email,pass,register,toLoginPage);
    }

    TextField getTextField(String hint){
        TextField nameField = new TextField();
        nameField.setPromptText(hint);
        nameField.setFont(Font.font("Arial",14));
        nameField.setPrefWidth(300);
        nameField.setMaxWidth(300);
        return nameField;
    }

    public VBox getRoot() {
        return root;
    }
}
