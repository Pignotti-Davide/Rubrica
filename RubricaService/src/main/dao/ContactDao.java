package main.dao;

import java.util.List;

import main.model.Contact;

public interface ContactDao {

	abstract void saveContact();
	abstract void updateContact();
	abstract List<Contact> getContacts();
	abstract void deleteContact();
	abstract Contact findById(int parseInt);
}
