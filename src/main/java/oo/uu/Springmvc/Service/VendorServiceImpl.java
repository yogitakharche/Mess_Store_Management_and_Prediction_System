package oo.uu.Springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oo.uu.Springmvc.Model.VendorModel;
import oo.uu.Springmvc.Repository.VendorRepository;

@Service("vendServ")
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorRepository vendRepo;
	
	@Override
	public boolean isAddVendor(VendorModel vModel) {
		
		return vendRepo.isAddVendor(vModel);
	}

	@Override
	public List<VendorModel> getAllVendor() {
		
		return vendRepo.getAllVendor();
		
	}

	@Override
	public boolean isDeleteVendor(int id) {
		
		return vendRepo.isDeleteVendor(id);
	}

	@Override
	public boolean isUpdateVendor(VendorModel vModel) {
		
		return vendRepo.isUpdateVendor(vModel);
	}

}



