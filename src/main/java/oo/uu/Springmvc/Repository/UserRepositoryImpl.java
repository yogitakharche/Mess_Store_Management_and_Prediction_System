package oo.uu.Springmvc.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import oo.uu.Springmvc.Model.UserModel;

@Repository("usrRepo")
public class UserRepositoryImpl implements UserRepository {

	
	@Autowired
	JdbcTemplate templet;
	
	@Override
	public boolean isAddUser(UserModel uModel) {
	    try {
	        String checkContactSql = "select count(*) from user where usr_contact = ?";
	        Integer contactCount = templet.queryForObject(checkContactSql, new Object[]{uModel.getContact()}, Integer.class);
	        
	        if (contactCount != null && contactCount > 0) {
	            return false;
	        }

	        String checkUsernameSql = "select count(*) from user where username = ?";
	        Integer usernameCount = templet.queryForObject(checkUsernameSql, new Object[]{uModel.getUsername()}, Integer.class);

	        if (usernameCount != null && usernameCount > 0) {
	            return false;
	        }

	        String sql = "insert into user (usr_name, usr_email, usr_contact, username, password) values (?, ?, ?, ?, ?)";
	        int value = templet.update(sql, 
	            uModel.getName(), 
	            uModel.getEmail(), 
	            uModel.getContact(), 
	            uModel.getUsername(), 
	            uModel.getPassword()
	        );

	        return value > 0; 
	    } catch (DataIntegrityViolationException e) {
	        return false;
	    } catch (Exception e) {
	        return false;
	    }
	}




	@Override
	public List<UserModel> getAllUser() {
		
		List<UserModel> ulist = templet.query("select * from user", new RowMapper<UserModel>(){

			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserModel uModel = new UserModel();
				uModel.setId(rs.getInt(1));
				uModel.setName(rs.getString(2));
				uModel.setEmail(rs.getString(3));
				uModel.setContact(rs.getString(4));
				return uModel;
			}
		});
		return ulist;
	}

	@Override
	public boolean isDeleteUser(int id) {
			int res=templet.update("delete from user where usr_id="+id);	
		return false;
	}

	
	@Override
	public boolean isUpdateUser(final UserModel umodel) {
		int value = templet.update("update user set usr_name=?,usr_email=?,usr_contact=? where usr_id=?",new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				UserModel uModel = new UserModel();
				ps.setString(1, umodel.getName());	
				ps.setString(2, umodel.getEmail());
				ps.setString(3, umodel.getContact());
				ps.setInt(4, umodel.getId());
			}
			
		});
		return value>0?true:false;
	}

	@Override
	public UserModel sessionData(UserModel umodel) {
	    String sql = "select * from user where username=? and password=?";

	    try {
	        UserModel uModel = templet.queryForObject(sql, new Object[]{umodel.getUsername(), umodel.getPassword()}, new RowMapper<UserModel>() {
	            @Override
	            public UserModel mapRow
	            (ResultSet rs, int rowNum) throws SQLException {
	                UserModel uModel = new UserModel();
	                uModel.setName(rs.getString("usr_name"));
	                uModel.setEmail(rs.getString("usr_email"));
	                uModel.setContact(rs.getString("usr_contact"));
	                uModel.setUsername(rs.getString("username"));
	                uModel.setPassword(rs.getString("password"));
	                return uModel;
	            }
	        });
	        return uModel;
	    } catch (EmptyResultDataAccessException e) {
	        return null; // Handle user not found case
	    }
	}
	/*@Override
	public List<UserModel> isDataOfUser(String user, String pass) {
	    
	    System.out.println("DATA OF REPO " + user + "\t" + pass);
	    
	  
	    String sql = "SELECT usr_name, usr_email, usr_contact FROM user WHERE username = ? AND password = ?";
	    
	    List<UserModel> ulist = templet.query(sql, new Object[]{user, pass}, new RowMapper<UserModel>() {
	        @Override
	        public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	            UserModel umodel = new UserModel();
	            
	            umodel.setName(rs.getString("usr_name"));
	            umodel.setEmail(rs.getString("usr_email"));
	            umodel.setContact(rs.getString("usr_contact"));
	            
	            return umodel;
	        }
	    });
	    return ulist;
	}*/

		

}
