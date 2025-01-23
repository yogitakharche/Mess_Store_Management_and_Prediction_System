package oo.uu.Springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Repository.ProductRepository;

@Service("prodServ")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prodRepo;
	
	@Override
	public boolean isAddProduct(ProductModel pModel) {
		
		return prodRepo.isAddProduct(pModel);
	}

	@Override
	public List<ProductModel> getAllProducts() {
		
		return prodRepo.getAllProducts();
	}

	@Override
	public boolean isDeleteProduct(int prodId) {
		
		return prodRepo.isDeleteProduct(prodId);
	}

	@Override
	public boolean isUpdateProduct(ProductModel pModel) {
		
		return prodRepo.isUpdateProduct(pModel);
	}

}
