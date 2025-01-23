package oo.uu.Springmvc.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import oo.uu.Springmvc.Model.InvoiceModel;
import oo.uu.Springmvc.Model.OrderListModel;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.PurchaseModel;
import oo.uu.Springmvc.Model.StockModel;

@Repository("purchRepo")
public class PurchaseRepositoryImpl implements PurchaseRepository {

	@Autowired
	JdbcTemplate templet;

	@Override
	public boolean isAddProductList(final PurchaseModel pModel) {

		int value = templet.update("insert into product_list values('0',?,?,?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, pModel.getProductListName());
				ps.setInt(2, pModel.getId());
				ps.setString(3, pModel.getProductListDate());
			}
		});
		return value>0? true : false;
	}
	
	@Override
	public List<PurchaseModel> getAllPrductList() {
		
		List<PurchaseModel> plList = templet.query("select pl.pl_id,pl.pl_name,v.vendor_name,pl.pl_date from product_list pl inner join vendor v on pl.vendor_id=v.vendor_id",new RowMapper<PurchaseModel>(){

			@Override
			public PurchaseModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchaseModel purModel = new PurchaseModel();
				purModel.setProductListId(rs.getInt(1));
				purModel.setProductListName(rs.getString(2));
				purModel.setName(rs.getString(3));
				purModel.setProductListDate(rs.getString(4));
				return purModel;
			}
		});
		return plList;
	}
/*========================-- ADD ORDER LIST USING JSON --================================*/
	
	@Override
	public boolean isCreateOrderList(List<PurchaseModel> orderlist1) {
		String str ="insert into order_list values(?,?,?,?)";
		int value=0;
		for(PurchaseModel prModel:orderlist1) {
			 value+= templet.update(str,prModel.getProductListId(),prModel.pm.getProdId(),prModel.getProductQuantity(),prModel.sm.getUnitId());
		       
		}
		return value>0;
	}

/*===============================-- FETCH ORDERLIST --=====================================*/

		 @Override
	    public Map<String, List<PurchaseModel>> getOrderListMap() {     //here change
	        Map<String, List<PurchaseModel>> orderListMap = new HashMap<String, List<PurchaseModel>>();

	        String sql = "select pl.pl_name, o.prod_id,p.prod_name, o.qty, o.unit_id,u.unit_name from product_list pl join order_list o on pl.pl_id = o.pl_id inner join product p on o.prod_id=p.prod_id inner join stk_unit u on o.unit_id=u.unit_id";

	        List<PurchaseModel> purchases = templet.query(sql, new RowMapper<PurchaseModel>() {
	            @Override
	            public PurchaseModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	                PurchaseModel purchase = new PurchaseModel();
	                purchase.setProductListName(rs.getString("pl_name"));
	                purchase.setProductQuantity(rs.getFloat("qty"));     
	                
	                
	                ProductModel product = new ProductModel();
	                product.setProdId(rs.getInt("o.prod_id"));
	                product.setProdName(rs.getString("p.prod_name"));
	                purchase.setPm(product);
	                
	                StockModel stock = new StockModel();
	                stock.setUnitId(rs.getInt("o.unit_id"));
	                stock.setUnitName(rs.getString("u.unit_name"));
	                purchase.setSm(stock);
	                
	                return purchase;
	            }
	        });
	        for (PurchaseModel purchase : purchases) {
	            if (!orderListMap.containsKey(purchase.getProductListName())) {
	                orderListMap.put(purchase.getProductListName(), new ArrayList<PurchaseModel>());
	            }
	            orderListMap.get(purchase.getProductListName()).add(purchase);
	        }
	        return orderListMap;
	    }
/*===============================================================================================================*/
	    @Override
	    public List<PurchaseModel> findAllPurchases() {
	        String sql = "select p.pl_id, p.prod_id, p.qty, p.unit_id from order_list p";

	        return templet.query(sql, new RowMapper<PurchaseModel>() {
	            @Override
	            public PurchaseModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	                PurchaseModel purchase = new PurchaseModel();
	                purchase.setProductListId(rs.getInt("pl_id"));
	                purchase.setProductQuantity(rs.getFloat("qty"));
	                purchase.setProductPrice(rs.getFloat("price"));
	                
	                ProductModel product = new ProductModel();
	                product.setProdId(rs.getInt("prod_id"));
	                purchase.setPm(product);
	                
	                StockModel stock = new StockModel();
	                stock.setUnitId(rs.getInt("unit_id"));
	                purchase.setSm(stock);

	                return purchase;
	            }
	        });
	    }



/*==============================-- INVOICE OPRATION IS HERE --========================================================*/
	    
	    
	    @Override
		public List<InvoiceModel> getProductByListId(int productListId) {
	    	List<InvoiceModel> prodByList = templet.query("select p.prod_id,p.prod_name, ol.qty,u.unit_id,u.unit_name,v.vendor_id, v.vendor_name from order_list ol inner join product p on ol.prod_id=p.prod_id inner join stk_unit u on ol.unit_id=u.unit_id inner join product_list pl on pl.pl_id=ol.pl_id inner join vendor v on v.vendor_id=pl.vendor_id where pl.pl_id=?",new RowMapper<InvoiceModel>(){

				@Override
				public InvoiceModel mapRow(ResultSet rs, int rowNum) throws SQLException {
					InvoiceModel iveModel= new InvoiceModel();
					
					iveModel.setInvProductId(rs.getInt("p.prod_id"));
					iveModel.setInvProductName(rs.getString("p.prod_name"));
					iveModel.setInvProductQuantity(rs.getFloat("ol.qty"));
					iveModel.setInvUnitId(rs.getInt("u.unit_id"));
					iveModel.setInvUnitName(rs.getNString("u.unit_name"));
					iveModel.setInvVendorId(rs.getInt("v.vendor_id"));
					iveModel.setInvVendorName(rs.getString("v.vendor_name"));
					
					return iveModel;
				}
			},productListId);
	    	
			return prodByList;
		}
/*=====================-- ALL PURCHASE SECTION DELETE OPRATION --========================*/
	@Override
	public boolean isDeleteProductList(int dpid) {
		int delproduct=templet.update("delete from product_list where pl_id="+dpid);
		return false;
	}

	@Override
	public boolean isDeleteOrderList(int doid) {
		int delorder=templet.update("delete from order_list where pl_id="+doid);
		return false;
	}

	@Override
	public boolean isDeletePurchaseBill(int dpbid) {
		int delpurchase=templet.update("delete from purchase_bill where pbill_id="+dpbid);
		return false;
	}

	
/*==========  PURCHASE INVOICE ADD IS HERE =============  AS WELL AS INSERT IN CURRENT STOCK ==============*/
	
  @Override 
  public boolean saveInvoiceBill(final InvoiceModel invoice,List<ProductModel> products) {
	  String insertInvoiceSql = "insert into purchase_invoice values('0',?,?,?,?,?)";
	  System.out.println(invoice);
	  int value1=templet.update(insertInvoiceSql, new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			
			ps.setInt(1, invoice.getInvProductListId());
			ps.setInt(2, invoice.getInvVendorId());
			ps.setString(3, invoice.getInvDate());
			ps.setString(4, invoice.getInvoiceNo());
			ps.setFloat(5, invoice.getInvGrandTotal());
		}  
	  });
	      try {
	     
	    	  int bill_id=templet.queryForObject("select max(bill_id) from purchase_invoice",Integer.class);
	    	  String insertProductSql = "insert into purchase_items values('0',?,?,?,?,?,?)";
	     
		      for(ProductModel prodModel:products) {
		         int value2= templet.update(insertProductSql,bill_id,prodModel.getInvProductId(),prodModel.getInvProductQuantity(),prodModel.getInvUnitId(),prodModel.getInvProductPrice(),prodModel.getTotal());  
		}		
/*----------------------------------------------------------------------------------------------------------------------------*/		
		for (ProductModel prodModel : products) {
		      
		    String checkProductSql = "select count(*) from current_stock where prod_id = ?";
		    int count = templet.queryForObject(checkProductSql, new Object[]{prodModel.getInvProductId()}, Integer.class);
		   
		    if (count > 0) {
		        String updateStockSql = "update current_stock set curstk_qty = curstk_qty + ? where prod_id = ?";
		        templet.update(updateStockSql, prodModel.getInvProductQuantity(), prodModel.getInvProductId());
		    } else {
		        String insertStockSql = "insert into current_stock (prod_id, curstk_qty, unit_id) values (?, ?, ?)";
		        templet.update(insertStockSql, prodModel.getInvProductId(), prodModel.getInvProductQuantity(), prodModel.getInvUnitId());
		    }
		}
/*---------------------------------------------------------------------------------------------------------------------------*/
	      }catch(Exception ex) {
	    	  System.out.println(ex);
	      }     
  return true; 
  }

/*================================================================================*/
     @Override
public List<InvoiceModel> getAllInvoice() {
	
	return null;
}
/*=================================================================================*/
     @Override
     public List<InvoiceModel> getPurchaseBill() {
         List<InvoiceModel> invoList = templet.query(
             "select v.vendor_name, p.bill_date, p.invoice_no, p.g_total from purchase_invoice p inner join vendor v on p.vendor_id=v.vendor_id", 
             new RowMapper<InvoiceModel>() {
                 @Override
                 public InvoiceModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                     InvoiceModel invModel = new InvoiceModel();
                     invModel.setInvVendorName(rs.getString("vendor_name"));
                     invModel.setInvDate(rs.getString("bill_date"));
                     invModel.setInvoiceNo(rs.getString("invoice_no"));
                     invModel.setInvGrandTotal(rs.getFloat("g_total"));
               
                     int billId=templet.queryForObject("select bill_id from purchase_items",Integer.class);    
                         billId = rs.getInt("bill_id");
                     List<InvoiceModel> productList = templet.query(
                         "select pl.pl_name,p.prod_name, pi.qty, u.unit_name, pi.p_price, pi.total from purchase_items pi inner join product p on pi.prod_id = p.prod_id inner join stk_unit u on pi.unit_id =\r\n"
                         + "u.unit_id inner join purchase_invoice inv on pi.bill_id = inv.bill_id inner join product_list pl on inv.pl_id = pl.pl_id where pi.bill_id ="+billId, 
                         new Object[]{billId},
                         new RowMapper<InvoiceModel>() {
                             @Override
                             public InvoiceModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                                 InvoiceModel invsModel = new InvoiceModel();
                                 invsModel.setInvProductName(rs.getString("prod_name"));
                                 invsModel.setInvProductQuantity(rs.getFloat("qty"));
                                 invsModel.setInvUnitName(rs.getString("unit_name"));
                                 invsModel.setInvProductPrice(rs.getFloat("p_price"));
                                 invsModel.setTotal(rs.getFloat("total"));
                                 return invsModel;
                             }
                         }
                     );

                     invModel.setProductList(productList);
                     return invModel;
                 }
             }
         );
         return invoList;
     }

}
