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
        System.out.println(" ");
        System.out.println("+==============================================+");
        System.out.println("|                  SHOW MENU                   |");
        System.out.println("+==============================================+");
        System.out.println("1. All Warehouses");
        System.out.println("2. All Products");
        System.out.println("3. All Inventories");
        System.out.println("4. Choose a specific Warehouse");
        System.out.println("5. Choose a specific Product");
        System.out.println("0. Exit");
        System.out.print("Input menu: ");
        Scanner input = new Scanner(System.in);
        String menusShow = input.nextLine();
        System.out.println(" ");

        Read readData = new Read(warehouses, products);

        if (menusShow.equalsIgnoreCase("1")) {
            readData.readDataWarehouse();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("2")) {
            readData.readDataProduct();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("3")){
            readData.readDataInventory();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("4")) {
            readData.readSpecifiedWarehouse();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("5")) {
            readData.readSpecifiedProduct();
            tampilanMenu();
        } else if (menusShow.equalsIgnoreCase("0")) {
            x.tampilanMainMenu();
        } else {
            System.out.println("Wrong input! *try 0,1,...");
            tampilanMenu();
        }
    }

    public void tampilanMenuManage() throws FileNotFoundException {
        System.out.println(" ");
        System.out.println("+==============================================+");
        System.out.println("|                  MANAGE MENU                 |");
        System.out.println("+==============================================+");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("0. Exit");
        System.out.print("Input menu: ");
        Scanner inputManageMenu = new Scanner(System.in);
        String choice = inputManageMenu.next();
        System.out.println(" ");

        Manage manage = new Manage(warehouses, products);

        if (choice.equalsIgnoreCase("1")) {
            System.out.println(" ");
            System.out.println("+==============================================+");
            System.out.println("|                   ADD MENU                   |");
            System.out.println("+==============================================+");
            System.out.println("1. Add Warehouse");
            System.out.println("2. Add Product");
            System.out.println("0. Exit");
            System.out.print("Input menu: ");
            Scanner inputAddMenu = new Scanner(System.in);
            String choices = inputAddMenu.next();

            if (choices.equalsIgnoreCase("1")) {
                manage.addWarehouse();
                tampilanMenuManage();
            } else if (choices.equalsIgnoreCase("2")) {
                manage.addProduct();
                tampilanMenuManage();
            } else{
                x.tampilanMainMenu();
            }
        } else if (choice.equalsIgnoreCase("2")) {
            System.out.println(" ");
            System.out.println("+==============================================+");
            System.out.println("|                 DELETE MENU                  |");
            System.out.println("+==============================================+");
            System.out.println("1. Delete Warehouse");
            System.out.println("2. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Input menu: ");
            Scanner input = new Scanner(System.in);
            String menusDelete = input.nextLine();

            if (menusDelete.equalsIgnoreCase("1")) {
                manage.deleteWarehouse();
                tampilanMenuManage();
            } else if (menusDelete.equalsIgnoreCase("2")) {
                manage.deleteProduct();
                tampilanMenuManage();
            } else if (menusDelete.equalsIgnoreCase("0")) {
                x.tampilanMainMenu();
            } else {
                System.out.println("Wrong input! *try 0,1,...");
                tampilanMenuManage();
            }
        } else if (choice.equalsIgnoreCase("0")) {
            x.tampilanMainMenu();
        } else {
            System.out.println("Wrong input! *try 0,1,...");
            tampilanMenuManage();
        }
    }


    public void tampilanMenuTransaksi() throws FileNotFoundException {
        System.out.println(" ");
        System.out.println("+==============================================+");
        System.out.println("|              TRANSACTION MENU                |");
        System.out.println("+==============================================+");
        System.out.println("1. Add Stock");
        System.out.println("2. Reduce Stock");
        System.out.println("0. Exit");
        System.out.print("Input menu: ");
        Scanner input = new Scanner(System.in);
        String pilihMenuHapus = input.nextLine();

        Transaction transaction = new Transaction(warehouses, products);

        if (pilihMenuHapus.equalsIgnoreCase("1")) {
            transaction.addProduct(products);
            tampilanMenuTransaksi();
        } else if (pilihMenuHapus.equalsIgnoreCase("2")) {
            transaction.reduceProduct(products);
            tampilanMenuTransaksi();
        } else if (pilihMenuHapus.equalsIgnoreCase("0")) {
            x.tampilanMainMenu();
        } else {
            System.out.println("Wrong input! *try 0,1,...");
            tampilanMenuTransaksi();
        }
    }
}
