package oo.uu.Springmvc.Model;

public class CrossModel {

	private PurchaseModel purchaseModel;
	private ProductModel productModel;
	private StockModel stockModel;

	@Override
	public String toString() {
		
		
		return "CrossModel [purchaseModel=" + purchaseModel + ", productModel=" + productModel + ", stockModel="
				+ stockModel + "]";
	}

	public PurchaseModel getPurchaseModel() {
		return purchaseModel;
	}

	public void setPurchaseModel(PurchaseModel purchaseModel) {
		this.purchaseModel = purchaseModel;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public StockModel getStockModel() {
		return stockModel;
	}

	public void setStockModel(StockModel stockModel) {
		this.stockModel = stockModel;
	}

}
