import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    ArrayList<Warehouse> warehouses;
    ArrayList<Product> products;

    public Transaction(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        this.warehouses = warehouses;
        this.products = products;
    }

    public int getInventoryinProduct(ArrayList<Product> products, String pID, String wID){
        int index=-1;
        for (int i=0; i<products.size();++i){
            Product inventory = products.get(i);

            if(pID.equalsIgnoreCase(inventory.getProductId2()) && wID.equalsIgnoreCase(inventory.getWarehouseId2())){
                index=i;
                break;
            }
        }
        return index;
    }


    public void addProduct(ArrayList<Product> products) throws FileNotFoundException {
        Read readData = new Read(warehouses, products);
        Scanner in = new Scanner(System.in);
        System.out.print("Insert Warehouse ID: ");
        String Wh_id=in.nextLine();
        System.out.print("Insert Product ID: ");
        String pd_id = in.nextLine();
        int index = getInventoryinProduct(products, pd_id,Wh_id) ;
        if (index >= 0) {
            System.out.println("Warehouse and product exist.");
            System.out.print("Insert the amount of unit to be add: ");
            int jumlah = in.nextInt();
            products.set(index, new Inventory(products.get(index).getProductId(), products.get(index).getProductName(), products.get(index).getSupplier(), products.get(index).getProductType(), products.get(index).getWarehouseId2(), products.get(index).getProductId2(), products.get(index).getPrice(), products.get(index).getUnit()+jumlah));

            readData.readDataInventory();
            PrintWriter out = new PrintWriter("CS4_Inventory.txt");
            for (int i = 0; i < products.size(); ++i) {
                Product Inventory2 = products.get(i);
                out.println(Inventory2.getWarehouseId2() + ";" + Inventory2.getProductId2()+ ";" + Inventory2.getPrice()+";"+Inventory2.getUnit());
            }
            out.close();
        }else{
            System.out.println("Warehouse or product didn't exist.");
        }
    }

    public void reduceProduct(ArrayList<Product> products) throws FileNotFoundException {
        Read readData = new Read(warehouses, products);
        Scanner in = new Scanner(System.in);
        System.out.print("Insert warehouse ID: ");
        String Wh_id=in.nextLine();
        System.out.print("Insert product ID: ");
        String pd_id = in.nextLine();
        int index = getInventoryinProduct(products, pd_id,Wh_id) ;
        if (index >= 0) {
            System.out.println("Warehouse and product exist.");
            System.out.print("Insert the amount of unit to be reduce: ");
            int jumlah = in.nextInt();
            if(jumlah > products.get(index).getUnit()){
                System.out.println("Insufficient stock");
            }else {
            products.set(index, new Inventory(products.get(index).getProductId(), products.get(index).getProductName(), products.get(index).getSupplier(), products.get(index).getProductType(), products.get(index).getWarehouseId2(), products.get(index).getProductId2(), products.get(index).getPrice(), products.get(index).getUnit()-jumlah));

            readData.readDataInventory();
            PrintWriter out = new PrintWriter("CS4_Inventory.txt");
            for (int i = 0; i < products.size(); ++i) {
                Product Inventory2 = products.get(i);
                out.println(Inventory2.getWarehouseId2() + ";" + Inventory2.getProductId2()+ ";" + Inventory2.getPrice()+";"+Inventory2.getUnit());
            }
            out.close();
            }
        }else{
            System.out.println("Warehouse or product didn't exist.");
        }
    }
}