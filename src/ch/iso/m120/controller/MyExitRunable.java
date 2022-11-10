package ch.iso.m120.controller;

import javafx.application.Platform;

public class MyExitRunable implements Runnable {

	@Override
	public void run() {
		Platform.exit();

	}

}
