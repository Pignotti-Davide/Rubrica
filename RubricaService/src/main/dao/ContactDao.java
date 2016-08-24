package main.dao;

import java.util.List;

import main.model.Contact;

public interface ContactDao {

	abstract void saveContact(Contact contact);
	abstract void updateContact(Contact contact);
	abstract List<Contact> getContacts();
	abstract void deleteContact(long id);
	abstract Contact findById(long id);
}
