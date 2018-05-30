package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import application.Result;
import domain.DomainEntity;
import domain.User;
import facade.Facade;
 
@ManagedBean(name="userView")
@RequestScoped
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
		initAttributes();
		Facade facade = new Facade();
    	Result result;
    	result = facade.read(user);
    	for(DomainEntity aux: result.getDomainEntity()) {
    		user = (User) aux;
    		users.add(user);
    	}
    	user = new User();
    	return;
    }
	
	public void userCreate() {
		Result result;
		Facade facade = new Facade();
		result = facade.create(user);
		users.add((User) result.getDomainEntity().get(0));
		user = new User();
		return;
	}
	
	public void userUpdate() {
		Facade facade = new Facade();
		facade.update(user);
		for(User aux: users){
			if(aux.getId() == user.getId()) {
				aux.setName(user.getName());
				aux.setAge(user.getAge());
				aux.setGender(user.getGender());
			}
		}
		return;
	}
	
	public void userDelete() {
		Facade facade = new Facade();
		facade.delete(user);
		ListIterator<User> aux = users.listIterator();
		while(aux.hasNext()) {
			if(aux.next().getId() == user.getId()) aux.remove();
		}
		return;
	}
	
	public void initAttributes() {
		user = new User();
		users = new ArrayList<User>();
	}
	
	public List<User> getUsers() {
        return users;
	}
	
	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

