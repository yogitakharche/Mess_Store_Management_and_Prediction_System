package oo.uu.Springmvc.Model;

public class StockModel extends ProductModel {

	ProductModel p;
	/* ================== CURRENT-STOCK ================== */
	private int currentStockId;
	private float currentStockQuantity;
	private String lastUpdateDate;

	/* ================== STOCK-UNIT ================== */
	private int unitId;
	private String unitName;

	/* ================== CONSUME-STOCK ================== */
	private int consumeStockId;
	private float consumeStockQuantity;
	private String consumeStockDate;

	public ProductModel getP() {
		return p;
	}

	

	@Override
	public String toString() {
		return "StockModel [p=" + p + ", unitId=" + unitId + ", unitName=" + unitName + ", consumeStockQuantity="
				+ consumeStockQuantity + ", consumeStockDate=" + consumeStockDate + "]";
	}



	public void setP(ProductModel p) {
		this.p = p;
	}

	public int getCurrentStockId() {
		return currentStockId;
	}

	public void setCurrentStockId(int currentStockId) {
		this.currentStockId = currentStockId;
	}

	public float getCurrentStockQuantity() {
		return currentStockQuantity;
	}

	public void setCurrentStockQuantity(float currentStockQuantity) {
		this.currentStockQuantity = currentStockQuantity;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public int getConsumeStockId() {
		return consumeStockId;
	}

	public void setConsumeStockId(int consumeStockId) {
		this.consumeStockId = consumeStockId;
	}

	public float getConsumeStockQuantity() {
		return consumeStockQuantity;
	}

	public void setConsumeStockQuantity(float consumeStockQuantity) {
		this.consumeStockQuantity = consumeStockQuantity;
	}

	public String getConsumeStockDate() {
		return consumeStockDate;
	}

	public void setConsumeStockDate(String consumeStockDate) {
		this.consumeStockDate = consumeStockDate;
	}

}
