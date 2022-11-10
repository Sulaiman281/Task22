package ch.iso.m120.model;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class AddressOvservableList {

	private final static ObservableList<Address> data = FXCollections.observableArrayList();

	private static TableView<Address> table = null;

	private static String connectionString = "jdbc:mysql://localhost/addressDB?useSSL=false";
	// new DB version
	// private static String connectionString =
	// "jdbc:mysql://localhost/addressDB?useSSL=false&allowPublicKeyRetreival=true";
	private static String connectionUser = "root";
	private static String connectionPassword = "";

	public static void loadData() {
		try {

			// Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(connectionString, connectionUser, connectionPassword);

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"select salShort, addPrename, addName from salutation, address " + "where monskey = addmonsId;");

			while (rs.next()) {
				String salShort = rs.getString("salShort");
				String addName = rs.getString("addName");
				String addHP = rs.getString("addHP");

				data.add(new Address(salShort, addName, addHP));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		try{
			Connection conn = DriverManager.getConnection(connectionString, connectionUser, connectionPassword);
			return conn;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}

	public static void saveData() {
		try {

			// Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(connectionString, connectionUser, connectionPassword);
			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			stmt.executeUpdate("delete from address;");

			for (Address address : data) {
				int salId = 1;
				if (address.getSalutation().equals("1"))
					salId = 1;
				if (address.getSalutation().equals("2"))
					salId = 2;

				// insert into address (addSalId, addName, addPrename) values (1, 'Born',
				// 'Roman');
				stmt.executeUpdate("insert into address(addsalId, addName, addPrename) " + "values (" + salId + ", "
						+ "'" + address.getLastname() + "', " + "'" + address.getFirstname() + "');");
			}

			stmt.close();

			conn.commit();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ObservableList<Address> get() {
		return data;
	}

	public static TableView<Address> getTable() {
		return table;
	}

	public static void setTable(TableView<Address> table) {
		AddressOvservableList.table = table;
	}

}
