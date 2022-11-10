package ch.iso.m120.view;

import ch.iso.m120.controller.AddAddressEventHandler;
import ch.iso.m120.controller.DelAddressEventHandler;
import ch.iso.m120.controller.EditAddressEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ItemBottomBar extends HBox {

    public ItemBottomBar() {
        super();

        this.setPadding(new Insets(15, 12, 15, 12));
        this.setSpacing(10);

        this.setAlignment(Pos.CENTER);

        Button buttonAdd = new Button("Add");
        buttonAdd.setPrefSize(100, 20);
        buttonAdd.setOnAction(new AddAddressEventHandler());

        Button buttonEdit = new Button("Edit");
        buttonEdit.setPrefSize(100, 20);
        buttonEdit.setOnAction(new EditAddressEventHandler());

        Button buttonDel = new Button("Delete");
        buttonDel.setPrefSize(100, 20);
        buttonDel.setOnAction(new DelAddressEventHandler());

        this.getChildren().addAll(buttonAdd, buttonEdit, buttonDel);

    }
}
