package ch.iso.m120.controller;

import ch.iso.m120.model.AddressOvservableList;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ExitEventHandler implements javafx.event.EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
	
		
		AddressOvservableList.saveData();
		
		Platform.exit();

	}

}

