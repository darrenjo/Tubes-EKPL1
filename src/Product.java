abstract public class Product{
    private final String productName;
    private final String productId;
    private final String productId2;
    private final String productType;
    private final String productSupplier;
    private final double price;
    private final String warehouseId2;// kenapa warehouse id 2?
    private final int unit;


    public Product(String productId, String productName, String productSupplier, String productType, String warehouseId2, String productId2, double price, int unit) {
        this.productName = productName;
        this.productId = productId;
        this.productId2 = productId2;
        this.productType = productType;
        this.productSupplier = productSupplier;
        this.price = price;
        this.warehouseId2 = warehouseId2;
        this.unit = unit;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductId2() {
        return productId2;
    }

    public String getProductType() {
        return productType;
    }

    public String getSupplier() {
        return productSupplier;
    }

    public double getPrice() {
        return price;
    }

    public String getWarehouseId2() {
        return warehouseId2;
    }

    public int getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productSupplier='" + productSupplier + '\'' +
                ", productType='" + productType + '\'' +
                ", warehouseId2='" + warehouseId2 + '\'' +
                ", productId2='" + productId2 + '\'' +
                ", price=" + price +
                ", unit=" + unit +
                '}';
    }
}
