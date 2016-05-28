package de.systemagmbh.edu.customer;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Model
public class CustomerData implements Serializable {

	private static final long serialVersionUID = 3477529118903523024L;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void clear() {
		setName("");
	}
}