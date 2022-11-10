package ch.iso.m120.view;

import ch.iso.m120.model.Address;
import ch.iso.m120.model.AddressOvservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyTableView<T> extends TableView<Address> {

	public MyTableView() {
		super();

		// define columns
		TableColumn<Address, String> nummerCol = new TableColumn<Address, String>("Nummer");
		nummerCol.setCellValueFactory(new PropertyValueFactory<Address, String>("salutation"));
		nummerCol.setPrefWidth(98);

		TableColumn<Address, String> firstNameCol = new TableColumn<Address, String>("Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Address, String>("firstname"));
		firstNameCol.setPrefWidth(200);

		TableColumn<Address, String> monHPCol = new TableColumn<Address, String>("MonsterHP");
		monHPCol.setCellValueFactory(new PropertyValueFactory<Address, String>("mhp"));
		monHPCol.setPrefWidth(200);

		// add columns
		// table.getColumns().addAll(solutationCol, firstNameCol, lastNameCol);
		this.getColumns().add(nummerCol);
		this.getColumns().add(firstNameCol);
		this.getColumns().add(monHPCol);
		
		// load data
		AddressOvservableList.loadData();

		// link data list
		this.setItems(AddressOvservableList.get());
		
		// save reference
		AddressOvservableList.setTable(this);
	}

}
