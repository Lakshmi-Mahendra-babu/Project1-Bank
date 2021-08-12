package com.bank.bankManagement;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.bank.client.Customer;
import com.bank.dao.CustomerDAOImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/customerapi")
public class CustomerMain {
	private static Logger log = Logger.getLogger(CustomerMain.class);
	
	@GET
	@Path("/all") // http://localhost:8080/bankManagement/webapi/customerapi/all
	@Produces(MediaType.APPLICATION_JSON)
	public String getPersons() {
		log.info("All Customers Deatails Generated!");
		ObjectMapper mapper = new ObjectMapper();
		CustomerDAOImp dao= new CustomerDAOImp();
		List<Customer> cList=dao.allCustomers();
		try {
			return mapper.writeValueAsString(cList);
		} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@GET
	@Path("/customerdetail/{CustomerAccountNumber}") // http://localhost:8080/bankManagement/webapi/customerapi/customerdetail
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getPerson(@PathParam("CustomerAccountNumber") int CustomerAccountNumber) {
		log.info("Customer Deatails Generated!");
		ObjectMapper mapper = new ObjectMapper();
		CustomerDAOImp dao= new CustomerDAOImp();
		List<Customer> c1=dao.getCustomer(CustomerAccountNumber);
		try {
			return mapper.writeValueAsString(c1);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
		
	@POST
	@Path("/customerid")  // http://localhost:8080/bankManagement/webapi/customerapi/customerid
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String newCustomer1(@FormParam("CustomerName") String CustomerName,@FormParam("MailId") String MailId,@FormParam("MobileNumber") long MobileNumber,@FormParam("Address") String Address,@FormParam("CurrentAmount") int CurrentAmount) {
			log.info("Customer Registration Form!");
		   int result=0;
		   Customer cust=new Customer();
	       cust.setCustomerName(CustomerName);
	       cust.setMailId(MailId);
	       cust.setMobileNumber(MobileNumber);
	       cust.setAddress(Address);
	       cust.setCurrentAmount(CurrentAmount);
	       CustomerDAOImp dao=new CustomerDAOImp();
	       dao.newCustomer(cust);
	       result=1;
	       if(result!=0) {
	    	   return "Account Successfully Created!";
	       }else {
	    	   return "Account not Created!";
	       }
	}
	}
