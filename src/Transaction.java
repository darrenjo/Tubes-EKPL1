import java.io.*;
import java.util.*;

public class Transaction {
    ArrayList<Warehouse>warehouses;
    ArrayList<Product>products;

    public Transaction(ArrayList<Warehouse>warehouses, ArrayList<Product>products) {
        this.warehouses = warehouses;
        this.products = products;
    }

    public int indexInventoryProductList(ArrayList<Product>products, String pID, String wID){
        int listIndexNumber = -1;
        for (int i = 0; i < products.size(); ++i){
            Product inventory = products.get(i);

            if(pID.equalsIgnoreCase(inventory.productIDInventory()) && wID.equalsIgnoreCase(inventory.warehouseIDFromProduct())){
                listIndexNumber=i;
                break;
            }
        }
        return listIndexNumber;
    }


    public void addProduct(ArrayList<Product>products) throws FileNotFoundException {
        Read readData = new Read(warehouses, products);

        Scanner in = new Scanner(System.in);
        System.out.print("Masukan ID warehouse  : ");
        String Wh_id=in.nextLine();
        System.out.print("Masukan ID product    : ");
        String pd_id = in.nextLine();

        int listIndexNumber = indexInventoryProductList(products, pd_id,Wh_id) ;
        if (listIndexNumber >= 0) {
            System.out.println( "Produk atau Warehouse tersedia\n"+
                                "Masukkan jumlah unit yang akan ditambah : ");
            int jumlah = in.nextInt();
            products.set(listIndexNumber, new Inventory(products.get(listIndexNumber).productID(), products.get(listIndexNumber).productName(), products.get(listIndexNumber).productNumber(),
                    products.get(listIndexNumber).productType(), products.get(listIndexNumber).warehouseIDFromProduct(), products.get(listIndexNumber).productIDInventory(),
                    products.get(listIndexNumber).productPrice(), products.get(listIndexNumber).productUnit()+jumlah));

            readData.readInventoryData();
            PrintWriter out = new PrintWriter("CS4_Inventory.txt");
            for (int i = 0; i < products.size(); ++i) {
                Product Inventory2 = products.get(i);
                out.println(Inventory2.warehouseIDFromProduct() + ";" + Inventory2.productIDInventory()+ ";" + Inventory2.productPrice()+";"+Inventory2.productUnit());
            }
            out.close();
        }else{
            System.out.println("Maaf Produk atau Warehouse tidak tersedia");
        }
    }

    public void deleteProduct(ArrayList<Product>products) throws FileNotFoundException {
        Read readData = new Read(warehouses, products);
        Scanner in = new Scanner(System.in);

        System.out.print("Masukan ID warehouse  : ");
        String Wh_id=in.nextLine();
        System.out.print("Masukan ID product    : ");
        String pd_id = in.nextLine();

        int index = indexInventoryProductList(products, pd_id,Wh_id) ;

        if (index >= 0) {
            System.out.println( "Produk atau Warehouse tersedia\n"+
                                "Masukkan jumlah unit yang akan dikurangi : ");
            int amountDelete = in.nextInt();
            if(amountDelete > products.get(index).productUnit()){
                System.out.println("Stok sudah habis");
            }else {
            products.set(index, new Inventory(products.get(index).productID(), products.get(index).productName(), products.get(index).productNumber(),
                    products.get(index).productType(), products.get(index).warehouseIDFromProduct(), products.get(index).productIDInventory(),
                    products.get(index).productPrice(), products.get(index).productUnit()-amountDelete));

            readData.readInventoryData();
            PrintWriter out = new PrintWriter("CS4_Inventory.txt");
            for (int i = 0; i < products.size(); ++i) {
                Product Inventory2 = products.get(i);
                out.println(Inventory2.warehouseIDFromProduct() + ";" + Inventory2.productIDInventory()+ ";" + Inventory2.productPrice()+";"+Inventory2.productUnit());
            }
            out.close();
            }
        }else{
            System.out.println("Maaf Produk atau Warehouse tidak tersedia");
        }
    }
}