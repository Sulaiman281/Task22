package ch.iso.m120.view;

import ch.iso.m120.model.Address;
import ch.iso.m120.model.AddressOvservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyMonsterItem extends TableView<Address> {

	public MyMonsterItem() {
		// define columns
		TableColumn<Address, String> salutationCol = new TableColumn<Address, String>("Salutation");
		salutationCol.setCellValueFactory(new PropertyValueFactory<Address, String>("salutation"));
		salutationCol.setPrefWidth(98);

		TableColumn<Address, String> firstNameCol = new TableColumn<Address, String>("First Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Address, String>("firstname"));
		firstNameCol.setPrefWidth(200);

		TableColumn<Address, String> lastNameCol = new TableColumn<Address, String>("Last Name");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Address, String>("lastname"));
		lastNameCol.setPrefWidth(200);

		// add columns
		// table.getColumns().addAll(solutationCol, firstNameCol, lastNameCol);
		this.getColumns().add(salutationCol);
		this.getColumns().add(firstNameCol);
		this.getColumns().add(lastNameCol);
		
		// load data
		AddressOvservableList.loadData();

		// link data list
		this.setItems(AddressOvservableList.get());
		
		// save reference
		AddressOvservableList.setTable(this);

	}

}
