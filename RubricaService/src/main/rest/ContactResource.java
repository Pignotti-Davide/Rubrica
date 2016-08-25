package main.rest;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.model.Contact;
import main.service.ContactService;

@Path("/")
public class ContactResource {
	ContactService contactService = new ContactService();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Contact> findAll() {
		return contactService.findAll();
	}

	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Contact findById(@PathParam("id") String id) {
		return contactService.findById(Long.parseLong(id));
	}

	@POST @Path("/addContact")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addContact(Contact contact) {  
		contactService.persistContact(contact);
	}  

	@PUT  
	@Produces(MediaType.APPLICATION_JSON)  
	public void updateCountry(Contact contact){  
		contactService.updateContact(contact);
	}  

	@DELETE  
	@Path("/{id}")  
	@Produces(MediaType.APPLICATION_JSON)  
	public void deleteCountry(@PathParam("id") long id){  
		contactService.delete(id);  
	}  
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}

}
