// package week_10.phone;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class CellphoneMain {

    public static void display1(int batteryLevel) {
        System.err.println("======================");
        System.err.println("Phone | Baterai : " + batteryLevel + "%");
        System.err.println("======================");

    }

    public static void displayBeliPaketData() {
        System.out.println("=== Pilihan Paket Data ===");
        System.out.println("1. 1GB - Rp10.000");
        System.out.println("2. 5GB - Rp25.000");
        System.out.println("3. 10GB - Rp40.000");
        System.out.println("4. 15GB - Rp55.000");
        System.out.println("5. 20GB - Rp70.000");
        System.out.println("6. Kembali ke menu utama");
        System.out.print("Silakan pilih paket data : ");
    }

    public static void display2() {
        System.out.print(
                "1. [*] Cek Pulsa\n" +
                        "2. [$] Isi Pulsa\n" +
                        "3. [#] Isi Paket Data\n" +
                        "4. [@] Daftar Kontak\n" +
                        "5. [+] Tambah Kontak\n" +
                        "6. [-] Hapus Kontak\n" +
                        "7. [X] Matikan Daya\n");
    }

    public static void main(String[] args) {
        Cellphone cp = new Cellphone("Nokia", "3310");
        Scanner scanner = new Scanner(System.in);

        int pil;
        int pulsa;
        int paketData;
        String namaKontak;
        int noKontak;

        cp.powerOn();

        do {
            display1(cp.getBattery());
            cp.getBatteryLevel();
            display2();
            System.out.print("> ");
            pil = scanner.nextInt();
            scanner.nextLine();

            switch (pil) {
                case 1:
                    // Cek Pulsa

                    System.out.println("Pulsa anda : " + cp.getBalance());

                    break;

                case 2:
                    // Isi Pulsa
                    System.out.print("Silakan masukkan nominal pulsa yang ingin anda isi : ");
                    pulsa = scanner.nextInt();
                    scanner.nextLine();

                    cp.topUpBalance(pulsa);

                    break;

                case 3:
                    // Isi Paket Data

                    displayBeliPaketData();
                    pil = scanner.nextInt();
                    scanner.nextLine();

                    if (pil == 6) {
                        System.out.println("Kembali ke Menu Utama...");
                        break; // keluar dari sub-menu paket data dan kembali ke menu utama
                    }

                    try {
                        System.out.println("\nIsi Paket " + pil);
                        cp.beliPaketData(pil);
                    } catch (InsufficientFundsException e) {
                        System.out.println(
                                "Maaf pulsa anda tidak cukup, kurang " + e.getAmount()
                                        + " silahkan isi pulsa anda");
                    }

                    break;

                case 4:
                    // Daftar Kontak
                    cp.listContact();
                    break;

                case 5:
                    // Tambah Kontak
                    break;

                case 6:
                    // Hapus Kontak
                    break;

                case 7:
                    // Matikan Daya
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

        } while (pil != 7);

        // cp.topUpBalance(10000);
        // System.out.println("Sisa pulsa: " + cp.getBalance());
        // cp.insertContact("Harry", "078123545");
        // cp.insertContact("Diana", "081234567890");
        // cp.listContact();
        // cp.getContact("Harry");
        // cp.phoneInfo();

        // Smartphone sp = new Smartphone("Samsung", "M10");
        // sp.topUpBalance(50000);
        // sp.phoneInfo();
    }
}
