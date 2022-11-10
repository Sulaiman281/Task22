package ch.iso.m120.view;

import ch.iso.m120.controller.MyExitRunable;
import ch.iso.m120.model.Address;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class HomePage {
    private static final Font FONT = Font.font("", FontWeight.BOLD, 18);

    private VBox menuBox;
    private int currentItem = 0;

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(900, 600);

        Rectangle bg = new Rectangle(900, 600);

        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setOnActivate(new MyExitRunable());

        MenuItem splayer = new MenuItem("Solo Player");

        MenuItem mplayer = new MenuItem("Multi Player");

        MenuItem profil = new MenuItem("Profile");

        MenuItem mons = new MenuItem("Monster");
        mons.setOnMouseClicked(e->{
            BorderPane pane = new BorderPane();
            pane.setTop(new MyMenuBar());
            pane.setCenter(new MyTableView<Address>());
            pane.setBottom(new MyButtonBar());

            Main.window.setScene(new Scene(pane));
            Main.window.centerOnScreen();
        });

        MenuItem welten = new MenuItem("Worlds");
        welten.setOnMouseClicked(e->{
            BorderPane pane = new BorderPane();
            pane.setTop(new WorldMenuBar());
            pane.setCenter(new MyTableViewWorld<>());
            pane.setBottom(new WorldBottomBar());

            Main.window.setScene(new Scene(pane));
            Main.window.centerOnScreen();
        });

        MenuItem items = new MenuItem("Items");
        items.setOnMouseClicked(e->{
            BorderPane pane = new BorderPane();
            pane.setTop(new ItemMenuBar());
            pane.setCenter(new ItemTableView<>());
            pane.setBottom(new ItemBottomBar());

            Main.window.setScene(new Scene(pane));
            Main.window.centerOnScreen();
        });

        menuBox = new VBox(10, splayer, mplayer, profil, mons, welten, items, itemExit);
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(360);
        menuBox.setTranslateY(300);

        Text about = new Text("");
        about.setTranslateX(50);
        about.setTranslateY(500);
        about.setFill(Color.WHITE);
        about.setFont(FONT);
        about.setOpacity(0.2);

        getMenuItem(0).setActive(true);

        root.getChildren().addAll(bg, menuBox, about);
        return root;
    }

    private MenuItem getMenuItem(int index) {
        return (MenuItem) menuBox.getChildren().get(index);
    }

    private static class MenuItem extends HBox {
        private TriCircle c1 = new TriCircle(), c2 = new TriCircle();
        private Text text;
        private Runnable script;

        public MenuItem(String name) {
            super(15);
            setAlignment(Pos.CENTER);

            text = new Text(name);
            text.setFont(FONT);
            text.setEffect(new GaussianBlur(2));

            getChildren().addAll(c1, text, c2);
            setActive(false);
            // setOnActivate(() -> System.out.println(name + " activated"));
        }

        public void setActive(boolean b) {
            c1.setVisible(b);
            c2.setVisible(b);
            text.setFill(b ? Color.WHITE : Color.GREY);
        }

        public void setOnActivate(Runnable r) {
            script = r;
        }

        public void activate() {
            if (script != null)
                script.run();
        }
    }

    private static class TriCircle extends Parent {
        public TriCircle() {
            Shape shape1 = Shape.subtract(new Circle(5), new Circle(2));
            shape1.setFill(Color.WHITE);

            Shape shape2 = Shape.subtract(new Circle(5), new Circle(2));
            shape2.setFill(Color.WHITE);
            shape2.setTranslateX(5);

            Shape shape3 = Shape.subtract(new Circle(5), new Circle(2));
            shape3.setFill(Color.WHITE);
            shape3.setTranslateX(2.5);
            shape3.setTranslateY(-5);

            getChildren().addAll(shape1, shape2, shape3);

            setEffect(new GaussianBlur(2));
        }
    }

    public Scene getScene(){
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (currentItem > 0) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(--currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.DOWN) {
                if (currentItem < menuBox.getChildren().size() - 1) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(++currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.ENTER) {
                getMenuItem(currentItem).activate();
            }
        });
        return  scene;
    }
}
