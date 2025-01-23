package oo.uu.Springmvc.Model;

import java.util.List;

public class InvoiceModel {

	private int invProductListId;
	private String invProductListName;

	private int invVendorId;
	private String invVendorName;

	private String invDate;
	private String invoiceNo;

	private int invProductId;
	private String invProductName;
	private float invProductQuantity;
	private float invProductPrice;
	private float total;

	private List<ProductModel> plist;

	private int invUnitId;
	private String invUnitName;

	private float invGrandTotal;

	public ProductModel prdModel;

	public ProductModel getPrdModel() {
		return prdModel;
	}

	public void setPrdModel(ProductModel prdModel) {
		this.prdModel = prdModel;
	}

	public int getInvProductListId() {
		return invProductListId;
	}

	public void setInvProductListId(int invProductListId) {
		this.invProductListId = invProductListId;
	}

	public String getInvProductListName() {
		return invProductListName;
	}

	public void setInvProductListName(String invProductListName) {
		this.invProductListName = invProductListName;
	}

	public int getInvVendorId() {
		return invVendorId;
	}

	public void setInvVendorId(int invVendorId) {
		this.invVendorId = invVendorId;
	}

	public String getInvVendorName() {
		return invVendorName;
	}

	public void setInvVendorName(String invVendorName) {
		this.invVendorName = invVendorName;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getInvProductId() {
		return invProductId;
	}

	public void setInvProductId(int invProductId) {
		this.invProductId = invProductId;
	}

	public String getInvProductName() {
		return invProductName;
	}

	public void setInvProductName(String invProductName) {
		this.invProductName = invProductName;
	}

	public float getInvProductQuantity() {
		return invProductQuantity;
	}

	public void setInvProductQuantity(float invProductQuantity) {
		this.invProductQuantity = invProductQuantity;
	}

	public int getInvUnitId() {
		return invUnitId;
	}

	public void setInvUnitId(int invUnitId) {
		this.invUnitId = invUnitId;
	}

	public String getInvUnitName() {
		return invUnitName;
	}

	public void setInvUnitName(String invUnitName) {
		this.invUnitName = invUnitName;
	}

	public float getInvProductPrice() {
		return invProductPrice;
	}

	public void setInvProductPrice(float invProductPrice) {
		this.invProductPrice = invProductPrice;
	}

	public float getInvGrandTotal() {
		return invGrandTotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void setInvGrandTotal(float invGrandTotal) {
		this.invGrandTotal = invGrandTotal;
	}

	public List<ProductModel> getPlist() {
		return plist;
	}

	public void setPlist(List<ProductModel> plist) {
		this.plist = plist;
	}

	@Override
	public String toString() {
		return "InvoiceModel [invProductListId=" + invProductListId + ", invProductListName=" + invProductListName
				+ ", invVendorId=" + invVendorId + ", invVendorName=" + invVendorName + ", invDate=" + invDate
				+ ", invoiceNo=" + invoiceNo + ", invProductId=" + invProductId + ", invProductName=" + invProductName
				+ ", invProductQuantity=" + invProductQuantity + ", invProductPrice=" + invProductPrice + ", total="
				+ total + ", plist=" + plist + ", invUnitId=" + invUnitId + ", invUnitName=" + invUnitName
				+ ", invGrandTotal=" + invGrandTotal + ", prdModel=" + prdModel + "]";
	}

	public void setProductList(List<InvoiceModel> productList) {

	}

}
