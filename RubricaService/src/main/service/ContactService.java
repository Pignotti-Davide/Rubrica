package main.service;

import java.util.List;

import main.daoImpl.ContactDaoImpl;
import main.model.Contact;

public class ContactService {

	private static ContactDaoImpl contactDao;

	public ContactService() {
		contactDao = new ContactDaoImpl();
	}

	public void persistContact(Contact entity) {
		contactDao.openCurrentSessionwithTransaction();
		contactDao.saveContact(entity);
		contactDao.closeCurrentSessionwithTransaction();
	}

	public void updateContact(Contact contact) {
		contactDao.openCurrentSessionwithTransaction();
		contactDao.updateContact(contact);
		contactDao.closeCurrentSessionwithTransaction();
	}

	public Contact findById(long id) {
		contactDao.openCurrentSession();
		Contact contact = contactDao.findById(id);
		contactDao.closeCurrentSession();
		return contact;
	}

	public void delete(long id) {
		contactDao.openCurrentSessionwithTransaction();
		contactDao.deleteContact(id);
		contactDao.closeCurrentSessionwithTransaction();
	}

	public List<Contact> findAll() {
		contactDao.openCurrentSession();
		List<Contact> contacts = contactDao.getContacts();
		contactDao.closeCurrentSession();
		return contacts;
	}

}
