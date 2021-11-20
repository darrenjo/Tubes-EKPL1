import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    private final ArrayList<Warehouse> warehouses;
    private final ArrayList<Product> products;

    public Manage(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        this.warehouses = warehouses;
        this.products = products;
    }

    public void addWarehouse() throws FileNotFoundException {
        Read readData = new Read(warehouses, products);
        readData.readDataWarehouse(); //Nunjukin smua data warehouse
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan ID Warehouse: ");
        String WareID = input.nextLine(); // minta input id warehouse
        int wh = 0;
        for (Warehouse warehouse : warehouses) {
            if (WareID.equalsIgnoreCase(warehouse.getWarehouseId())) {
                wh++;// jika id warehouse input sama dengan id warehouse yang sudah ada, break
            }
        }
        if (wh == 0) { // wh = true
            System.out.print("Masukan Nama Warehouse: ");
            System.out.print("Masukan Alamat Warehouse: ");
            String wareName = input.nextLine();
            String wareAdress = input.nextLine();

            warehouses.add(new Warehouse(WareID.toUpperCase(), wareName, wareAdress)); // masukan input ke ArrayList+constructor
            PrintWriter out = new PrintWriter("CS4_Warehouse.txt");
            for (Warehouse warehouse : warehouses) {
                out.println(warehouse.getWarehouseId() + ";" + warehouse.getWarehouseName() + ";" + warehouse.getWarehouseAdress() + " ");
            } // masukan input (id;nama;alamat ) ke file .txt
            out.close();
            System.out.println("\nSuccessfully added warehouse.\n");
            readData.readDataWarehouse();
        } else { // wh = false
            System.out.println("Warehouse already exist.");
        }
    }

    public void addProduct() throws FileNotFoundException {
        Read readData = new Read(warehouses, products);
        readData.readDataProduct(); //Nunjukin smua data warehouse
        Scanner inputProduct = new Scanner(System.in);
        System.out.print("Masukan ID Produk: ");
        String proID = inputProduct.nextLine(); // minta input id warehouse
        int wh = 0;
        for (Product product : products) {
            if (proID.equalsIgnoreCase(product.getProductId())) {
                wh++;// jika id product input sama dengan id warehouse yang sudah ada, break
            }
        }
        if (wh == 0) { // wh = true
            System.out.print("Nama Produk: ");
            String productName = inputProduct.nextLine();

            System.out.print("Part Number: ");
            String productSupplier = inputProduct.nextLine();

            System.out.print("Type Product: ");
            String productType = inputProduct.nextLine();

            System.out.print("Add to which warehouse: ");
            String warehouseid = inputProduct.nextLine();



            System.out.print("Unit cost: ");
            double price = inputProduct.nextDouble();

            System.out.print("Stock : ");
            int unit = inputProduct.nextInt();


            products.add(new Inventory(proID.toUpperCase(), productName, productSupplier, productType.toUpperCase(), warehouseid.toUpperCase(), proID.toUpperCase(), price, unit)); // masukan input ke ArrayList+constructor
            PrintWriter out1 = new PrintWriter("CS4_Produk.txt");
            PrintWriter out2 = new PrintWriter("CS4_Inventory.txt");
            for (Product product : products) {
                out1.println(product.getProductId() + ";" + product.getProductName() + ";" + product.getSupplier() + ";" + product.getProductType());
                out2.println(product.getWarehouseId2() + ";" + product.getProductId() + ";" + product.getPrice() + ";" + product.getUnit());
            } // masukan input (id;nama;alamat ) ke file .txt
            out1.close();
            out2.close();

            System.out.println("\nSuccessfully added product.\n");
            readData.readDataProduct();
        } else { // wh = false
            System.out.println("Product already exist.");
        }
    }

    public int getWarehouseID(String kode_wh){
        int index1=-1;

        for (int i=0; i<warehouses.size();++i){
            Warehouse warehouse = warehouses.get(i);

            if(kode_wh.equalsIgnoreCase(warehouse.getWarehouseId())){ //jika input sama dengan isi arraylist ke-i, break, index jadi i
                index1=i;
                break;
            }
        }
        return index1;
    }
    public int getWarehouseID2(String kode_wh){
        int index2=-1;

        for (int i=0; i<products.size();++i){
            Product product = products.get(i);

            if(kode_wh.equalsIgnoreCase(product.getWarehouseId2())){ //jika input sama dengan isi arraylist ke-i, break, index jadi i
                index2=i;
                break;
            }
        }
        return index2;
    }

    public int getProductIndex(String kode_pd){
        int index=-1;
        for (int i=0; i<products.size();++i){
            Product Produk = products.get(i);

            if(kode_pd.equalsIgnoreCase(Produk.getProductId2())){ //jika input sama dengan isi arraylist ke-i, break, index jadi i
                index=i;
                break;
            }
        }
        return index;
    }

    public void deleteWarehouse() throws FileNotFoundException {
        Read readData = new Read(warehouses, products);
        readData.readDataWarehouse();
        Scanner in = new Scanner(System.in);
        System.out.print("Insert Warehouse ID: ");
        String Wh_ID = in.nextLine();
        int index1 = getWarehouseID(Wh_ID);
        int index2 = getWarehouseID2(Wh_ID);

        if (index1 >= 0 && index2>=0) {
            warehouses.remove(index1);
            products.remove(index2);

            readData.readDataWarehouse();
            readData.readDataInventory();
            System.out.println("Successfully deleted warehouse.");

            PrintWriter out = new PrintWriter("CS4_Warehouse.txt");
            for (Warehouse warehouse2 : warehouses) {
                out.println(warehouse2.getWarehouseId() + ";" + warehouse2.getWarehouseName() + ";" + warehouse2.getWarehouseAdress());
            }
            out.close();
            PrintWriter out2 = new PrintWriter("CS4_Inventory.txt");
            for (Product inventory : products) {
                out2.println(inventory.getWarehouseId2() + ";" + inventory.getProductId() + ";" + inventory.getPrice() + ";" + inventory.getUnit());
            }
            out2.close();
            PrintWriter out3 = new PrintWriter("CS4_Produk.txt");
            for (Product product : products) {
                out3.println(product.getProductId() + ";" + product.getProductName() + ";" + product.getSupplier() + ";" + product.getProductType().toUpperCase());
            }
            out3.close();
        }
        else if(index1>=1){
            warehouses.remove(index1);
            readData.readDataWarehouse();
            System.out.println("Successfully deleted warehouse.");

            PrintWriter out = new PrintWriter("CS4_Warehouse.txt");
            for (Warehouse warehouse2 : warehouses) {
                out.println(warehouse2.getWarehouseId() + ";" + warehouse2.getWarehouseName() + ";" + warehouse2.getWarehouseAdress());
            }
            out.close();
        }else{
            System.out.println("Warehouse didn't exist.");
        }
    }

    public void deleteProduct() throws FileNotFoundException {
        Read readData = new Read(warehouses, products);
        readData.readDataProduct();
        Scanner in = new Scanner(System.in);
        System.out.print("Insert Product ID: ");
        String pd_id = in.next();
        int index = getProductIndex(pd_id);

        if (index >= 0) {
            products.remove(index);

            readData.readDataProduct();
            System.out.println("Successfully deleted product.");

            PrintWriter out = new PrintWriter("CS4_Produk.txt");
            for (Product Produk2 : products) {
                out.println(Produk2.getProductId() + ";" + Produk2.getProductName() + ";" + Produk2.getSupplier() + ";" + Produk2.getProductType().toUpperCase());
            }
            out.close();
            PrintWriter out2 = new PrintWriter("CS4_Inventory.txt");
            for (Product Inventory : products) {
                out2.println(Inventory.getWarehouseId2() + ";" + Inventory.getProductId2() + ";" + Inventory.getPrice() + ";" + Inventory.getUnit());
            }
            out2.close();
        }else {
            System.out.println("Product didn't exist.");
        }
    }
}
