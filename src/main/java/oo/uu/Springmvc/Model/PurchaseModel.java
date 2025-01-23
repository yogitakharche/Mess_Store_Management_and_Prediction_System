package oo.uu.Springmvc.Model;

public class PurchaseModel {

	/*-----------------------------------VENDOR-TABLE----------*/
	private int id;                 //yes
	private String name;

	private int productListId;       //yes
	private String productListName;
	private String productListDate;
	/*-----------------------------------ORDER-LIST------------*/
	private float productQuantity;    //yes
	private float productPrice;       //yes
 
	private int purchaseBillId;
	private String purchaseBillDate;
	private float total;                  //yes

	private float grandTotal;             //yes         
	private String invoiceNo;             //yes
	private String invoiceDate;	          //yes
/*========================================================*/
	
	

	public ProductModel pm;      //prod id
	public  StockModel sm;       // unit id
	 

	


	@Override
	public String toString() {
		return "PurchaseModel [productListId=" + productListId + ", productQuantity=" + productQuantity
				+ ", productPrice=" + productPrice + ", productmodel=" + pm.getProdId() + ", stockmodel="
				+sm.getUnitId()+ "]";
	}

	public ProductModel getProductmodel() {
		return pm;
	}

	public void setProductmodel(ProductModel productmodel) {
		this.pm = productmodel;
	}

	public ProductModel getPm() {
		return pm;
	}

	public void setPm(ProductModel pm) {
		this.pm = pm;
	}
	
	public StockModel getStockmodel() {
		return sm;
	}

	public void setStockmodel(StockModel stockmodel) {
		this.sm = stockmodel;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}		
	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public StockModel getSm() {
		return sm;
	}

	public void setSm(StockModel sm) {
		this.sm = sm;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductListId() {
		return productListId;
	}

	public void setProductListId(int productListId) {
		this.productListId = productListId;
	}

	public String getProductListName() {
		return productListName;
	}

	public void setProductListName(String productListName) {
		this.productListName = productListName;
	}

	public String getProductListDate() {
		return productListDate;
	}

	public void setProductListDate(String productListDate) {
		this.productListDate = productListDate;
	}

	public float getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(float productQuantity) {
		this.productQuantity = productQuantity;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getPurchaseBillId() {
		return purchaseBillId;
	}

	public void setPurchaseBillId(int purchaseBillId) {
		this.purchaseBillId = purchaseBillId;
	}

	public String getPurchaseBillDate() {
		return purchaseBillDate;
	}

	public void setPurchaseBillDate(String purchaseBillDate) {
		this.purchaseBillDate = purchaseBillDate;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}	
}