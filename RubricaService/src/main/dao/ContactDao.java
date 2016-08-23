package main.dao;

public interface ContactDao {

	abstract void saveContact();
	abstract void updateContact();
	abstract void getContacts();
	abstract void deleteContact();
	
}
