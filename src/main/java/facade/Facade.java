package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.Result;

import dao.UserDAO;
import strategy.UserCreate;
import strategy.UserDelete;
import strategy.UserRead;
import strategy.UserUpdate;
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
		Map<String, List<IStrategy>> mapUser = new HashMap<String, List<IStrategy>>();
		
		//Initialize each list that will contain all strategies to perform each operation
		List<IStrategy> strategyUserRead = new ArrayList<IStrategy>();
		List<IStrategy> strategyUserCreate = new ArrayList<IStrategy>();
		List<IStrategy> strategyUserUpdate = new ArrayList<IStrategy>();
		List<IStrategy> strategyUserDelete = new ArrayList<IStrategy>();
		
		//Initialize all strategy classes to manipulete the user
		UserRead userRead = new UserRead();
		UserCreate userCreate = new UserCreate();
		UserUpdate userUpdate = new UserUpdate();
		UserDelete userDelete = new UserDelete();
		
		//Put all classes into the users lists
		strategyUserRead.add(userRead);
		strategyUserCreate.add(userCreate);
		strategyUserUpdate.add(userUpdate);
		strategyUserDelete.add(userDelete);
		
		//Put strategyUserRead into the mapUserRead
		mapUser.put("read", strategyUserRead);
		mapUser.put("create", strategyUserCreate);
		mapUser.put("update", strategyUserUpdate);
		mapUser.put("delete", strategyUserDelete);
		
		//Put all maps operation into main map according to domain classes 
		getStrategies.put(User.class.getName(), mapUser);
		
	}
	
	public Result create(DomainEntity de) {
		// TODO Auto-generated method stub
		String className = de.getClass().getName();
		result = new Result();
		
		Map<String, List<IStrategy>> mapCreateStrategy = getStrategies.get(className);
		List<IStrategy> listCreateStrategy = mapCreateStrategy.get("create");
		
		IDAO dao = getDAO.get(className);
		
		for(IStrategy strategy:listCreateStrategy) {
			result = strategy.execute(de);
			if(result.getMessage() != null) {
				return result;
			}
		}
		
		result = dao.create(de);
		
		return result;
	}

	public Result delete(DomainEntity de) {
		// TODO Auto-generated method stub
		String className = de.getClass().getName();
		result = new Result();
		
		Map<String, List<IStrategy>> mapDeleteStrategy = getStrategies.get(className);
		List<IStrategy> listDeleteStrategy = mapDeleteStrategy.get("delete");
		
		IDAO dao = getDAO.get(className);
		
		for(IStrategy strategy:listDeleteStrategy) {
			result = strategy.execute(de);
			if(result.getMessage() != null) {
				return result;
			}
		}
		result = dao.delete(de);
		
		return result;
	}

	public Result update(DomainEntity de) {
		// TODO Auto-generated method stub
		String className = de.getClass().getName();
		result = new Result();
		
		Map<String, List<IStrategy>> mapUpdateStrategy = getStrategies.get(className);
		List<IStrategy> listUpdateStrategy = mapUpdateStrategy.get("update");
		
		IDAO dao = getDAO.get(className);
		
		for(IStrategy strategy:listUpdateStrategy) {
			result = strategy.execute(de);
			if(result.getMessage() != null) {
				return result;
			}
		}
		result = dao.update(de);
		
		return result;
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
