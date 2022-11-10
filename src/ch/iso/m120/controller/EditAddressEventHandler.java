package ch.iso.m120.controller;

import java.util.Optional;

import ch.iso.m120.model.Address;
import ch.iso.m120.model.AddressOvservableList;
import ch.iso.m120.view.MyAddressDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

public class EditAddressEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		
		int selectedIndex = AddressOvservableList.getTable().getSelectionModel().getSelectedIndex();
		if(selectedIndex > -1) {
			
			Address selectedAddress = AddressOvservableList.get().get(selectedIndex);
			
			Dialog<Address> dialog = new MyAddressDialog<Address>(selectedAddress);
			
			Optional<Address> result = dialog.showAndWait();
			if (result.isPresent()) {
				AddressOvservableList.get().set(selectedIndex, result.get());
			}
		}
		
		

	}

}
