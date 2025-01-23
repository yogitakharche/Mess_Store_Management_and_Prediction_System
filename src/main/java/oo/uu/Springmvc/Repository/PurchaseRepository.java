package oo.uu.Springmvc.Repository;

import java.util.List;
import java.util.Map;

import oo.uu.Springmvc.Model.InvoiceModel;
import oo.uu.Springmvc.Model.OrderListModel;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.PurchaseModel;

public interface PurchaseRepository {
	
	public boolean isAddProductList(PurchaseModel pModel);

	List<PurchaseModel> getAllPrductList();
	
	public boolean isDeleteProductList(int dpid);
	
	
	
	public boolean isCreateOrderList(List<PurchaseModel> orderlist1);
	
	public List<PurchaseModel> findAllPurchases();
	
	public Map<String, List<PurchaseModel>> getOrderListMap();
	
	public boolean isDeleteOrderList(int doid);
	
	
	
	
	List<InvoiceModel> getProductByListId(int productListId);	
	
	public boolean isDeletePurchaseBill(int dpbid);
	
	

	//public void insertPurchaseBill(PurchaseInvoiceModel purchaseBill);
     public boolean saveInvoiceBill(InvoiceModel invoice, List<ProductModel> products);

     public List<InvoiceModel> getAllInvoice();
     
     
     List<InvoiceModel> getPurchaseBill();
}
