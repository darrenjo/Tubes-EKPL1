import javax.swing.*;
import java.awt.event.*;

public class GUI {
    public static void main(String[] args) {
        JTextField t1,t2;
        JLabel judul,l2,l3;
        JFrame f=new JFrame("Tugas Besar EKPL");
        judul=new JLabel("Menu");
        l2=new JLabel();
        l3=new JLabel();
        JButton SP=new JButton("Menampilkan Semua Produk");
        JButton SI=new JButton("Menampilkan Semua Inventori");
        JButton SW=new JButton("Menampilkan Semua Warehouse");
        JButton PT=new JButton("Menampilkan Produk Tertentu");
        JButton WT=new JButton("Menampilkan Warehouse Tertentu");
        JButton TSP=new JButton("Menambah Stock Produk");
        JButton KSP=new JButton("Mengurangi Stock Produk");
        JButton TP=new JButton("Menambahkan Produk Baru");
        JButton TW=new JButton("Menambahkan Warehouse Baru");
        JButton TI=new JButton("Menambahkan Data Inventori Baru");
        JButton HP=new JButton("Menghapus Produk");
        JButton HW=new JButton("Menghapus Warehouse");
        JButton HI=new JButton("Menghapus Inventori");
        JButton E=new JButton("Keluar");
        JButton C=new JButton("Cari");
        t1 = new JTextField();
        judul.setBounds(300,50, 100,30);
        l2.setBounds(50,500, 100,30);
        l3.setBounds(50,450, 100,30);

        SP.setBounds(50,100,250,30);
        SW.setBounds(50,150,250,30);
        SI.setBounds(50,200,250,30);
        PT.setBounds(50,250,250,30);
        WT.setBounds(50,300,250,30);
        TSP.setBounds(50,350,250,30);
        KSP.setBounds(50,400,250,30);

        TP.setBounds(320,100,250,30);
        TW.setBounds(320,150,250,30);
        TI.setBounds(320,200,250,30);
        HP.setBounds(320,250,250,30);
        HW.setBounds(320,300,250,30);
        HI.setBounds(320,350,250,30);
        E.setBounds(320,400,250,30);

        C.setBounds(50,200,250,30);
        SP.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                l2.setBounds(50,450, 100,30);
                l2.setText("Data Produk");

            }
        });
        SW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l3.setText("Warehouse ID");
                t1.setBounds(180,450,100,30);
                C.setBounds(300,450,200,30);
                l2.setText("Data Inventori");
            }
        });
        SI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setBounds(180,250,100,30);
                C.setBounds(300,250,200,30);
                l2.setText("Data Warehouse");
            }
        });
        f.add(SP);f.add(SW);f.add(SI);f.add(PT);f.add(WT);f.add(TSP);f.add(KSP);f.add(TP);f.add(TW);f.add(TI);f.add(HP);f.add(HW);f.add(HI);f.add(E);
        f.add(judul);f.add(l2);f.add(t1);f.add(C);f.add(l3);
        f.setSize(650,1000);
        f.setLayout(null);
        f.setVisible(true);
    }
}