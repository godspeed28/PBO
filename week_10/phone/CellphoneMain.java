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
                        "3. [$] Cek Kuota Paket\n" +
                        "4. [#] Isi Paket Data\n" +
                        "5. [@] Daftar Kontak\n" +
                        "6. [+] Tambah Kontak\n" +
                        "7. [-] Hapus Kontak\n" +
                        "8. [i] Info Ponsel\n" +
                        "9. [!] Gunakan Paket Data\n" +
                        "10. [X] Matikan Daya\n");
    }

    public static void main(String[] args) {
        Cellphone cp = new Cellphone("Nokia", "3310");
        Scanner scanner = new Scanner(System.in);

        int pil;
        int pulsa;
        String namaKontak;
        String noKontak;

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
                    if (cp.getBalancePaketData() != 0) {
                        System.out.println("Paket Data Aktif : " + cp.getBalancePaketData() + " GB");
                    } else {
                        System.out.println("Anda tidak memiliki kuota saat ini.");
                    }
                    break;

                case 4:
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

                case 5:
                    // Daftar Kontak
                    cp.listContact();
                    break;

                case 6:
                    // Tambah Kontak
                    System.out.println("Tambah Kontak");
                    System.out.println("=============");

                    System.out.print("Masukan nama kontak : ");
                    namaKontak = scanner.nextLine();

                    System.out.print("Masukan no kontak : ");
                    noKontak = scanner.nextLine();

                    cp.insertContact(namaKontak, noKontak);

                    break;

                case 7:
                    // Hapus Kontak
                    System.out.println("Hapus Kontak");
                    System.out.println("=============");

                    System.out.print("Masukan nama kontak : ");
                    namaKontak = scanner.nextLine();

                    cp.deleteContact(namaKontak);
                    break;

                case 8:
                    // Phone info
                    cp.phoneInfo();

                    break;

                case 9:
                    gunakanData(scanner, cp);
                    break;

                case 10:
                    // Matikan Daya
                    cp.powerOff();

                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

        } while (pil != 10);
    }

    public static void gunakanData(Scanner input, Cellphone cp) {
        System.out.println("Pilih aktivitas penggunaan data:");
        System.out.println("1. YouTube (1.5 GB/jam)");
        System.out.println("2. Instagram (0.7 GB/jam)");
        System.out.println("3. Browsing (0.2 GB/jam)");
        System.out.println("4. Spotify (0.15 GB/jam)");
        System.out.println("5. WhatsApp (0.05 GB/jam)");
        System.out.print("Aktivitas: ");
        int aktivitas = input.nextInt();

        System.out.print("Berapa jam digunakan? ");
        double jam = input.nextDouble();

        double penggunaan = 0;
        switch (aktivitas) {
            case 1:
                penggunaan = 1.5 * jam;
                break;
            case 2:
                penggunaan = 0.7 * jam;
                break;
            case 3:
                penggunaan = 0.2 * jam;
                break;
            case 4:
                penggunaan = 0.15 * jam;
                break;
            case 5:
                penggunaan = 0.05 * jam;
                break;
            default:
                System.out.println("Aktivitas tidak valid.");
                return;
        }

        double kuota = cp.getBalancePaketData();

        if (penggunaan <= kuota) {
            kuota -= penggunaan;
            System.out.printf("Paket data terpakai %.2f GB. Sisa kuota: %.2f GB\n", penggunaan, kuota);
            cp.setBalancePaketData(kuota);
        } else {
            System.out.println("Kuota tidak cukup!");
        }
    }
}
