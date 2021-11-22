import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Test x = new Test();
    ArrayList<Warehouse> warehouses;
    ArrayList<Product> products;

    public Menu(ArrayList<Warehouse> warehouses, ArrayList<Product> products) {
        this.warehouses = warehouses;
        this.products = products;
    }

    public void tampilanMenu() throws FileNotFoundException {
        System.out.println( "\n    ~~~~                 MENU                  ~~~~\n" +
                            "1. Lihat Warehouse\n" +
                            "2. Lihat Produk\n" +
                            "3. Lihat Inventori\n" +
                            "4. Pilih dengan kode Warehouse\n" +
                            "5. Pilih dengan kode Produk\n" +
                            "6. Sisa Stok\n" +
                            "0. Kembali\n" +
                            "Pilihan anda [1/2/3/4/5/6/0]: ");
        Scanner input = new Scanner(System.in);
        String menusShow = input.nextLine();
        System.out.println(" ");

        Read readData = new Read(warehouses, products);

        if (menusShow.equalsIgnoreCase("1")) {
            readData.readWarehouseData();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("2")) {
            readData.readDataProduct();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("3")){
            readData.readInventoryData();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("4")) {
            readData.readWarehouseList();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("5")) {
            readData.readProductList();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("6")) {
            tampilanMenuMaxMin();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("0")) {
            x.tampilanMainMenu();
        } else {
            System.out.println("Invalid!! silahkan coba lagi");
            tampilanMenu();
        }
    }


    public void tampilanMenuMaxMin() throws FileNotFoundException{
        System.out.println( "\n    ~~~~           MENU SISA STOK            ~~~~\n" +
                "1. Produk Minimum\n" +
                "2. Produk Maximum\n" +
                "0. Kembali\n" +
                "Pilihan anda [1/2/0]: ");
        Scanner inputManageMenu = new Scanner(System.in);
        String choice = inputManageMenu.next();
        System.out.println(" ");

        Read readData = new Read(warehouses, products);

        if (choice.equalsIgnoreCase("1")) {
            readData.readMinProduct();
            tampilanMenuMaxMin();
        } else if (choice.equalsIgnoreCase("2")) {
            readData.readMaxProduct();
            tampilanMenuMaxMin();
        } else if (choice.equalsIgnoreCase("0")) {
            tampilanMenu();
        } else {
            System.out.println("Invalid!! silahkan coba lagi");
            tampilanMenuMaxMin();
        }
    }

    public void tampilanMenuManage() throws FileNotFoundException {
        System.out.println( "\n    ~~~~         MENU MENGATUR BARANG          ~~~~\n" +
                            "1. Tambahkan\n" +
                            "2. Kurangi\n" +
                            "0. Kembali\n" +
                            "Pilihan anda [1/2/0]: ");
        Scanner inputManageMenu = new Scanner(System.in);
        String choice = inputManageMenu.next();
        System.out.println(" ");

        Add add = new Add(warehouses, products);

        if (choice.equalsIgnoreCase("1")) {
            System.out.println( "\n    ~~~~          MENU MENAMBAHKAN          ~~~~\n" +
                                "1. Tambahkan Warehouse\n" +
                                "2. Tambahkan ProduK\n" +
                                "0. Kembali\n" +
                                "Pilihan anda [1/2/0]: ");
            Scanner inputAddMenu = new Scanner(System.in);
            String choices = inputAddMenu.next();

            if (choices.equalsIgnoreCase("1")) {
                add.addWarehouse();
                tampilanMenuManage();
            } else if (choices.equalsIgnoreCase("2")) {
                add.addProduct();
                tampilanMenuManage();
            } else{
                x.tampilanMainMenu();
            }
        } else if (choice.equalsIgnoreCase("2")) {
            System.out.println( "\n    ~~~~           MENU MENGHAPUS           ~~~~\n" +
                                "1. Kurangi Warehouse\n" +
                                "2. Kurangi Product\n" +
                                "0. Kembali\n" +
                                "Pilihan anda [1/2/0]: ");
            Scanner input = new Scanner(System.in);
            String menusDelete = input.nextLine();

            Delete delete = new Delete(warehouses, products);

            if (menusDelete.equalsIgnoreCase("1")) {
                delete.deleteWarehouse();
                tampilanMenuManage();
            } else if (menusDelete.equalsIgnoreCase("2")) {
                delete.deleteProduct();
                tampilanMenuManage();
            } else if (menusDelete.equalsIgnoreCase("0")) {
                x.tampilanMainMenu();
            } else {
                System.out.println("Invalid!! silahkan coba lagi");
                tampilanMenuManage();
            }
        } else if (choice.equalsIgnoreCase("0")) {
            x.tampilanMainMenu();
        } else {
            System.out.println("Invalid!! silahkan coba lagi");
            tampilanMenuManage();
        }
    }


    public void tampilanMenuTransaksi() throws FileNotFoundException {
        System.out.println( "\n    ~~~~             MENU GUDANG             ~~~~\n" +
                            "1. Tambahkan Persediaan\n" +
                            "2. Kurangi Persediaan\n" +
                            "0. Kembali\n" +
                            "Input menu [1/2/0]: ");
        Scanner input = new Scanner(System.in);
        String pilihMenuHapus = input.nextLine();

        Transaction transaction = new Transaction(warehouses, products);

        if (pilihMenuHapus.equalsIgnoreCase("1")) {
            transaction.addProduct(products);
            tampilanMenuTransaksi();
        } else if (pilihMenuHapus.equalsIgnoreCase("2")) {
            transaction.deleteProduct(products);
            tampilanMenuTransaksi();
        } else if (pilihMenuHapus.equalsIgnoreCase("0")) {
            x.tampilanMainMenu();
        } else {
            System.out.println("Invalid!! silahkan coba lagi");
            tampilanMenuTransaksi();
        }
    }
}
