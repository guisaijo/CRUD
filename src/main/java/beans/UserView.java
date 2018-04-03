package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Facade.Facade;
import domain.DomainEntity;
import domain.Result;
import domain.User;
 
@ManagedBean(name="userView")
@ViewScoped
public class UserView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> users;
	private List<User> filteredUsers;
	private User selectedUser;
	
	@PostConstruct
    public void init() {
    	Facade facade = new Facade();
    	users = new ArrayList<User>();
    	DomainEntity de = new DomainEntity();
    	Result result;
    	
    	result = facade.read(de);
    	
    	for(DomainEntity aux: result.getDomainEntity()) {
    		User user = (User) aux;
    		users.add(user);
    	}
    }
     
	public List<User> getUsers() {
        return users;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}


}

