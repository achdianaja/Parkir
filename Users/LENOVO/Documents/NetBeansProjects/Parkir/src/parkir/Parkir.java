/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parkir;

/**
 *
 * @author rizki
 */
import java.util.Scanner; // import untuk bisa menginput
import java.text.DecimalFormat; //import untuk memformat data uang

public class Parkir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        DecimalFormat IdrFormat = new DecimalFormat("#,##0.###");//untuk format uang menjadi ada titiknya

//        ========================= DEKLARASI & TIPE DATA =========================
        int jenis, selisih;
        long bayar;
        String[] kendaraan = {"1.Mobil", "2.Motor"};
        String platNomor;
        boolean statusDenda = false;

        // deklrasi untuk mengambil input dari class waktu
        Waktu masuk = new Waktu();
        Waktu keluar = new Waktu();
        Waktu lamaParkir = new Waktu();

//          ========================= PROSES INPUT =========================
        System.out.println("====================================");
        System.out.println("== PROGRAM PERHITUNGAN JAM PARKIR ==");
        System.out.println("====================================");

        System.out.println("Pilih Jenis Kendaraan : ");
        for (int i = 0; i < kendaraan.length; i++) {
            System.out.println(kendaraan[i]);
        }

        System.out.print("Input jenis kendaraan : ");
        jenis = in.nextInt();

        while (jenis != 1 && jenis != 2) {
            System.out.println("INPUT KENDARAAN SALAH \nsilahkan input kembali");
            System.out.print("Input Jenis Kendaraan : ");
            jenis = in.nextInt();
        }

        in.nextLine();
        System.out.print("Masukan Plat Nomor : ");
        platNomor = in.nextLine();

        System.out.println("");
        System.out.println("Waktu Masuk");
        System.out.println("==================================");
        masuk.isiData(); //function isiData() berasal dari class Waktu
        System.out.println("");
        System.out.println("Waktu Keluar");
        System.out.println("==================================");
        keluar.isiData(); //function isiData() berasal dari class Waktu

        // kondisi dimana waktu keluar lebih kecil dari waktu masuk
        while (keluar.Jam < masuk.Jam) {
            System.out.println("Waktu Keluar Tidak Boleh Kurang dari Waktu Masuk! \nSilahkan Input Kembali!");
            System.out.println("");
            System.out.println("Waktu Keluar");
            System.out.println("==================================");
            keluar.isiData();
        }

//          ========================= PROSES PERHITUNGAN JAM LAMA PARKIR =========================
        selisih = keluar.totalDetik() - masuk.totalDetik();
        lamaParkir.Jam = selisih / 3600; // mengambil hasil selisih lalu dibagi dengan 3600 detik atau 1 jam

        lamaParkir.Menit = selisih % 3600 / 60; // mengabil sisa bagi dari selisih dengan 3600 detik atau 1 jam
        // lalu di bagi dengan 60

        lamaParkir.Detik = selisih % 3600 % 60; // mengambil dari selisih lalu mengambil sisa bagi dari 3600
        // dan mengambil sisa bagi lagi dengan 60  

//          ========================= HASIL AKHIR =========================
        System.out.println("");
        System.out.println("==================================");
        System.out.println("Lama Waktu Parkir : " + lamaParkir.Jam + " Jam : " + lamaParkir.Menit + " Menit : " + lamaParkir.Detik + " Detik");

        System.out.println("Plat Nomor : " + platNomor);
        // kondisi ini dimana jika kendaraan melebihi 1 jam maka akan di kenai denda sesuai dengan jenis kendaraannya
        switch(jenis){
            case 1:
               System.out.println("jenis kendaraan : Mobil ");
               if (selisih <= 3600) {
                   if (statusDenda != true) {
                       System.out.println("Status Denda : " + statusDenda);
                   }
                   bayar = 3000;
                   System.out.println("Jumlah Bayar    : " + IdrFormat.format(bayar));
               } else {
                   statusDenda = true;
                   if (statusDenda == true) {
                       System.out.println("Status Denda : " + statusDenda);
                       System.out.println("Message : Terkena Denda Sebesar " + IdrFormat.format(lamaParkir.Jam * 2000));
                   }
                   bayar = 3000 + lamaParkir.Jam * 2000;
                   System.out.println("Jumlah Bayar    : " + IdrFormat.format(bayar));
               }   
            break;
            case 2:
                System.out.println("jenis kendarann : Motor");
                if (selisih <= 3600) {
                    if (statusDenda != true) {
                        System.out.println("Status Denda : " + statusDenda);
                    }
                    bayar = 2000;
                    System.out.println("Jumlah Bayar    : " + IdrFormat.format(bayar));
                } else {
                    statusDenda = true;
                    if (statusDenda == true) {
                        System.out.println("Status Denda : " + statusDenda);
                        System.out.println("Message : Terkena Denda Sebesar " + IdrFormat.format(lamaParkir.Jam * 1000));
                    }
                    bayar = 2000 + lamaParkir.Jam * 1000; // denda motor akan dikalikan 1000 dari dari selisih jam nya
                    System.out.println("Jumlah Bayar    : " + IdrFormat.format(bayar));
                }
            break;
            default:
            System.out.println("Maaf pilihan tidak terdaftar");
        }
    }
}
