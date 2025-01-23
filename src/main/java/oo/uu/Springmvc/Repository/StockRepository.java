package oo.uu.Springmvc.Repository;

import java.util.List;
import oo.uu.Springmvc.Model.StockModel;

public interface StockRepository {
	List<StockModel> getAllUnit();

	List<StockModel> getCurrentStock();
	
	public boolean isAddConsumeStock(List<StockModel> addconsumestockslist1);
	
	public boolean isAddUnit(StockModel stkModel);
	
	List<StockModel> getAllConsumeStock();

	List<StockModel> getAllStock();
	
	List<StockModel> getProductWiseStock();
	
	List<StockModel> getRemainingStock();
}
