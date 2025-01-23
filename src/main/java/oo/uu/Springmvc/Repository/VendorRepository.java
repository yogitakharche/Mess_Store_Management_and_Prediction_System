package oo.uu.Springmvc.Repository;

import java.util.List;

import oo.uu.Springmvc.Model.VendorModel;

public interface VendorRepository {
	
	public boolean isAddVendor(VendorModel vModel);

	List<VendorModel> getAllVendor();
	
	public boolean isDeleteVendor(int id);
	
	public boolean isUpdateVendor(VendorModel vModel);

}
