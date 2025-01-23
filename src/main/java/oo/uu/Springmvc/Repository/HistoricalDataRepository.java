package oo.uu.Springmvc.Repository;

import java.util.List;

import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.HistoricalDataModel;

public interface HistoricalDataRepository {

    public List<HistoricalDataModel> getDayConsumeList();
	
	public List<HistoricalDataModel> getMonthConsumeList();
	
	public List<HistoricalDataModel> getYearConsumeList();
}
