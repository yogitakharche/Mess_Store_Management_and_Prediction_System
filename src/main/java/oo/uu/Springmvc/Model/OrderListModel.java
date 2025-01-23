package oo.uu.Springmvc.Model;

public class OrderListModel {
		
		private int orderlistid;
		private String orderlistname;
		private int product_Id;
		private String productname;
		private float product_qty;
		private int unit_id;
		private String unitname;
		private float product_price;

		public int getProduct_Id() {
			return product_Id;
		}

		public void setProduct_Id(int product_Id) {
			this.product_Id = product_Id;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public int getOrderlistid() {
			return orderlistid;
		}

		public void setOrderlistid(int orderlistid) {
			this.orderlistid = orderlistid;
		}

		public String getOrderlistname() {
			return orderlistname;
		}

		public void setOrderlistname(String orderlistname) {
			this.orderlistname = orderlistname;
		}

		public float getProduct_qty() {
			return product_qty;
		}

		public void setProduct_qty(float product_qty) {
			this.product_qty = product_qty;
		}

		public int getUnit_id() {
			return unit_id;
		}

		public void setUnit_id(int unit_id) {
			this.unit_id = unit_id;
		}

		public float getProduct_price() {
			return product_price;
		}

		public void setProduct_price(float product_price) {
			this.product_price = product_price;
		}

		public String getUnitname() {
			return unitname;
		}

		public void setUnitname(String unitname) {
			this.unitname = unitname;
		}

	}

