package de.systemagmbh.edu.customer;

import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerRegistationAction {

	@Inject
	private CustomerData customer;

	@Inject
//	private CustomerService customerService;

	public void register(ActionEvent event) {
		try {
			// calls EJB and do registration here
		} catch (EJBException e) {
			FacesContext.getCurrentInstance().addMessage(
					event.getComponent().getClientId(),
					new FacesMessage(e.getMessage()));
			throw new AbortProcessingException(e.getMessage());
		}
		this.customer.clear();
	}

	public CustomerData getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerData customer) {
		this.customer = customer;
	}
}