package oo.uu.Springmvc.Model;

public class ProductModel {

	private int invProductId;
    private int invUnitId;
	private int invBillId;
	private float invProductQuantity;
	private float invProductPrice;
	private float total;
	
	private int prodId;
	private String prodName;

	
	public int getInvBillId() {
		return invBillId;
	}

	public void setInvBillId(int invBillId) {
		this.invBillId = invBillId;
	}

	public int getInvProductId() {
		return invProductId;
	}

	public void setInvProductId(int invProductId) {
		this.invProductId = invProductId;
	}

	public int getInvUnitId() {
		return invUnitId;
	}

	public void setInvUnitId(int invUnitId) {
		this.invUnitId = invUnitId;
	}

	
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	

	public float getInvProductQuantity() {
		return invProductQuantity;
	}

	public void setInvProductQuantity(float invProductQuantity) {
		this.invProductQuantity = invProductQuantity;
	}

	public float getInvProductPrice() {
		return invProductPrice;
	}

	public void setInvProductPrice(float invProductPrice) {
		this.invProductPrice = invProductPrice;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ProductModel [prodId=" + prodId + "]";
	}

	
	
	 
	 
}
