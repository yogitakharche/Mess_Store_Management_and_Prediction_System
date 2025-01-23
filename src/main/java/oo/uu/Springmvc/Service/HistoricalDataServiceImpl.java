package oo.uu.Springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.HistoricalDataModel;
import oo.uu.Springmvc.Repository.HistoricalDataRepository;

@Service("histoServ")
public class HistoricalDataServiceImpl implements HistoricalDataService {

	@Autowired
	HistoricalDataRepository histoRepo;
	
	@Override
	public List<HistoricalDataModel> getDayConsumeList() {
		
		return histoRepo.getDayConsumeList();
	}

	@Override
	public List<HistoricalDataModel> getMonthConsumeList() {
		
		return histoRepo.getMonthConsumeList();
	}

	@Override
	public List<HistoricalDataModel> getYearConsumeList() {
		
		return histoRepo.getYearConsumeList();
	}

	

	
}
