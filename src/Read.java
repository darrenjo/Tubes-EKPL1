import java.io.FileNotFoundException;
import java.util.*;

public class Read {
    private final ArrayList<Warehouse>warehouses;
    private final ArrayList<Product>products;

    public Read(ArrayList<Warehouse>warehouses, ArrayList<Product>products) {
        this.warehouses = warehouses;
        this.products = products;
    }

    public void readInventoryData() {
        System.out.println("    ~~~~           DAFTAR INVENTORY         ~~~~\n");
        for (int i = 0; i <= products.size() - 1; i++) {
            Product pro = products.get(i);
            System.out.println("ID Produk          : " + pro.productID()+"\n"+
                                "ID Warehouse       : " + pro.warehouseIDFromProduct()+"\n"+
                                "Harga              : Rp" + pro.productPrice()+"\n"+
                                "Persediaan         : " + pro.productUnit() + " pcs\n");
        }
    }

    public void readWarehouseList() {
        int cekID = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("ID Warehouse : ");
        String IDwarehouse = input.next();

        System.out.println("    ~~~~           DAFTAR WAREHOUSE          ~~~\n");
        for (Product pro : products) {
            String WarehouseID = pro.warehouseIDFromProduct();
            if (IDwarehouse.equalsIgnoreCase(WarehouseID)) {
                System.out.println( "Warehouse ID      : " + WarehouseID+"\n"+
                                    "Product ID         : " + pro.productID()+"\n"+
                                    "Product Name       : " + pro.productName()+"\n"+
                                    "Nomor Produk       : " + pro.productNumber()+"\n"+
                                    "Jenis Produk       : " + pro.productType()+"\n"+
                                    "Harga              : " + pro.productPrice()+"\n"+
                                    "Persediaan         : " + pro.productUnit() + " pcs\n");
                cekID++;
            }
        }
        if (cekID == 0) {
            for (Warehouse warehouse : warehouses) {
                String WarehouseID2 = warehouse.getWarehouseId();
                if (IDwarehouse.equalsIgnoreCase(WarehouseID2)) {
                    System.out.println("Warehouse kosong");
                    cekID++;
                }
            }
        }
        if (cekID == 0) {
            System.out.println("Maaf produk tidak tersedia");
        }
    }

    public void readWarehouseData() {
        System.out.println("    ~~~~           DAFTAR WAREHOUSE          ~~~\n");
        for (int i = 0; i <= warehouses.size() - 1; i++) {
            Warehouse ware = warehouses.get(i);
            System.out.println( "ID Warehouse       : " + ware.getWarehouseId()+"\n"+
                                "Nama Warehouse     : " + ware.getWarehouseName()+"\n"+
                                "Alamat Warehouse   : " + ware.getWarehouseAddress()+"\n");
        }
    }

    public void readProductList() {
        int cekID = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("ID Produk : ");
        String IDproduct = input.next();
        System.out.println("    ~~~~             DAFTAR PRODUk          ~~~~\n");
        for (Product pro : products) {
            String ProID = pro.productIDInventory();
            if (IDproduct.equalsIgnoreCase(ProID)) {
                System.out.println( "ID Produk         : " + ProID.toUpperCase()+"\n"+
                                    "Nama Produk       : " + pro.productName()+"\n"+
                                    "Nomor Produk      : " + pro.productNumber()+"\n"+
                                    "Jenis Produk      : " + pro.productType()+"\n"+
                                    "Harga             : Rp " + pro.productPrice()+"\n"+
                                    "Persediaan        : " + pro.productUnit() + " pcs\n"+
                                    "ID Warehouse      : " + pro.warehouseIDFromProduct()+"\n");
                cekID++;
            }
        }
        if (cekID == 0) {
            System.out.println("Maaf produk tidak tersedia");
        }
    }

    public void readDataProduct() {
        System.out.println("    ~~~~             DAFTAR PRODUK           ~~~~\n");
        for (int i = 0; i <= products.size() - 1; i++) {
            Product pro = products.get(i);
            System.out.println( "ID Produk          : " + pro.productID()+"\n"+
                                "ID Warehouse       : " + pro.warehouseIDFromProduct()+"\n"+
                                "Nama Produk        : " + pro.productName()+"\n"+
                                "Nomor Produk       : " + pro.productNumber()+"\n"+
                                "Jenis Produk       : " + pro.productType()+"\n"+
                                "Harga              : Rp " + pro.productPrice()+"\n"+
                                "Persediaan         : " + pro.productUnit() + " pcs\n");
        }
    }

    public void readMinProduct() throws FileNotFoundException {
        System.out.println("    ~~~~             DAFTAR PRODUK           ~~~~\n");
        Collections.sort(products, Product.pQtyDesc);
        for (Product pro : products) {
            System.out.println( "ID Produk          : " + pro.productID()+"\n"+
                    "ID Warehouse       : " + pro.warehouseIDFromProduct()+"\n"+
                    "Nama Produk        : " + pro.productName()+"\n"+
                    "Nomor Produk       : " + pro.productNumber()+"\n"+
                    "Jenis Produk       : " + pro.productType()+"\n"+
                    "Harga              : Rp " + pro.productPrice()+"\n"+
                    "Persediaan         : " + pro.productUnit() + " pcs\n");
        }
    }

    public void readMaxProduct() throws FileNotFoundException {
        System.out.println("    ~~~~             DAFTAR PRODUK           ~~~~\n");
        Collections.sort(products, Product.pQtyAsc);
        for (Product pro : products) {
            System.out.println( "ID Produk          : " + pro.productID()+"\n"+
                    "ID Warehouse       : " + pro.warehouseIDFromProduct()+"\n"+
                    "Nama Produk        : " + pro.productName()+"\n"+
                    "Nomor Produk       : " + pro.productNumber()+"\n"+
                    "Jenis Produk       : " + pro.productType()+"\n"+
                    "Harga              : Rp " + pro.productPrice()+"\n"+
                    "Persediaan         : " + pro.productUnit() + " pcs\n");
        }
    }

}