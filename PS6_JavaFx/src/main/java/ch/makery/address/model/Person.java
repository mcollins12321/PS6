package ch.makery.address.model;

import java.util.Date;
import domain.PersonDomainModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person extends PersonDomainModel {

    public Person() {
        this(null, null, null, (Integer) null, null, null);
    }

    public Person(String firstName, String lastName, String street, int postalCode, String city, Object birthday ) {
        this.setPersonID(PersonID);
    	this.setFirstName(firstName);
        this.setLastName(lastName);

        // Some initial dummy data, just for convenient testing.
        this.setStreet(street);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setBirthday((Date)birthday);
    }
    public StringProperty getFirstNameProperty()
    {
    	return new SimpleStringProperty(firstName);    	
    }
    
    public StringProperty getLastNameProperty()
    {
    	return new SimpleStringProperty(lastName);    	
    }
    
    public StringProperty getStreetProperty()
    {
    	return new SimpleStringProperty(street);    	
    }
    
    public StringProperty getCityProperty()
    {
    	return new SimpleStringProperty(city);    	
    }
    
    public IntegerProperty getPostalCodeProperty()
    {
    	return new SimpleIntegerProperty(postalCode);    	
    }

}