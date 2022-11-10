package ch.iso.m120.model;

import javafx.beans.property.SimpleStringProperty;

public class Item {
    private SimpleStringProperty salutation = new SimpleStringProperty();
    private SimpleStringProperty firstname = new SimpleStringProperty();
    private SimpleStringProperty lastname = new SimpleStringProperty();

    public Item(String salutation, String firstname, String lastname) {
        super();
        this.setSalutation(salutation);
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }

    public final SimpleStringProperty salutationProperty() {
        return this.salutation;
    }

    public final String getSalutation() {
        return this.salutationProperty().get();
    }

    public final void setSalutation(final String salutation) {
        this.salutationProperty().set(salutation);
    }

    public final SimpleStringProperty firstnameProperty() {
        return this.firstname;
    }

    public final String getFirstname() {
        return this.firstnameProperty().get();
    }

    public final void setFirstname(final String firstname) {
        this.firstnameProperty().set(firstname);
    }

    public final SimpleStringProperty lastnameProperty() {
        return this.lastname;
    }

    public final String getLastname() {
        return this.lastnameProperty().get();
    }

    public final void setLastname(final String lastname) {
        this.lastnameProperty().set(lastname);
    }
}
