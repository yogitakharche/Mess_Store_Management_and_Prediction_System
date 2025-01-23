package oo.uu.Springmvc.Model;

public class HistoricalDataModel extends ProductModel {

	public StockModel stkModel = new StockModel();
	public ProductModel prodModel = new ProductModel();

	private String consumeProductDate;
	private float consumeProductQty;
	private float productPrice;

	public StockModel getStkModel() {
		return stkModel;
	}

	public void setStkModel(StockModel stkModel) {
		this.stkModel = stkModel;
	}

	public ProductModel getProdModel() {
		return prodModel;
	}

	public void setProdModel(ProductModel prodModel) {
		this.prodModel = prodModel;
	}

	public String getConsumeProductDate() {
		return consumeProductDate;
	}

	public void setConsumeProductDate(String consumeProductDate) {
		this.consumeProductDate = consumeProductDate;
	}

	public float getConsumeProductQty() {
		return consumeProductQty;
	}

	public void setConsumeProductQty(float consumeProductQty) {
		this.consumeProductQty = consumeProductQty;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

}
