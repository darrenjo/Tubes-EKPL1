public class Produk {
    private String proID;
    private String proNama;
    private String Partnumber;
    private String Jenisproduk;

    public Produk (String ProID, String ProNama, String Partnumber, String Jenisproduk) {
        this.proID = ProID;
        this.proNama = ProNama;
        this.Partnumber = Partnumber;
        this.Jenisproduk = Jenisproduk;
    }


    //setter and getter
    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProNama() {
        return proNama;
    }

    public void setProNama(String proNama) {
        this.proNama = proNama;
    }

    public String getPartnumber() {
        return Partnumber;
    }

    public void setPartnumber(String Partnumber) {
        this.Partnumber = Partnumber;
    }

    public String getJenisproduk() {
        return Jenisproduk;
    }

    public void setJenisproduk(String Jenisproduk) {
        this.Jenisproduk = Jenisproduk;
    }

    public String toString () {
        return  "Product ID       : "+proID+"\n"+
                "Product Nama     : "+proNama+"\n"+
                "Product Kategori : "+Partnumber+"\n"+
                "Product Supplier : "+Jenisproduk;
    }
}
