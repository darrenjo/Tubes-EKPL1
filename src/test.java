import java.io.*;
import java.util.*;

public class Test {
    private final ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<Warehouse> warehouses = new ArrayList<>();

    public void readInputFile() throws FileNotFoundException {

        File inputFile = new File("D:\\ITHB\\Semester 3\\Elemen Konstruksi Perangkat Lunak 1\\Tugas Besar\\Project\\src\\CS4_Warehouse.txt");
        Scanner scannerInputWarehouse = new Scanner(inputFile);

        while (scannerInputWarehouse.hasNextLine()) {
            String[] ware = scannerInputWarehouse.nextLine().split(";"); //pemisah pada kata
            warehouses.add(new Warehouse(ware[0],ware[1],ware[2]));
        }
        scannerInputWarehouse.close();

        File inputProduct = new File("D:\\ITHB\\Semester 3\\Elemen Konstruksi Perangkat Lunak 1\\Tugas Besar\\Project\\src\\CS4_Produk.txt");
        Scanner scannerInputProduct = new Scanner(inputProduct);

        File inputInventory = new File("D:\\ITHB\\Semester 3\\Elemen Konstruksi Perangkat Lunak 1\\Tugas Besar\\Project\\src\\CS4_Inventory.txt");
        Scanner scannerInputInventory = new Scanner(inputInventory);

        while (scannerInputProduct.hasNextLine()) {
            String[] pro = scannerInputProduct.nextLine().split(";"); //pemisah pada kata
            String[] invt = scannerInputInventory.nextLine().split(";"); //pemisah pada kata

            double a = Double.parseDouble(invt[2]);
            int b = Integer.parseInt(invt[3]);
            products.add(new Inventory(pro[0], pro[1], pro[2], pro[3], invt[0], invt[1], a, b));
        }
        scannerInputProduct.close();
        scannerInputInventory.close();
    }

    public void tampilanMainMenu() throws FileNotFoundException {
        readInputFile();
        Menu menu = new Menu(warehouses, products);
        System.out.println("\n    ~~~~          AHAVA'S FASHION STORE             ~~~~\n" +
                            "    ~~~~                MENU UTAMA                  ~~~~\n" +
                            "1. Lihat Data\n" +
                            "2. Atur\n" +
                            "3. Transaksi\n" +
                            "0. Keluar\n" +
                            "Pilihan anda [1/2/3/0]: ");
        Scanner input = new Scanner(System.in);
        String inMenu = input.next();


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
            menuAkhir();
        }
        else{
            System.out.println("Invalid!! silahkan coba lagi");
            tampilanMainMenu();
        }
    }

    public void menuAkhir(){
        System.out.println( "=============================================================\n"+
                            "           Terimakasih sudah mengunjungi toko kami           \n"+
                            "        kami sangat menantikan kedatangan anda selanjutnya   \n"+
                            "=============================================================");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Test x = new Test();
        x.tampilanMainMenu();
    }
}
