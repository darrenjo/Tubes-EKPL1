public class Inventory extends Produk{
    private String wareID;
    private String proID;
    private String unitCost;
    private String sisaStock;

    public Inventory(String ProID, String ProNama, String Partnumber, String Jenisproduk) {
        super(ProID, ProNama, Partnumber, Jenisproduk);
    }


    //setter and getter
    public String getWareID() {
        return wareID;
    }

    public void setWareID(String wareID) {
        this.wareID = wareID;
    }

    @Override
    public String getProID() {
        return proID;
    }

    @Override
    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getSisaStock() {
        return sisaStock;
    }

    public void setSisaStock(String sisaStock) {
        this.sisaStock = sisaStock;
    }

    @Override
    public String toString() {
        return  "Product ID       : "+wareID+"\n"+
                "Product Nama     : "+proID+"\n"+
                "Product Kategori : "+unitCost+"\n"+
                "Product Supplier : "+sisaStock;
    }
}
