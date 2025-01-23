package oo.uu.Springmvc.Model;

public class PurchaseInvoiceModel {

	private int billId;
	private int plId;
	private int vendorId;
	private String billDate;
	private String invoiceNo;
	private int produId;
	private float pQty;
	private int unitsId;
	private float pPrice;
	private float total;
	private float gTotal;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getPlId() {
		return plId;
	}

	public void setPlId(int plId) {
		this.plId = plId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getProduId() {
		return produId;
	}

	public void setProduId(int produId) {
		this.produId = produId;
	}

	public float getpQty() {
		return pQty;
	}

	public void setpQty(float pQty) {
		this.pQty = pQty;
	}

	public int getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(int unitsId) {
		this.unitsId = unitsId;
	}

	public float getpPrice() {
		return pPrice;
	}

	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getgTotal() {
		return gTotal;
	}

	public void setgTotal(float gTotal) {
		this.gTotal = gTotal;
	}

}
