package main.daoImpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import main.dao.ContactDao;
import main.model.Contact;

public class ContactDaoImpl implements ContactDao{
	private Session currentSession;
	private Transaction currentTransaction;

	public  ContactDaoImpl() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	public void closeCurrentSession() {
		currentSession.close();
	}		      
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}		
	private static SessionFactory getSessionFactory() {		
		Configuration configuration = new Configuration().configure();		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	private Session getCurrentSession() {
		return currentSession;
	}
	private void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
	private Transaction getCurrentTransaction() {
		return currentTransaction;
	}
	private void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}



	@Override
	public void saveContact(Contact contact) {
		getCurrentSession().save(contact);

	}

	@Override
	public void updateContact(Contact contact) {
		  getCurrentSession().update(contact);
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = (List<Contact>) getCurrentSession().createQuery("from Contact").list();
		        return contacts;
	}

	@Override
	public void deleteContact(long id) {
		Contact contact=findById(id);
		getCurrentSession().delete(contact);
	}

	public Contact findById(long id) {
		Contact contact = (Contact) getCurrentSession().get(Contact.class, id);
		return contact;
	}
}
