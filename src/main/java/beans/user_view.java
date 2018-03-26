package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import domain.User;
 
@ManagedBean(name="user_view")
@ViewScoped
public class user_view implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> users;
	private List<User> filtered_users;
	private User selected_user;
 
	@PostConstruct
    public void init() {
    	
		users = new ArrayList<User>();
    	
    	User user = new User();
    	
    	user.setId(UUID.randomUUID().toString().substring(0, 8));
    	user.setName("Guilherme");
    	user.setAge(23);
    	user.setGender("Male");
    	
    	users.add(user);
    	
    	user = new User();
    	
    	user.setId(UUID.randomUUID().toString().substring(0, 8));
    	user.setName("Juliana");
    	user.setAge(14);
    	user.setGender("Female");
    	
    	users.add(user);
    	
    	user = new User();
    	
    	user.setId(UUID.randomUUID().toString().substring(0, 8));
    	user.setName("Tayla");
    	user.setAge(18);
    	user.setGender("Female");
    	
    	users.add(user);
    	
    	user = new User();
    	
    	user.setId(UUID.randomUUID().toString().substring(0, 8));
    	user.setName("Isabel");
    	user.setAge(47);
    	user.setGender("Female");
    	
    	users.add(user);
    	
    	user = new User();
    	
    	user.setId(UUID.randomUUID().toString().substring(0, 8));
    	user.setName("Milton");
    	user.setAge(53);
    	user.setGender("Male");
    	
    	users.add(user);
    	
    	user = new User();
    	
    	user.setId(UUID.randomUUID().toString().substring(0, 8));
    	user.setName("Fernando");
    	user.setAge(29);
    	user.setGender("Male");
    	
    	users.add(user);
    	
    }
     
    public List<User> getUsers() {
        return users;
    }

	public List<User> getFiltered_users() {
		return filtered_users;
	}

	public void setFiltered_users(List<User> filtered_users) {
		this.filtered_users = filtered_users;
	}

	public User getSelected_user() {
		return selected_user;
	}

	public void setSelected_user(User selected_user) {
		this.selected_user = selected_user;
	}
    
    
}

