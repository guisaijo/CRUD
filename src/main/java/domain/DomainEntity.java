package domain;

import java.io.Serializable;

public class DomainEntity implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	private String id;
}
