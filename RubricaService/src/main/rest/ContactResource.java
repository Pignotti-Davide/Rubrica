package main.rest;



import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.daoImpl.ContactDaoImpl;
import main.model.Contact;

@Path("/contacts")
public class ContactResource {


	ContactDaoImpl daoImpl = new ContactDaoImpl();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Contact> findAll() {
		return daoImpl.getContacts();
	}

	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Contact findById(@PathParam("id") String id) {
		return daoImpl.findById(Integer.parseInt(id));
	}
}
