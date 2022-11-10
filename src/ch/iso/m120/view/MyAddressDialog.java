package ch.iso.m120.view;

import ch.iso.m120.model.Address;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class MyAddressDialog<T> extends Dialog<Address> {

	public MyAddressDialog() {
		super();

		this.setTitle("Monster-Tool - Add");
		createDialog(new Address("", "", ""));

	}

	public MyAddressDialog(Address selectedAddress) {
		super();

		this.setTitle("Monster-Tool - Edit");
		createDialog(selectedAddress);

	}

	private void createDialog(Address address) {
		Label labelSalutation = new Label("Nummer: ");
		Label labelFirstName = new Label("Name: ");
		Label labelLastName = new Label("MonsHP: ");
		ComboBox<String> comboSalutation = new ComboBox<String>();
		comboSalutation.getItems().addAll("1", "2");
		
		//old school
		//if (address.getSalutation.equals("Herr")) comboSalutation.getSelectionModel().select(0);
		//if (address.getSalutation.equals("Frau")) comboSalutation.getSelectionModel().select(1);
		comboSalutation.getSelectionModel().select(address.getSalutation());
		
		TextField textFirstName = new TextField();
		textFirstName.setText(address.getFirstname());
		TextField textLastName = new TextField();
		textLastName.setText(address.getLastname());

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 12, 15, 12));
		GridPane.setMargin(labelSalutation, new Insets(2, 10, 2, 10));
		GridPane.setMargin(comboSalutation, new Insets(2, 10, 2, 10));
		GridPane.setMargin(labelFirstName, new Insets(2, 10, 2, 10));
		GridPane.setMargin(textFirstName, new Insets(2, 10, 2, 10));
		GridPane.setMargin(labelLastName, new Insets(2, 10, 2, 10));
		GridPane.setMargin(textLastName, new Insets(2, 10, 2, 10));

		grid.add(labelSalutation, 1, 1);
		grid.add(comboSalutation, 2, 1);
		grid.add(labelFirstName, 1, 2);
		grid.add(textFirstName, 2, 2);
		grid.add(labelLastName, 1, 3);
		grid.add(textLastName, 2, 3);

		this.getDialogPane().setContent(grid);

		ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(buttonTypeOk);

		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		this.getDialogPane().getButtonTypes().add(buttonTypeCancel);

		this.setResultConverter(new Callback<ButtonType, Address>() {

			@Override
			public Address call(ButtonType b) {
				if (b == buttonTypeOk) {
					if (textFirstName.getText().isEmpty() || textLastName.getText().isEmpty()
							|| (comboSalutation.getValue() == null)) {
						return null;
					} else {
						return new Address(comboSalutation.getValue(), textFirstName.getText(), textLastName.getText()

						);
					}

				}
				return null;
			}
		});
	}

}