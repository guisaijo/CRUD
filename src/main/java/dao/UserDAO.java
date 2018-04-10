package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Result;
import connection.GetConnection;
import domain.DomainEntity;
import domain.User;

public class UserDAO extends AbstractDAO {
	
	public UserDAO() {		
		// TODO Auto-generated constructor stub
		super("tb_user", "user_id");
	}

	Result result;
	
	public Result create(DomainEntity de) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result read(DomainEntity de) {
		// TODO Auto-generated method stub
		result = new Result();
		User user = (User) de;
		connection = GetConnection.getConnectionMySQL();
		List<DomainEntity> users = new ArrayList<DomainEntity>();
		PreparedStatement pst=null;
		
		try {
			
			connection.setAutoCommit(false);
			
			StringBuilder query = new StringBuilder();
			query.append("Select * FROM tb_user");
			
			if(user.getId() != null) {
				
				query.append("WHERE");
				query.append("user_id");
				query.append("=");
				query.append(user.getName());
				
			}
			
			pst = connection.prepareStatement(query.toString());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				user = new User();
				
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setAge(rs.getInt("user_age"));
				user.setGender(rs.getString("user_gender"));
				
				users.add(user);
				
			}
			
			result.setDomainEntity(users);
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			result.setMessage("Error into SQL");
			
		} finally {
			
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				result.setMessage("Error to close database");
			}
			
		}	
		
		return result;
	
	}

	public Result update(DomainEntity de) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result delete(DomainEntity de) {
		// TODO Auto-generated method stub
		return null;
	}
}
