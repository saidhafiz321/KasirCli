package aplikasikasir;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // deklarasi arraylist bertipe objek
        ArrayList<objekarraylist> dataBarang = new ArrayList<>();
        // deklarasi data base
        String filebarang = "C:\\Dev\\Tugas Kuliah\\Poin Of Sale\\src\\aplikasikasir\\DataBaseBarang.txt";
        String filetransaksi = "C:\\Dev\\Tugas Kuliah\\Poin Of Sale\\src\\aplikasikasir\\DataBaseTransaksi.txt";
        boolean mulai = true;
        int id = -1;
        int i = -1;

        //while
        while (mulai){ // awal while

            //tampilan menu
            System.out.println("===========================================================");
            System.out.println("********************** M E N U ****************************");
            System.out.println("===========================================================");
            System.out.println("*                [1].  VIEW DATA BARANG                   *");
            System.out.println("*                [2].  TAMBAH BARANG                      *");
            System.out.println("*                [3].  TAMBAH STOCK BARANG                *");
            System.out.println("*                [4].  UPDATE HARGA BARANG                *");
            System.out.println("*                [5].  REMOVE DATA BARANG                 *");
            System.out.println("*                [6].  PEMBELIAN                          *");
            System.out.println("*                [7].  VIEW STRUK PENJUALAN               *");
            System.out.println("*                [8].  EXIT                               *");
            System.out.println("===========================================================");

            Scanner scan = new Scanner(System.in);
            System.out.print("Masukkan Pilihan : ");
            String masukan = scan.next();
            System.out.println("===========================================================\n");
            if (masukan.equals("1")) { //kurung pembuka opsi 1
                System.out.println("===========================================================");
                System.out.println("******************* VIEW DATA BARANG **********************");
                System.out.println("===========================================================");
                System.out.println("ID\t"+"NAMA BARANG\t\t"+"STOCK BARANG\t"+"HARGA BARANG\t"+"TERJUAL\t");
                try{
                    File myFile = new File(filebarang);
                    Scanner fileReader = new Scanner(myFile);

                    while(fileReader.hasNextLine()){
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("===========================================================\n");
                }catch(IOException e){
                    System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                }

            } //kurung penutup opsi 1

            else if (masukan.equals("2")) { //kurung pembuka opsi 2
                System.out.println("===========================================================");
                System.out.println("********************** TAMBAH BARANG **********************");
                System.out.println("===========================================================");
                System.out.print("Nama Barang   : ");
                String namaBarang = scan.next();
                System.out.print("Jumlah Barang : ");
                int jumlahBarang = scan.nextInt();
                System.out.print("Harga Barang  : Rp. ");
                int hargaBarang = scan.nextInt();
                int terjual = 0;
                //konfirmasi save
                System.out.println("========================================");
                System.out.print("Apakah Anda Ingin Save y/t ? ");
                String save = scan.next();
                System.out.println("========================================");
                if (save.equalsIgnoreCase("y")) { //kurung pembuka konfirmasi save
                    id++;
                    i++;
                    dataBarang.add(new objekarraylist(id, namaBarang, jumlahBarang, hargaBarang, terjual));
                    System.out.println("Data Barang Berhasil Di Simpan");
                    try{
                        FileWriter fileWriter = new FileWriter(filebarang, true);
                        fileWriter.append(dataBarang.get(i).id+"\t"+dataBarang.get(i).namaBarang+"\t\t\t"+dataBarang.get(i).stockBarang+"\t\t\t\t"+dataBarang.get(i).hargaBarang+"\t\t\t"+dataBarang.get(i).terjual+"\n");
                        fileWriter.close();
                    }catch(IOException e){
                        System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                    }
                } //kurung penutup konfirmasi save
                else{
                    System.out.println("========================================");
                    System.out.println("Penambahan Barang Di Batalkan");
                }
            }//kurung penutup opsi 2
            if (masukan.equals("3")) { //kurung pembuka opsi 3
                int index = -1;
                boolean ditemukan = false;
                System.out.println("===========================================================");
                System.out.println("******************* VIEW DATA BARANG **********************");
                System.out.println("===========================================================");
                System.out.println("ID\t"+"NAMA BARANG\t\t"+"STOCK BARANG\t"+"HARGA BARANG\t"+"TERJUAL\t");
                try{
                    File myFile = new File(filebarang);
                    Scanner fileReader = new Scanner(myFile);

                    while(fileReader.hasNextLine()){
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("===========================================================\n");
                }catch(IOException e){
                    System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                }
                System.out.println("===========================================================");
                System.out.println("***************** TAMBAH STOCK BARANG *********************");
                System.out.println("===========================================================");
                System.out.print("Tambah Stock Barang Dengan Id : ");
                int kodeBarang = scan.nextInt();
                for (int j = 0; j < dataBarang.size(); j++) {
                    if (dataBarang.get(j).id == kodeBarang) {
                        index = j;
                        ditemukan = true;
                    }
                }
                if (ditemukan == true) { //kurung pembuka id ditemukan
                    System.out.print("Jumlah Penambahan Stock : ");
                    int tambahStock = scan.nextInt();
                    System.out.println("========================================");
                    System.out.print("Yakin Ingin Menambah y/t ? ");
                    String tambah = scan.next();
                    System.out.println("====================================");
                    if (tambah.equalsIgnoreCase("y")) { //kurung pembuka penambahan stock
                        objekarraylist updateStock = dataBarang.get(kodeBarang);
                        updateStock.stockBarang = dataBarang.get(kodeBarang).stockBarang+tambahStock;
                        System.out.println("Penambahan Stock Barang Berhasil");
                        try{
                            FileWriter fileWriter = new FileWriter(filebarang, false) ;
                            for(objekarraylist barangku: dataBarang){
                                fileWriter.append(barangku.id+"\t"+barangku.namaBarang+"\t\t\t"+barangku.stockBarang+"\t\t\t\t"+barangku.hargaBarang+"\t\t\t"+barangku.terjual+"\n");
                            }
                            fileWriter.close();
                        }catch(IOException e){
                            System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                        }
                    }//kurung pembuka penambahan stock
                    else{
                        System.out.println("========================================");
                        System.out.println("Penambahan Stock Barang Dibatalkan");
                    }
                } //kurung penutup id ditemukan
                else{
                    System.out.println("========================================");
                    System.out.println("Id Yang Anda Masukkan Tidak Ditemukan");
                }
            }//kurung penutup opsi 3

            if (masukan.equals("4")) {
                int index = -1;
                boolean ditemukan = false;
                System.out.println("===========================================================");
                System.out.println("******************* VIEW DATA BARANG **********************");
                System.out.println("===========================================================");
                System.out.println("ID\t"+"NAMA BARANG\t\t"+"STOCK BARANG\t"+"HARGA BARANG\t"+"TERJUAL\t");
                try{
                    File myFile = new File(filebarang);
                    Scanner fileReader = new Scanner(myFile);

                    while(fileReader.hasNextLine()){
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("===========================================================\n");
                }catch(IOException e){
                    System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                }
                System.out.println("===========================================================");
                System.out.println("***************** UPDATE HARGA BARANG *********************");
                System.out.println("===========================================================");
                System.out.print("Update Harga Barang Dengan ID : ");
                int kodebarang = scan.nextInt();
                for (int j = 0; j < dataBarang.size(); j++) {
                    if (dataBarang.get(j).id == kodebarang) {
                        index = j;
                        ditemukan = true;
                    }
                }
                if (ditemukan == true) {
                    System.out.println("=====================================================");
                    System.out.print("Update Harga Baru : Rp. ");
                    int hargabaru = scan.nextInt();
                    System.out.println("======================================================");
                    System.out.print("Simpan Hasil Update y/t ? ");
                    String tambah = scan.next();
                    System.out.println("=======================================================");

                    if (tambah.equalsIgnoreCase("y")) {
                        objekarraylist updateharga = dataBarang.get(kodebarang);
                        updateharga.hargaBarang = hargabaru;
                        System.out.println("Harga Barang Berhasil Di Update");
                        try {
                            FileWriter filewriter = new FileWriter(filebarang, false);
                            for (objekarraylist barangku : dataBarang) {
                                filewriter.append(barangku.id + "\t" + barangku.namaBarang + "\t\t\t" + barangku.stockBarang + "\t\t\t\t" + barangku.hargaBarang + "\t\t\t" + barangku.terjual + "\n");
                            }
                            filewriter.close();
                        } catch (IOException e) {
                            System.out.println("Terjadi Kesalahan Karena : "+e.getMessage());
                        }
                    }
                    else{
                        System.out.println("==========================================================");
                        System.out.println("Update Harga Barang Dibatalkan");
                        System.out.println("===========================================================");
                    }
                }
                else {
                    System.out.println("============================================================");
                    System.out.println("ID Yang Anda Masukan Tidak Ditemukan");
                    System.out.println("=============================================================");

                }
            }
            if (masukan.equals("5")) { //kurung pembuka opsi 5
                int index = -1;
                boolean ditemukan = false;
                System.out.println("===========================================================");
                System.out.println("******************* VIEW DATA BARANG **********************");
                System.out.println("===========================================================");
                System.out.println("ID\t"+"NAMA BARANG\t\t"+"STOCK BARANG\t"+"HARGA BARANG\t"+"TERJUAL\t");
                try{
                    File myFile = new File(filebarang);
                    Scanner fileReader = new Scanner(myFile);

                    while(fileReader.hasNextLine()){
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("===========================================================\n");
                }catch(IOException e){
                    System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                }
                System.out.print("Hapus Barang Dengan Id : ");
                int hapus = scan.nextInt();

                for (int j = 0; j < dataBarang.size(); j++) {
                    if (dataBarang.get(j).id == hapus) {
                        index = j;
                        ditemukan = true;
                    }
                }
                if (ditemukan == true) { //kurung pembuka id barang ditemukan
                    System.out.print("apakah Anda Yakin Akan Menghapusnya y/t ? ");
                    String hapusBarang = scan.next();
                    if (hapusBarang.equalsIgnoreCase("y")) {
                        dataBarang.remove(hapus);
                        System.out.println("Data Barang Berhasil Di Hapus");
                        try{
                            FileWriter fileWriter = new FileWriter(filebarang, false) ;
                            for(objekarraylist barangku: dataBarang){
                                fileWriter.append(barangku.id+"\t"+barangku.namaBarang+"\t\t\t"+barangku.stockBarang+"\t\t\t\t"+barangku.hargaBarang+"\t\t\t"+barangku.terjual+"\n");
                            }
                            fileWriter.close();
                        }catch(IOException e){
                            System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                        }
                    }
                    else{
                        System.out.println("========================================");
                        System.out.println("Penghapusan Di Batalakan");
                    }
                } //kurung penutup id barang ditemukan
                else{
                    System.out.println("========================================");
                    System.out.println("Id Yang Anda Masukkan Tidak Ditemukan");
                }
            } //kurung penutup opsi 5
            if (masukan.equals("6")) { //kurung pembuka opsi 6
                System.out.println("===========================================================");
                System.out.println("******************* VIEW DATA BARANG **********************");
                System.out.println("===========================================================");
                System.out.println("ID\t"+"NAMA BARANG\t\t"+"STOCK BARANG\t"+"HARGA BARANG\t"+"TERJUAL\t");
                try{
                    File myFile = new File(filebarang);
                    Scanner fileReader = new Scanner(myFile);

                    while(fileReader.hasNextLine()){
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("===========================================================\n");
                }catch(IOException e){
                    System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                }
                System.out.println("===========================================================");
                System.out.print("Id Barang Yang Dibeli : ");
                int pilihBarang = scan.nextInt();
                int index = -1;
                boolean ditemukan = false;
                for (int j = 0; j < dataBarang.size(); j++) {
                    if (dataBarang.get(j).id == pilihBarang) {
                        index = j;
                        ditemukan = true;
                    }
                }
                if (ditemukan == true) { //kurung pembuka ditemukan
                    System.out.println("===========================================================");
                    System.out.print("Jumlah Barang Belanjaan : ");
                    int jumlahBelanjaan = scan.nextInt();
                    objekarraylist update = dataBarang.get(pilihBarang);
                    update.stockBarang = dataBarang.get(pilihBarang).stockBarang-jumlahBelanjaan;
                    update.terjual = dataBarang.get(pilihBarang).terjual+jumlahBelanjaan;
                    try{
                        FileWriter fileWriter = new FileWriter(filebarang, false) ;
                        for(objekarraylist barangku: dataBarang){
                            fileWriter.append(barangku.id+"\t"+barangku.namaBarang+"\t\t"+barangku.stockBarang+"\t\t"+barangku.terjual+"\t\t"+barangku.hargaBarang+"\n");
                        }
                        fileWriter.close();
                    }catch(IOException e){
                        System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                    }
                    //menulis struk belanjaan
                    try{
                        FileWriter fileWriter = new FileWriter(filetransaksi, true);
                        fileWriter.write("\n==========================================================");
                        fileWriter.write("\n******************* BUKTI TRANSAKSI **********************");
                        fileWriter.write("\n==========================================================");
                        fileWriter.write("\nId Barang     : "+pilihBarang);
                        fileWriter.write("\nNama Barang   : "+dataBarang.get(index).namaBarang);
                        fileWriter.write("\nJumlah Barang : "+jumlahBelanjaan);
                        fileWriter.write("\nHarga Barang  : Rp. "+dataBarang.get(index).hargaBarang);
                        fileWriter.write("\n===========================================================");
                        fileWriter.write("\nTotal Bayar   : Rp. "+dataBarang.get(index).hargaBarang*jumlahBelanjaan);
                        fileWriter.write("\n===========================================================\n");
                        fileWriter.close();
                    }catch(IOException e){
                        System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                    }

                    int idbarang = pilihBarang;
                    String namabarang = dataBarang.get(index).namaBarang;
                    int jumlahbarang = jumlahBelanjaan;
                    int hargabarang = dataBarang.get(index).hargaBarang;
                    int totalbayar = dataBarang.get(index).hargaBarang*jumlahBelanjaan;


                    System.out.println("\n==========================================================");
                    System.out.println("\n******************* BUKTI TRANSAKSI **********************");
                    System.out.println("\n==========================================================\n");
                    System.out.println("Id Barang     : "+idbarang);
                    System.out.println("Nama Barang   : "+namabarang);
                    System.out.println("Jumlah Barang : "+jumlahbarang);
                    System.out.println("Harga Barang  : Rp. "+hargabarang);
                    System.out.println("\n===========================================================");
                    System.out.println("\nTotal Bayar   : Rp. "+totalbayar);
                    System.out.println("\n===========================================================\n");


                }//penutup ditemukan
                else{
                    System.out.println("===========================================================");
                    System.out.println("Id Yang Anda Masukkan Tidak Ditemukan");
                }
            }// penutup opsi 6
            if (masukan.equals("7")) {
                System.out.println("===========================================================");
                System.out.println("***************** VIEW STRUK PENJUALAN ********************");
                System.out.println("===========================================================");
                try{
                    File mystruk = new File(filetransaksi);
                    Scanner fileReader = new Scanner(mystruk);

                    while(fileReader.hasNextLine()){
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("===========================================================\n");
                }catch(IOException e){
                    System.out.println("Terjadi Kesalahan karena: "+e.getMessage());
                }

            }
            else if (masukan.equals("8")) {
                System.out.println("EXIT");
                break;
            }

        } // penutup while
    } // penutup methot main
} // penutup main class
