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

import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.UserModel;

@Repository("prodRepo")
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	JdbcTemplate templet;

	
/*========================= ADD-PRODUCT ===========================*/	
	@Override
	public boolean isAddProduct(final ProductModel pModel) {
		int value = templet.update("insert into product values('0',?)", new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,pModel.getProdName());	
			}
		});
		return value>0?true:false;
	}
/*========================= VIEW-PRODUCT ==========================*/
	@Override
	public List<ProductModel> getAllProducts() {
		
		List<ProductModel> prodList = templet.query("select * from product", new RowMapper<ProductModel>() {

			@Override
			public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductModel pModel = new ProductModel();
				pModel.setProdId(rs.getInt(1));
				pModel.setProdName(rs.getString(2));
				return pModel;
			}
		});
		return prodList;
	}
/*========================= DELETE-PRODUCT ===========================*/	

	@Override
	public boolean isDeleteProduct(int prodId) {
		int prodDelete = templet.update("delete from product where prod_id="+prodId);
		return false;
	}
/*========================= UPDATE-PRODUCT ===========================*/
	@Override
	public boolean isUpdateProduct(ProductModel pModel) {
		System.out.println("repository"+pModel);
		int value = templet.update("update product set prod_name=? where prod_id=?",new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ProductModel pmodel = new ProductModel();
				ps.setString(1, pmodel.getProdName());	
				ps.setInt(2, pmodel.getProdId());
			}
			
		});
		return value>0?true:false;
	}	

}














