import javax.tools.JavaFileManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class test {
    private String idwarehouse;
    private String namawarehouse;
    private String alamatwarehouse;
    private String proID;
    private String proNama;
    private String partnumber;
    private String jenisproduk;
    private String unitCost;
    private String sisaStock;
    private String wareID;
    private String wareName;
    private String wareAlamat;


    Produk produk = new Produk(proID, proNama, partnumber, jenisproduk);

    Inventory inventory = new Inventory(wareID,proID,unitCost,sisaStock);
    warehouse1 warehouse = new warehouse1(wareID, wareName, wareAlamat);

    private ArrayList < Produk > produklist = new ArrayList();
    private ArrayList < warehouse1 > warelist = new ArrayList();

    public void readinput()throws IOException{
        File inputWare = new File("E:\\YH\\ITHB\\Semester 3\\Elemen Konstruksi Perangkat Lunak I (3)\\Tugas\\src\\CS4_Warehouse.txt");
        File inputInvet = new File("E:\\YH\\ITHB\\Semester 3\\Elemen Konstruksi Perangkat Lunak I (3)\\Tugas\\src\\CS4_Inventory.txt");
        File inputProd = new File("E:\\YH\\ITHB\\Semester 3\\Elemen Konstruksi Perangkat Lunak I (3)\\Tugas\\src\\CS4_Produk.txt");

        //scanner
        Scanner readWare = new Scanner (inputWare);
        while (readWare.hasNextLine()) {
            String []warehouse = readWare.nextLine().split(";");
            idwarehouse = warehouse[0];
            namawarehouse = warehouse[1];
            alamatwarehouse = warehouse[2];
            System.out.println( "ID Warehouse       : "+idwarehouse+"\n"+
                                "Nama Warehouse     : "+namawarehouse+"\n"+
                                "Alamat Warehouse   : "+alamatwarehouse+"\n"+"\n");
            String file = readWare.nextLine();
            System.out.println(file);
        }
        readWare.close();

        Scanner readProd = new Scanner (inputProd);
        while (readProd.hasNextLine()) {
            String []produk = readProd.nextLine().split(";");
            proID = produk [0];
            proNama = produk [1];
            partnumber= produk [2];
            jenisproduk = produk [3];
            System.out.println( "ID Product    : "+proID+"\n"+
                                "Nama Product  : "+proNama+"\n"+
                                "Angka Product : "+partnumber+"\n"+
                                "Jenis Product : "+jenisproduk+"\n"+"\n");
            String file = readProd.nextLine();
            System.out.println(file);
        }
        readProd.close();

        Scanner readInvet = new Scanner (inputInvet);
        while (readInvet.hasNextLine()) {
            String []inventory = readInvet.nextLine().split(";");
            idwarehouse = inventory[0];
            proID = inventory[1];
            unitCost = inventory[2];
            sisaStock = inventory[3];
            System.out.println("ID warehouse  : "+idwarehouse+"\n"+
                               "ID Product    : "+proID+"\n"+
                               "Harga         : "+unitCost+"\n"+
                               "Sisa barang   : "+sisaStock+"\n"+"\n");
            String file = readInvet.nextLine();
            System.out.println(file);
        }
        readInvet.close();
    }

    //print
    public void display() throws Exception{
        readinput();

        //while true
        //pilihannya pakai if else
        // untuk memberhenttikannya pke break
        // dikasih apakah user mau menyimpan perubahan datanya
        // cara panggil fungsi di class lain
        System.out.println("===============================");
    }

    public void ifelseMenuAwal() {
        System.out.print(
                "=========================================\n" +
                        "  Welcome to OMIRAQI's Furniture Store!\n" +
                        "=========================================\n" +
                        "Choose the menu !\n" +
                        "1. View\n" +
                        "2. Add/Edit/Delete\n" +
                        "9. Exit\n");
        Scanner pilihanUser = new Scanner(System.in);
        System.out.print("Your Choice : ");
        String choise = pilihanUser.nextLine();

        if (choise == 1) {

        }
    }


    public static void main(String[] args) throws IOException {
        test testMethod = new test();
        testMethod.readinput();
//        Test = new Test();
//        b.manipulateString(b.getInputString());
//        System.out.println(inputUserWH());
//        inputUserWH();

    }
}
