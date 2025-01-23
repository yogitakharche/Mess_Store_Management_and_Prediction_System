package oo.uu.Springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oo.uu.Springmvc.Model.StockModel;
import oo.uu.Springmvc.Repository.StockRepository;

@Service("stockServ")
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepo;

	@Override
	public List<StockModel> getAllUnit() {

		return stockRepo.getAllUnit();
	}

	@Override
	public List<StockModel> getCurrentStock() {
		
		return stockRepo.getCurrentStock();
	}

	@Override
	public boolean isAddConsumeStock(List<StockModel> addconsumestockslist1) {
		
		return stockRepo.isAddConsumeStock(addconsumestockslist1);
	}

	@Override
	public List<StockModel> getAllConsumeStock() {
		
		return stockRepo.getAllConsumeStock();
	}

	@Override
	public List<StockModel> getAllStock() {
		
		return stockRepo.getAllStock();
	}

	@Override
	public List<StockModel> getProductWiseStock() {
		
		return stockRepo.getProductWiseStock();
	}

	@Override
	public List<StockModel> getRemainingStock() {
		
		return stockRepo.getRemainingStock();
	}

	@Override
	public boolean isAddUnit(StockModel stkModel) {
		
		
		return stockRepo.isAddUnit(stkModel);
	}
}
