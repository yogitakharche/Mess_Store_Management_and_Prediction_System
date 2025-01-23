package oo.uu.Springmvc.Model;

public class DataModel {
    
    private int id;
    private String pname;
    private String unit;
    private String qty;
    private String rate;
    private String consumeListId; // foreign key

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getConsumeListId() {
        return consumeListId;
    }

    public void setConsumeListId(String consumeListId) {
        this.consumeListId = consumeListId;
    }

    @Override
    public String toString() {
        return "DataModel [id=" + id + ", pname=" + pname + ", unit=" + unit + ", qty=" + qty + ", rate=" + rate + ", consumeListId=" + consumeListId + "]";
    }
}
