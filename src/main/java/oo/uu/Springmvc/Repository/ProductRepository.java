package oo.uu.Springmvc.Repository;

import java.util.List;

import oo.uu.Springmvc.Model.ProductModel;

public interface ProductRepository {
	
	public boolean isAddProduct(ProductModel pModel);
	
	public List<ProductModel> getAllProducts();
	
	public boolean isDeleteProduct(int prodId);
	
	public boolean isUpdateProduct(ProductModel pModel);


}
