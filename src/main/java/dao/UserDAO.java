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
		List<DomainEntity> users = new ArrayList<DomainEntity>();
		result = new Result();
		User user = (User) de;
		connection = GetConnection.getConnectionMySQL();
		PreparedStatement pst=null;
		try {
	
			connection.setAutoCommit(false);
			
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO tb_user (user_name, user_age, user_gender) ");
			query.append("VALUES ");
			query.append("(?, ?, ?)");
			
			pst = connection.prepareStatement(query.toString());
			
			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getGender());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			user.setId(idEnd);
			
			users.add(user);
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
				connection.commit();
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				result.setMessage("Error to close database");
			}
			
		}
		
		return result;
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
			query.append("SELECT * FROM tb_user");
			
			if(user.getId() != 0) {
				
				query.append("WHERE");
				query.append("user_id");
				query.append("=");
				query.append(user.getId());
				
			}
			
			pst = connection.prepareStatement(query.toString());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				user = new User();
				
				user.setId(rs.getInt("user_id"));
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
		result = new Result();
		User user = (User) de;
		connection = GetConnection.getConnectionMySQL();
		PreparedStatement pst=null;
		
		try {
			
			connection.setAutoCommit(false);
			
			StringBuilder query = new StringBuilder();
			query.append("UPDATE tb_user SET ");
			query.append("user_name = ?, ");
			query.append("user_age = ?, ");
			query.append("user_gender = ? ");
			query.append("WHERE user_id = ?");
			
			pst = connection.prepareStatement(query.toString());
			
			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getGender());
			pst.setInt(4, user.getId());
			
			pst.executeUpdate();
			
			
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
				connection.commit();
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				result.setMessage("Error to close database");
			}
			
		}	
		
		return result;
	}

	public Result delete(DomainEntity de) {
		// TODO Auto-generated method stub
		result = super.delete(de);
		return result;
	}
}
