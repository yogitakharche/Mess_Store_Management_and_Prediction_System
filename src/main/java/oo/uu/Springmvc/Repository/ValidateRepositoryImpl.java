package oo.uu.Springmvc.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import oo.uu.Springmvc.Model.UserModel;


@Repository("validRepo")
public class ValidateRepositoryImpl implements ValidateRepository {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public boolean isValidateUser(final UserModel vModel) {

		String sql = "select * from user where username =? and password =?";
		
		List<UserModel> list = template.query(sql, new Object[] { vModel.getUsername(), vModel.getPassword() },
				new RowMapper<UserModel>() {

					@Override
					public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserModel model = new UserModel();
						model.setUsername(rs.getString("username"));
						model.setPassword(rs.getString("password"));
						return model;
					}
				});

		return !list.isEmpty();
	}

	
}

	
