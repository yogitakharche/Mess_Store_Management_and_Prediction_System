package oo.uu.Springmvc.Service;

import java.util.List;


import oo.uu.Springmvc.Model.ProductModel;

public interface ProductService {
	
	public boolean isAddProduct(ProductModel pModel);
	
	public List<ProductModel> getAllProducts();
	
	public boolean isDeleteProduct(int prodId);
	
	public boolean isUpdateProduct(ProductModel pModel);
	
	

}
