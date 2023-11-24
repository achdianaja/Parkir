/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkir;

/**
 *
 * @author rizki
 */
import java.util.Scanner;

//========================= CLASS WAKTU =========================
// Class ini berfungsi untuk mengiputkan waktu agar tidak digunakan secara
// tidak teratur saya buatkan class untuk waktunya, dan agar tidak bertumpuk
// antara waktu masuk dan keluar
class Waktu {

    int Jam;
    int Menit;
    int Detik;

    Scanner in = new Scanner(System.in);

    // function ini digunaakan untuk menginput Jam, Menit, dan Detik
    // dipanggil ke package parkir
    void isiData() {

        // ini input yang akan di panggil dipackage parkir
        System.out.print("Jam   : ");
        Jam = in.nextInt();
        System.out.print("Menit : ");
        Menit = in.nextInt();
        System.out.print("Detik : ");
        Detik = in.nextInt();
    }

    int totalDetik() {
        return Jam * 3600 + Menit * 60 + Detik;
    }
}
