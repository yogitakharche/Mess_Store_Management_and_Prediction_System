package oo.uu.Springmvc.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oo.uu.Springmvc.Model.InvoiceModel;
import oo.uu.Springmvc.Model.OrderListModel;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.PurchaseModel;
import oo.uu.Springmvc.Repository.PurchaseRepository;

@Service("purchServ")
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseRepository purchRepo;
/*=====================PRODUCT-LIST ADD-VIEW==========================*/
	@Override
	public boolean isAddProductList(PurchaseModel pModel) {
		
		return purchRepo.isAddProductList(pModel);
	}

	@Override
	public List<PurchaseModel> getAllProductList() {
		List<PurchaseModel> list=purchRepo.getAllPrductList();
		return list;
	}
	
	@Override
	public boolean isDeleteProductList(int dpid) {
	
		return purchRepo.isDeleteProductList(dpid);
	}
/*=====================ORDER-LIST ADD-VIEW=============================*/

	@Override
	public boolean isCreateOrderList(List<PurchaseModel> orderlist1) {
		
		return purchRepo.isCreateOrderList(orderlist1);
	}
	
	
	
	 @Override
	    public Map<String, List<PurchaseModel>> getOrderListMap() {
	        return purchRepo.getOrderListMap();
	    }

	    @Override
	    public List<PurchaseModel> findAllPurchases() {
	        return purchRepo.findAllPurchases();
	    }
	
	    @Override
		public boolean isDeleteOrderList(int doid) {
			
			return purchRepo.isDeleteOrderList(doid);
		}
	
/*=====================PURCHASE-BILL ADD-VIEW=============================*/

	
	
	    

	

	@Override
	public boolean isDeletePurchaseBill(int dpbid) {
		
		return purchRepo.isDeletePurchaseBill(dpbid);
	}

	
	
	@Override
	public List<InvoiceModel> getProductByListId(int productListId) {
		
		return purchRepo.getProductByListId(productListId);
	}

	
	
/*=============================================================*/	
	
	
	

  @Override 
  public boolean saveInvoiceBill(InvoiceModel invoice,List<ProductModel> products) {
  
  return purchRepo.saveInvoiceBill(invoice, products); 
  }

@Override
public List<InvoiceModel> getAllInvoice() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<InvoiceModel> getPurchaseBill() {
	
	return purchRepo.getPurchaseBill();
}
 
	
	
	
	
	
	
	
}
