package de.systemagmbh.edu.jsfajax;

import java.io.Serializable;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionListener;

@ManagedBean
@RequestScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = -4666151179402466397L;
	private String uuid;

	/**
	 * {@link ActionListener} implementation that generates a random UUID and
	 * sets the value in the bean. The returned value can be found by calling
	 * {@link #getUuid()}.
	 */
	public void generateUUID() {
		try {
			// Add this so that we have a delay for the AJAX spinner.
			Thread.sleep(1000);
			uuid = UUID.randomUUID().toString();
		} catch (InterruptedException ignore) {
		}
	}

	/**
	 * Getter for UUID.
	 *
	 * @return return {@link UUID#toString()}.
	 */
	public String getUuid() {
		return uuid;
	}
}
