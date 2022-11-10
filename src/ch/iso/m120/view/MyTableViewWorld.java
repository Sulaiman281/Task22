package ch.iso.m120.view;

import ch.iso.m120.model.Address;
import ch.iso.m120.model.AddressOvservableList;
import ch.iso.m120.model.AddressWorld;
import ch.iso.m120.model.WorldObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyTableViewWorld<T> extends TableView<AddressWorld> {

    public MyTableViewWorld() {
        super();

        // define columns
        TableColumn<AddressWorld, String> nummerCol = new TableColumn<AddressWorld, String>("Nummer");
        nummerCol.setCellValueFactory(new PropertyValueFactory<AddressWorld, String>("salutation"));
        nummerCol.setPrefWidth(98);

        TableColumn<AddressWorld, String> firstNameCol = new TableColumn<AddressWorld, String>("Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<AddressWorld, String>("firstname"));
        firstNameCol.setPrefWidth(200);

        TableColumn<AddressWorld, String> monHPCol = new TableColumn<AddressWorld, String>("World");
        monHPCol.setCellValueFactory(new PropertyValueFactory<AddressWorld, String>("mhp"));
        monHPCol.setPrefWidth(200);

        // add columns
        // table.getColumns().addAll(solutationCol, firstNameCol, lastNameCol);
        this.getColumns().add(nummerCol);
        this.getColumns().add(firstNameCol);
        this.getColumns().add(monHPCol);

        // load data
        AddressOvservableList.loadData();

        // link data list
        this.setItems(WorldObservableList.get());

        // save reference
        WorldObservableList.setTable(this);
    }
}
