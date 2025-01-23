package oo.uu.Springmvc.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.PreparedStatementSetter;

import oo.uu.Springmvc.Model.PurchaseModel;
import oo.uu.Springmvc.Model.StockModel;

@Repository("stockRepo")
public class StockRepositoryImpl implements StockRepository {

	@Autowired
	JdbcTemplate templet;

	@Override
	public boolean isAddUnit( final StockModel stkModel) {

		    String insertSql = "insert into stk_unit (unit_name) values (?)";
		  int value=  templet.update(insertSql, stkModel.getUnitName());
		    return value>0?true:false; 
		}
	 
	

/*======================  PRODUCT QUANTITY UNIT IS HERE  ========================*/
	@Override
	public List<StockModel> getAllUnit() {
		List<StockModel> unitList = templet.query("select * from stk_unit", new RowMapper<StockModel>() {

			@Override
			public StockModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				StockModel stkModel = new StockModel();
				stkModel.setUnitId(rs.getInt(1));
				stkModel.setUnitName(rs.getString(2));
				return stkModel;
			}
		});
		return unitList;
	}
/*======================== VIEW ALL CURRENT STOCK ===================================*/	
	@Override
	public List<StockModel> getCurrentStock() {
		List<StockModel> curStkList = templet.query(
				"select p.prod_name,cs.curstk_qty,u.unit_name,cs.last_updated from current_stock cs inner join product p on cs.prod_id=p.prod_id inner join stk_unit u\r\n"
						+ "on cs.unit_id=u.unit_id",
				new RowMapper<StockModel>() {

					@Override
					public StockModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						StockModel stkModel = new StockModel();
						stkModel.setProdName(rs.getString(1));
						stkModel.setCurrentStockQuantity(rs.getFloat(2));
						stkModel.setUnitName(rs.getString(3));
						stkModel.setLastUpdateDate(rs.getString(4));
						return stkModel;
					}
				});
		return curStkList;
	}

/*============ ADD CONSUME STOCK ============ AS WELL AS SUBSTRACT IN CURRUNT STOCK ===========*/

	@Override
	public boolean isAddConsumeStock(List<StockModel> addconsumestockslist1) {
		String consumesql = "insert into consume_stock (prod_id, consumed_qty, unit_id, consumed_date) values (?, ?, ?, ?)";
		String checkProductSql = "select count(*) from product where prod_id = ?";
		String checkCurrentStockSql = "select curstk_qty from current_stock where prod_id = ?";
		String updateCurrentStockSql = "update current_stock set curstk_qty = curstk_qty - ? where prod_id = ?";

		int totalInserted = 0;

		for (StockModel conModel : addconsumestockslist1) {
			System.out.println("before list in for --> " + addconsumestockslist1);

			boolean productExists = templet.queryForObject(checkProductSql,new Object[] { conModel.getP().getProdId() }, Integer.class) > 0;

			if (productExists) {
				Integer currentQty = templet.queryForObject(checkCurrentStockSql,new Object[] { conModel.getP().getProdId() }, Integer.class);

				if (currentQty != null) {
					if (currentQty == 0) {
						System.out.println("you have no product quantity, please buy the product.");
					} else if (currentQty >= conModel.getConsumeStockQuantity()) {
						totalInserted += templet.update(consumesql, conModel.getP().getProdId(),
								conModel.getConsumeStockQuantity(), conModel.getUnitId(),
								conModel.getConsumeStockDate());
						templet.update(updateCurrentStockSql, conModel.getConsumeStockQuantity(),
								conModel.getP().getProdId());
						System.out.println("after in for loop --> " + conModel.getP().getProdId() + "\t"
								+ conModel.getConsumeStockQuantity() + "\t" + conModel.getUnitId() + "\t"
								+ conModel.getConsumeStockDate());
					} else {
						System.out.println(
								"product not present in current stock or insufficient quantity for product ID: "
										+ conModel.getP().getProdId());
					}
				} else {
					System.out.println("product not found in current stock for ID: " + conModel.getP().getProdId());
				}
			} else {
				System.out.println("product not present in product table for ID: " + conModel.getP().getProdId());
			}
		}

		return totalInserted == addconsumestockslist1.size();
	}

/*================================ VIEW ALL CONSUME STOCK  ================================*/
	@Override
	public List<StockModel> getAllConsumeStock() {
		List<StockModel> consList = templet.query(
				"select cs.cs_id,p.prod_name,cs.consumed_qty,u.unit_name,cs.consumed_date from consume_stock cs inner join product p on cs.prod_id=p.prod_id inner join stk_unit u on cs.unit_id=u.unit_id",
				new RowMapper<StockModel>() {

					@Override
					public StockModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						StockModel sModel = new StockModel();
						sModel.setConsumeStockId(rs.getInt("cs.cs_id"));
						sModel.setProdName(rs.getString("p.prod_name"));
						sModel.setConsumeStockQuantity(rs.getFloat("cs.consumed_qty"));
						sModel.setUnitName(rs.getString("u.unit_name"));
						sModel.setConsumeStockDate(rs.getString("cs.consumed_date"));
						return sModel;
					}
				});
		return consList;
	}
/*================================ VIEW ALL STOCK  ======================================*/
	@Override
	public List<StockModel> getAllStock() {
		List<StockModel> allstock = templet.query(
				"select p.prod_id, p.prod_name, pi.qty, u.unit_name, pr.bill_date from purchase_items pi inner join product p on pi.prod_id = p.prod_id inner join stk_unit u on pi.unit_id = u.unit_id inner join purchase_invoice pr on pi.bill_id = pr.bill_id",
				new RowMapper<StockModel>() {

					@Override
					public StockModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						StockModel sModel = new StockModel();

						sModel.setProdId(rs.getInt("p.prod_id"));
						sModel.setProdName(rs.getString("p.prod_name"));
						sModel.setConsumeStockQuantity(rs.getFloat("pi.qty"));
						sModel.setUnitName(rs.getString("u.unit_name"));
						sModel.setLastUpdateDate(rs.getString("pr.bill_date"));
						return sModel;
					}
				});
		return allstock;
	}

/*==============================  VIEW PRODUCT WISE STOCK ================================*/

	@Override
	public List<StockModel> getProductWiseStock() {
		List<StockModel> prodwisestock = templet.query(
				"select p.prod_id,p.prod_name, sum(pi.qty) as total_quantity, u.unit_name " + "from purchase_items pi "
						+ "join product p on pi.prod_id = p.prod_id " + "join stk_unit u on pi.unit_id = u.unit_id "
						+ "group by p.prod_name, u.unit_name",
				new RowMapper<StockModel>() {

					@Override
					public StockModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						StockModel sModel = new StockModel();

						sModel.setProdId(rs.getInt("p.prod_id"));
						sModel.setProdName(rs.getString("prod_name"));
						sModel.setCurrentStockQuantity(rs.getFloat("total_quantity"));
						sModel.setUnitName(rs.getString("unit_name"));
						return sModel;
					}
				});
		return prodwisestock;
	}
/*=============================== VIEW REMAINING STOCK ====================================*/
	@Override
	public List<StockModel> getRemainingStock() {
	    List<StockModel> remaingstock = templet.query("select p.prod_name, c.curstk_qty, u.unit_name from current_stock c inner join product p on c.prod_id = p.prod_id inner join stk_unit u on c.unit_id = u.unit_id", new RowMapper<StockModel>() {
	        @Override
	        public StockModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	            StockModel sModel = new StockModel();
	            sModel.setProdName(rs.getString("prod_name"));
	            sModel.setCurrentStockQuantity(rs.getFloat("curstk_qty"));
	            sModel.setUnitName(rs.getString("unit_name"));
	            return sModel;
	        }
	    });
	    return remaingstock;
	}
	
	
}