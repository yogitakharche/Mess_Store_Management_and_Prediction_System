package oo.uu.Springmvc.Repository;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.HistoricalDataModel;

@Repository("histoRepo")
public class HistoricalDataRepositoryImpl implements HistoricalDataRepository {

	@Autowired
	JdbcTemplate templet;
	
/*============================= VIEW DATE CONSUME STOCK ===============================*/
	@Override
	public List<HistoricalDataModel> getDayConsumeList() {
		List<HistoricalDataModel> dateConsList = templet.query("select p.prod_name, c.consumed_qty, u.unit_name, c.consumed_date from consume_stock c inner join product p on c.prod_id=p.prod_id inner join stk_unit u on c.unit_id=u.unit_id", new RowMapper<HistoricalDataModel>(){

			@Override
			public HistoricalDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				HistoricalDataModel histModel = new HistoricalDataModel();
				
				 histModel.getProdModel().setProdName(rs.getString("prod_name"));
                 histModel.setConsumeProductQty(rs.getFloat("consumed_qty"));
                 histModel.getStkModel().setUnitName(rs.getString("unit_name"));
                 histModel.setConsumeProductDate(rs.getString("consumed_date"));
				
				return histModel;
			}
		});
		return dateConsList;
	}
/*============================= VIEW MONTH CONSUME STOCK ===============================*/
	@Override
	public List<HistoricalDataModel> getMonthConsumeList() {
		/*   if you want to month format [07-2024] then uncomment now this format is [july 2024] 
		 * List<HistoricalDataModel> monthConsList = templet.
		 * query("select p.prod_name, sum(c.consumed_qty) as consumed_qty,u.unit_name, date_format(c.consumed_date, '%m-%Y') as consumed_date from consume_stock c inner join product p on c.prod_id = p.prod_id inner join stk_unit u on c.unit_id = u.unit_id group by p.prod_name,unit_name, consumed_date"
		 * , new RowMapper<HistoricalDataModel>(){
		 */			List<HistoricalDataModel> monthConsList = templet.query(" select p.prod_name, sum(c.consumed_qty) as consumed_qty, u.unit_name, lower(date_format(c.consumed_date, '%m-%Y')) as consumed_date from consume_stock c inner join product p on c.prod_id = p.prod_id inner join stk_unit u on c.unit_id = u.unit_id group by p.prod_name, u.unit_name, consumed_date", new RowMapper<HistoricalDataModel>(){

			@Override
			public HistoricalDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				HistoricalDataModel histModel = new HistoricalDataModel();
				
				histModel.getProdModel().setProdName(rs.getString("prod_name"));
                histModel.setConsumeProductQty(rs.getFloat("consumed_qty"));
                histModel.getStkModel().setUnitName(rs.getString("unit_name"));
                histModel.setConsumeProductDate(rs.getString("consumed_date"));
				
				return histModel;
			}
		});
		return monthConsList;
	}
/*============================= VIEW YEAR CONSUME STOCK ===============================*/
	@Override
	public List<HistoricalDataModel> getYearConsumeList() {
		List<HistoricalDataModel> yearConsList = templet.query("select p.prod_name, sum(c.consumed_qty) as consumed_qty, u.unit_name, year(c.consumed_date) as consumed_year from consume_stock c inner join product p on c.prod_id = p.prod_id inner join stk_unit u on c.unit_id = u.unit_id group by p.prod_name, u.unit_name, consumed_year", new RowMapper<HistoricalDataModel>(){

			@Override
			public HistoricalDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				HistoricalDataModel histModel = new HistoricalDataModel();
				
				histModel.getProdModel().setProdName(rs.getString("prod_name"));
                histModel.setConsumeProductQty(rs.getFloat("consumed_qty"));
                histModel.getStkModel().setUnitName(rs.getString("unit_name"));
                histModel.setConsumeProductDate(rs.getString("consumed_year"));
				
				return histModel;
			}
		});
		return yearConsList;
	}


	
}
