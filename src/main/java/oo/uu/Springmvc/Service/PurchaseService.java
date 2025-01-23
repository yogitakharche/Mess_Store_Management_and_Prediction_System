package oo.uu.Springmvc.Service;

import java.util.List;
import java.util.Map;

import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.InvoiceModel;
import oo.uu.Springmvc.Model.OrderListModel;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.PurchaseModel;

public interface PurchaseService {
/*=========================================================================*/	
	public boolean isAddProductList(PurchaseModel pModel);
	
	List<PurchaseModel> getAllProductList();
	
	public boolean isDeleteProductList(int dpid);
	
/*============================-- ORDER-LIST --=============================*/
	
	public boolean isCreateOrderList(List<PurchaseModel> orderlist1);
	
	
	public List<PurchaseModel> findAllPurchases();
	public Map<String, List<PurchaseModel>> getOrderListMap();
	
	public boolean isDeleteOrderList(int doid);
	
/*=========================================================================*/
	
	//public boolean saveInvoice();
	public boolean saveInvoiceBill(InvoiceModel invoice, List<ProductModel> products);
    

	
	List<InvoiceModel> getProductByListId(int productListId);	
	
	public boolean isDeletePurchaseBill(int dpbid);

	
	public List<InvoiceModel> getAllInvoice();

     List<InvoiceModel> getPurchaseBill();
	
	
	
	}
