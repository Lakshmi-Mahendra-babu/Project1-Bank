package com.bank.bankManagement;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bank.client.Customer;
import com.bank.client.CustomerTransaction;
import com.bank.dao.CustomerDAOImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/customertrans")
public class CustomerTransactionMain {
	
	@GET
	@Path("/transaction/{CustomerAccountNumber}") // http://localhost:8080/bankManagement/webapi/customertrans/transaction
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getCustomerTrans(@PathParam("CustomerAccountNumber") int CustomerAccountNumber) {
		ObjectMapper mapper = new ObjectMapper();
		CustomerDAOImp dao= new CustomerDAOImp();
		List<CustomerTransaction> ct=dao.getCustomerTransaction(CustomerAccountNumber);
		try {
			return mapper.writeValueAsString(ct);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
