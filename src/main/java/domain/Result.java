package domain;

import java.util.List;

public class Result {
	
	public List<DomainEntity> getDomainEntity() {
		return domainEntities;
	}
	public void setDomainEntity(List<DomainEntity> domainEntities) {
		this.domainEntities = domainEntities;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	private String message;
	private List<DomainEntity> domainEntities;
	
}
