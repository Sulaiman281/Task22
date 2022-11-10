package ch.iso.m120.controller;

import ch.iso.m120.model.AddressOvservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DelAllAddressEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		
		AddressOvservableList.get().clear();
		
		

	}

}

