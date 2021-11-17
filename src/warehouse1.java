import java.util.Scanner;
import java.util.ArrayList;

public class warehouse1 {
    private String wareID;
    private String wareName;
    private String wareAlamat;

    String warehouseID;
    String warehouseNAME;
    String warehouseALAMAT;
    String produkID;
    String produkNAME;
    int produkPARTNUMBER;
    String produkTYPE;

    public warehouse1(String wareID,String wareName, String wareAlamat) {
        this.wareID = wareID;
        this.wareName = wareName;
        this.wareAlamat = wareAlamat;
    }

    //setter and getter
    public String getWareID() {
        return wareID;
    }

    public void setWareID(String wareID) {
        this.wareID = wareID;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getWareAlamat() {
        return wareAlamat;
    }

    public void setWareAlamat(String wareAlamat) {
        this.wareAlamat = wareAlamat;
    }

    public String toString() {
        return  "Warehouse ID     : "+wareID+"\n"+
                "Warehouse Nama   : "+wareName+"\n"+
                "Warehouse Alamat : "+wareAlamat;
    }

    public static void inputUserWH(String inputUserWH) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> IDwarehouse = new ArrayList<String>();
        ArrayList<String> Namawarehouse = new ArrayList<String>();
        ArrayList<String> Alamatwarehouse = new ArrayList<String>();

        int warehouseID = input.nextInt();
        System.out.println("Masukan ID Warehouse anda : ");
        int warehouseNAME = input.nextInt();
        System.out.println("Masukan Nama Warehouse anda : ");
        int produkID = input.nextInt();
        System.out.println("Enter number: ");

    }
}
