package oo.uu.Springmvc.Service;

import java.util.List;

import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.HistoricalDataModel;

public interface HistoricalDataService {

	public List<HistoricalDataModel> getDayConsumeList();
	
	public List<HistoricalDataModel> getMonthConsumeList();
	
	public List<HistoricalDataModel> getYearConsumeList();
	
	
}
