import java.io.*;
//import java.io.FileNotFoundException;
import java.util.*;
//import java.util.Scanner;

public class Test {
    private final ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<Warehouse> warehouses = new ArrayList<>();

    public void readInputFile() throws FileNotFoundException {

        File inputFile = new File("CS4_Warehouse.txt");
        Scanner scannerInputWarehouse = new Scanner(inputFile);

        while (scannerInputWarehouse.hasNextLine()) { //Selama ada baris selanjutnya, dia TRUE
            String[] wh = scannerInputWarehouse.nextLine().split(";"); //pemisah ";" gk tau penting apa ngga
            warehouses.add(new Warehouse(wh[0],wh[1],wh[2])); //add ke dalam arraylist + constructor
        }
        scannerInputWarehouse.close();

        File inputProduct = new File("CS4_Produk.txt");
        Scanner scannerInputProduct = new Scanner(inputProduct);

        File inputInventory = new File("CS4_Inventory.txt");
        Scanner scannerInputInventory = new Scanner(inputInventory);

        while (scannerInputProduct.hasNextLine()) {
            String[] pd = scannerInputProduct.nextLine().split(";"); //gk tau penting apa ngga
            String[] iv = scannerInputInventory.nextLine().split(";"); //gk tau penting apa ngga
            double a = Double.parseDouble(iv[2]);
            int b = Integer.parseInt(iv[3]);
            products.add(new Inventory(pd[0], pd[1], pd[2], pd[3], iv[0], iv[1], a, b)); //add ke dalam arraylist + constructor
        }
        scannerInputProduct.close();
        scannerInputInventory.close();
    }

    public void tampilanMainMenu() throws FileNotFoundException {
        readInputFile();
        Menu menu = new Menu(warehouses, products);
        System.out.println(" ");
        System.out.println("+=============================================+");
        System.out.println("|                 MINI MARKET                 |");
        System.out.println("|                  MAIN MENU                  |");
        System.out.println("+=============================================+");
        System.out.println("1. Read Data");
        System.out.println("2. Manage");
        System.out.println("3. Transaction");
        System.out.println("0. Exit");
        System.out.print("Input menu: ");
        Scanner input = new Scanner(System.in);
        String inMenu = input.next();
        System.out.println(" ");

        //cari tau fungsi equalsIgnoreCase
        if (inMenu.equalsIgnoreCase("1")){
            menu.tampilanMenu();
        }
        else if (inMenu.equalsIgnoreCase("2")){
            menu.tampilanMenuManage();
        }
        else if (inMenu.equalsIgnoreCase("3")){
            menu.tampilanMenuTransaksi();
        }
        else if (inMenu.equalsIgnoreCase("0")){
            System.out.println("Process End!");
        }
        else{
            System.out.println("Wrong input! *try 0,1,...");
            tampilanMainMenu();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Test x = new Test();
        x.tampilanMainMenu();
    }
}
