package oo.uu.Springmvc.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import oo.uu.Springmvc.Model.UserModel;
import oo.uu.Springmvc.Model.VendorModel;

@Repository("vendRepo")
public class VendorRepositoryImpl implements VendorRepository {

	@Autowired
	JdbcTemplate templet;
/*=================================  ADD-VENDOR =====================================*/
/*
 * @Override public boolean isAddVendor(final VendorModel vModel) {
 * 
 * String sql = "insert into vendor values ('0',?,?,?,?)"; int value=
 * templet.update(sql,new PreparedStatementSetter() {
 * 
 * @Override public void setValues(PreparedStatement ps) throws SQLException {
 * ps.setString(1, vModel.getName()); ps.setString(2, vModel.getEmail());
 * ps.setString(3, vModel.getContact()); ps.setString(4, vModel.getShopname());
 * } }); return value>0?true:false; }
 */
	@Override
	public boolean isAddVendor(VendorModel vModel) {
	    if (vModel.getName() == null || vModel.getName().trim().isEmpty()) {
	       
	        return false;
	    }

	    String sql = "insert into vendor values ('0',?,?,?,?)";
	    int value = templet.update(sql, vModel.getName(), vModel.getEmail(), vModel.getContact(), vModel.getShopname());
	    return value > 0;
	}



/*================================= VIEW-VENDOR  ====================================*/
	@Override
	public List<VendorModel> getAllVendor() {
		List<VendorModel> vlist = templet.query("select * from vendor", new RowMapper<VendorModel>() {

			@Override
			public VendorModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				VendorModel vModel = new VendorModel();
				vModel.setId(rs.getInt(1));
				vModel.setName(rs.getString(2));
				vModel.setEmail(rs.getString(3));
				vModel.setContact(rs.getString(4));
				vModel.setShopname(rs.getString(5));
				return vModel;
				
			}
		});
		return vlist;
		
	}
/*================================= DELETE-VENDOR  ====================================*/

	@Override
	public boolean isDeleteVendor(int id) {
		int res=templet.update("delete from vendor where vendor_id="+id);
		return false;
	}

/*================================= UPDATE-VENDOR  ====================================*/
	
	@Override
	public boolean isUpdateVendor(final VendorModel vModel) {
		int value = templet.update("update vendor set vendor_name=?,vendor_email=?,vendor_contact=?,shop_name=? where vendor_id=?",new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				VendorModel uModel = new VendorModel();
				
				ps.setString(1, vModel.getName());	
				ps.setString(2, vModel.getEmail());
				ps.setString(3, vModel.getContact());
				ps.setString(4, vModel.getShopname());
				ps.setInt(5, vModel.getId());
				
			}
			
		});
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}












