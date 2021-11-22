import java.util.Comparator;

abstract public class Product {
    private final String productID;
    private final String productName;
    private final String productNumber;
    private final String productType;
    private final String warehouseIDFromProduct;
    private final String productIDInventory;
    private final double productPrice;
    private final int productUnit;


    public Product(String productID, String productName, String productNumber,String productType, String warehouseIDFromProduct, String productIDInventory, double productPrice, int productUnit) {
        this.productID = productID;
        this.productName = productName;
        this.productNumber = productNumber;
        this.productType = productType;
        this.warehouseIDFromProduct = warehouseIDFromProduct;

        this.productPrice = productPrice;
        this.productUnit = productUnit;
        this.productIDInventory = productIDInventory;
    }

    public String productID() {
        return productID;
    }

    public String productIDInventory() {
        return productIDInventory;
    }

    public String warehouseIDFromProduct() {
        return warehouseIDFromProduct;
    }

    public String productType() {
        return productType;
    }

    public String productName() {
        return productName;
    }

    public String productNumber() {
        return productNumber;
    }

    public double productPrice() {
        return productPrice;
    }

    public int productUnit() {
        return productUnit;
    }

    public static Comparator<Product> pQtyDesc = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int pQty1 = o1.productUnit();
            int pQty2 = o2.productUnit();

            return pQty1-pQty2;
        }
    };

    public static Comparator<Product> pQtyAsc = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int pQty1 = o1.productUnit();
            int pQty2 = o2.productUnit();

            return pQty2 - pQty1;
        }
    };
}