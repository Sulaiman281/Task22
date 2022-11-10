package ch.iso.m120.view;

import ch.iso.m120.controller.AddAddressEventHandler;
import ch.iso.m120.controller.DelAllAddressEventHandler;
import ch.iso.m120.controller.ExitEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MyMenuBar extends MenuBar {

	public MyMenuBar() {
		super();

		Menu dataMenu = createMonsterMenu();

		this.getMenus().addAll(dataMenu);
	}

	private Menu createMonsterMenu() {

		Menu menu = new Menu("_Monster");
		menu.setMnemonicParsing(true);

		MenuItem addMenuItem = new MenuItem("_Add...");
		addMenuItem.setMnemonicParsing(true);
		addMenuItem.setOnAction(new AddAddressEventHandler());

		MenuItem delMenuItem = new MenuItem("_Delete all");
		delMenuItem.setMnemonicParsing(true);
		delMenuItem.setOnAction(new DelAllAddressEventHandler());
		
		SeparatorMenuItem sep = new SeparatorMenuItem();

		MenuItem exitMenuItem = new MenuItem("_Close");
		exitMenuItem.setMnemonicParsing(true);
		exitMenuItem.setOnAction(new ExitEventHandler());

		
		menu.getItems().addAll(addMenuItem, delMenuItem, sep, exitMenuItem);

		return menu;
	}

}
