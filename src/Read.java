import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    private final ArrayList<Warehouse> warehouses;
    private final ArrayList<Product> products;

    public Read(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        this.warehouses = warehouses;
        this.products = products;
    }

    public void readDataWarehouse() {
        System.out.println("+==============================================+");
        System.out.println("|                WAREHOUSE LIST                |");
        System.out.println("+==============================================+");
        System.out.println(" ");
        for (int i = 0; i <= warehouses.size() - 1; i++) { //menampilkan dari index 0 sampai index size-1
            Warehouse warehouse = warehouses.get(i);
            System.out.println("Warehouse ID       : " + warehouse.getWarehouseId());
            System.out.println("Warehouse Name     : " + warehouse.getWarehouseName());
            System.out.println("Warehouse Address  : " + warehouse.getWarehouseAdress());
            System.out.println(" ");
        }
    }

    public void readDataInventory() {
        System.out.println("+==============================================+");
        System.out.println("|                INVENTORY LIST                |");
        System.out.println("+==============================================+");
        System.out.println(" ");
        for (int i = 0; i <= products.size() - 1; i++) { //menampilkan dari index 0 sampai index size-1
            Product product = products.get(i);
            System.out.println("Product ID    : " + product.getProductId());
            System.out.println("Warehouse ID  : " + product.getWarehouseId2());
            System.out.println("Unit Cost     : Rp" + product.getPrice());
            System.out.println("Stock         : " + product.getUnit() + " unit");
            System.out.println(" ");
        }
    }

    public void readDataProduct() {
        System.out.println("+==============================================+");
        System.out.println("|                 PRODUCT LIST                 |");
        System.out.println("+==============================================+");
        System.out.println(" ");
        for (int i = 0; i <= products.size() - 1; i++) { //menampilkan dari index 0 sampai index size-1
            Product product = products.get(i);
            System.out.println("Product ID         : " + product.getProductId());
            System.out.println("Warehouse ID       : " + product.getWarehouseId2());
            System.out.println("Product Name       : " + product.getProductName());
            System.out.println("Part Number        : " + product.getSupplier());
            System.out.println("Product Type       : " + product.getProductType());
            System.out.println("Unit Cost          : Rp" + product.getPrice());
            System.out.println("Stock              : " + product.getUnit() + " unit");
            System.out.println("");
        }
    }

    public void readSpecifiedWarehouse() {
        Scanner input = new Scanner(System.in);
        System.out.print("Specific Warehouse ID: ");
        String IDwarehouse = input.next();
        System.out.println(" ");
        int cekID = 0;
        System.out.println("+==============================================+");
        System.out.println("|                WAREHOUSE LIST                |");
        System.out.println("+==============================================+");
        System.out.println(" ");
        for (Product product : products) {
            String WarehouseID = product.getWarehouseId2();
            if (IDwarehouse.equalsIgnoreCase(WarehouseID)) {
                System.out.println("Warehouse ID       : " + WarehouseID);
                System.out.println("Product ID         : " + product.getProductId());
                System.out.println("Product Name       : " + product.getProductName());
                System.out.println("Part Number        : " + product.getSupplier());
                System.out.println("Product Type       : " + product.getProductType());
                System.out.println("Unit Price         : " + product.getPrice());
                System.out.println("Stock              : " + product.getUnit() + " unit");
                System.out.println(" ");
                cekID++;
            }
        }
        if (cekID == 0) {
            for (Warehouse warehouse : warehouses) {
                String WarehouseID2 = warehouse.getWarehouseId();
                if (IDwarehouse.equalsIgnoreCase(WarehouseID2)) {
                    System.out.println("Warehouse empty.");
                    cekID++;
                }
            }
        }
        if (cekID == 0) {
            System.out.println("Warehouse didn't exist.");
        }
    }

    public void readSpecifiedProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Specific Product ID: ");
        String IDproduct = input.next();
        System.out.println(" ");
        int cekID = 0;
        System.out.println("+==============================================+");
        System.out.println("|                 PRODUCT LIST                 |");
        System.out.println("+==============================================+");
        System.out.println(" ");
        for (Product product : products) {
            String ProductID = product.getProductId2();
            if (IDproduct.equalsIgnoreCase(ProductID)) {
                System.out.println("Product ID        : " + ProductID.toUpperCase());
                System.out.println("Product Name      : " + product.getProductName());
                System.out.println("Part Number       : " + product.getSupplier());
                System.out.println("Product Type      : " + product.getProductType());
                System.out.println("Unit Cost         : Rp" + product.getPrice());
                System.out.println("Stock             : " + product.getUnit() + " unit");
                System.out.println("Warehouse ID      : " + product.getWarehouseId2());
                System.out.println(" ");
                cekID++;
            }
        }
        if (cekID == 0) {
            System.out.println("Product didn't exist.");
        }
    }
}