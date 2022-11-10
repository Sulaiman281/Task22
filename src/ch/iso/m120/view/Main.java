package ch.iso.m120.view;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import ch.iso.m120.controller.MyExitRunable;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage window;
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setScene(new Scene(new LoginPage().getRoot(),400,600));
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
