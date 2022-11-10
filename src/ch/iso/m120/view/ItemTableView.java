package ch.iso.m120.view;

import ch.iso.m120.model.Address;
import ch.iso.m120.model.AddressOvservableList;
import ch.iso.m120.model.Item;
import ch.iso.m120.model.ItemObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ItemTableView<T> extends TableView<Item> {
    public ItemTableView() {
        super();

        // define columns
        TableColumn<Item, String> nummerCol = new TableColumn<Item, String>("Nummer");
        nummerCol.setCellValueFactory(new PropertyValueFactory<Item, String>("salutation"));
        nummerCol.setPrefWidth(98);

        TableColumn<Item, String> firstNameCol = new TableColumn<Item, String>("Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("firstname"));
        firstNameCol.setPrefWidth(200);

        TableColumn<Item, String> monHPCol = new TableColumn<Item, String>("MonsterHP");
        monHPCol.setCellValueFactory(new PropertyValueFactory<Item, String>("mhp"));
        monHPCol.setPrefWidth(200);

        // add columns
        // table.getColumns().addAll(solutationCol, firstNameCol, lastNameCol);
        this.getColumns().add(nummerCol);
        this.getColumns().add(firstNameCol);
        this.getColumns().add(monHPCol);

        // load data
        AddressOvservableList.loadData();

        // link data list
        this.setItems(ItemObservableList.get());

        // save reference
        ItemObservableList.setTable(this);
    }
}
