package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.Result;

import dao.UserDAO;
import strategy.UserRead;
import domain.DomainEntity;
import domain.User;

import interfaces.IDAO;
import interfaces.IFacade;
import interfaces.IStrategy;

public class Facade implements IFacade {
	
	private Map<String, IDAO> getDAO;
	
	private Map<String, Map<String, List<IStrategy>>> getStrategies;
	
	Result result;
	
	public Facade() {
		
		//Initialize DAO and Strategy maps
		getDAO = new HashMap<String, IDAO>();
		getStrategies = new HashMap<String, Map<String, List<IStrategy>>>();
		
		//Initialize all DAOs from DAO package
		UserDAO userDAO = new UserDAO();
		
		//Put all initialize DAOs into getDAO map
		getDAO.put(User.class.getName(), userDAO);
		
		//Initialiaze all maps according to operation
		Map<String, List<IStrategy>> mapUserRead = new HashMap<String, List<IStrategy>>();
		
		//Initialize each list that will contain all strategies to perform each operation
		List<IStrategy> strategyUserRead = new ArrayList<IStrategy>();
		
		//Initialize all strategy classes to validate a user
		UserRead UserRead = new UserRead();
		
		//Put all classes into the read user list
		strategyUserRead.add(UserRead);
		
		//Put strategyUserRead into the mapUserRead
		mapUserRead.put("read", strategyUserRead);
		
		
		//Put all maps operation into main map according to domain classes 
		getStrategies.put(User.class.getName(),mapUserRead);
		
	}
	
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
		String className = de.getClass().getName();
		result = new Result();
		
		Map<String, List<IStrategy>> mapReadStrategy = getStrategies.get(className);
		List<IStrategy> listReadStrategy = mapReadStrategy.get("read");
		
		IDAO dao = getDAO.get(className);
		
		for(IStrategy strategy:listReadStrategy) {
			result = strategy.execute(de);
			if(result.getMessage() != null) {
				return result;
			}
		}
		result = dao.read(de);
		return result;
	}

}
