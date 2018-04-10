package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import application.Result;
import domain.DomainEntity;
import domain.User;
import facade.Facade;
 
@ManagedBean(name="userView")
@ViewScoped
public class UserView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> users;
	private List<User> filteredUsers;
	private User user;
	
	@PostConstruct
    public void init() {
    	Facade facade = new Facade();
    	users = new ArrayList<User>();
    	user = new User();
    	Result result;
    	
    	result = facade.read(user);
    	
    	for(DomainEntity aux: result.getDomainEntity()) {
    		user = (User) aux;
    		users.add(user);
    	}
    }
     
	public List<User> getUsers() {
        return users;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public void createUser() {
		System.out.println(user.getName());
	}
}

