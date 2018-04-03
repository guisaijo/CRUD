package Facade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Interfaces.IFacade;
import domain.DomainEntity;
import domain.Result;
import domain.User;

public class Facade implements IFacade {

	public Result create(DomainEntity domainEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result delete(DomainEntity domainEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result update(DomainEntity domainEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result read(DomainEntity de) {
		// TODO Auto-generated method stub
		
		List<DomainEntity> users = new ArrayList<DomainEntity>();
		Result result = new Result();
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
    	
    	
    	result.setDomainEntity(users);
    	
		return result;
		
	}

}
