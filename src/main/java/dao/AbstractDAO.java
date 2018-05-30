package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.Result;
import connection.GetConnection;
import domain.DomainEntity;
import interfaces.IDAO;

public abstract class AbstractDAO implements IDAO{
	
	protected Connection connection;
	protected String table;
	protected String idTable;
	
	public AbstractDAO(String table, String idTable){
		this.table = table;
		this.idTable = idTable;
	}
	public Result delete(DomainEntity de){
		Result result = new Result();
		connection = GetConnection.getConnectionMySQL();
		PreparedStatement pst=null;
		
		
		try {
			
			connection.setAutoCommit(false);
			
			StringBuilder query = new StringBuilder();
			
			query.append("DELETE FROM ");
			query.append(table);
			query.append(" WHERE ");
			query.append(idTable);
			query.append("=");
			query.append(de.getId());
			
			pst = connection.prepareStatement(query.toString());
			
			pst.executeUpdate();
			
		}
		catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				
			}
			e.printStackTrace();
			result.setMessage("Error into SQL");
		}finally{
			try {
				connection.commit();
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				result.setMessage("Error to close the database");
			}
		}
		return result;
	}
}
