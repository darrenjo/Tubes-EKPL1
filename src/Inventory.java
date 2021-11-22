public class Inventory extends Product{
    public Inventory(String productID, String productName, String productNumber, String productType,
                     String warehouseIDFromProduct, String productIDInventory, double productPrice, int productUnit) {
        super(productID, productName, productNumber, productType, warehouseIDFromProduct, productIDInventory, productPrice, productUnit);
    }
}
