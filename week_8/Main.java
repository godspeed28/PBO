// import BangunDatar;

import java.util.Scanner;

public class Main {
    public static void display() {
        System.err.println("Pilih aksi:");
        System.err.print(
                "1. Persegi\n" + "2. Persegi Panjang\n" + "3. Segitiga\n" + "4. Lingkaran\n" + "5. Keluar\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pil;
        String pil2 = "y";
        String stat = "selesai";
        int angka;
        int angka2;

        double dangka;
        double dangka2;

        System.out.println("Menghitung Luas Bangun Datar");

        do {
            display();
            System.out.print("> ");
            pil = scanner.nextInt();
            scanner.nextLine();

            switch (pil) {

                case 1:
                    System.out.println("Menghitung Luas Persegi");
                    System.out.print("Masukan Sisi = ");

                    angka = scanner.nextInt();
                    scanner.nextLine();

                    BangunDatar persegi = new BangunDatar(angka);
                    persegi.luas(persegi);

                    System.out.print("Luas Persegi = ");
                    persegi.getLuas();

                    stat = "hitung";

                    break;

                case 2:
                    System.out.println("Menghitung Luas Persegi Panjang");
                    System.out.print("Masukan Panjang = ");

                    angka = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukan Lebar = ");

                    angka2 = scanner.nextInt();
                    scanner.nextLine();

                    BangunDatar persegiPanjang = new BangunDatar(angka, angka2);
                    persegiPanjang.luas(persegiPanjang);

                    System.out.print("Luas Persegi Panjang = ");
                    persegiPanjang.getLuas();

                    stat = "hitung";

                    break;

                case 3:
                    System.out.println("Menghitung Luas Segitiga");
                    System.out.print("Masukan Alas = ");

                    dangka = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Masukan Tinggi = ");

                    dangka2 = scanner.nextDouble();
                    scanner.nextLine();

                    BangunDatar segitiga = new BangunDatar(dangka, dangka2, "triangle");
                    segitiga.luas(segitiga);

                    System.out.print("Luas Segitiga = ");
                    segitiga.getLuas2();

                    stat = "hitung";

                    break;

                case 4:
                    System.out.println("Menghitung Luas Lingkaran");
                    System.out.print("Masukan Jari-Jari = ");

                    dangka = scanner.nextDouble();
                    scanner.nextLine();

                    BangunDatar lingkaran = new BangunDatar(dangka, "circle");
                    lingkaran.luas(lingkaran);

                    System.out.print("Luas lingkaran = ");
                    lingkaran.getLuas2();

                    stat = "hitung";

                    break;

                case 5: // Keluar
                    System.out.println("Keluar...");
                    stat = "selesai";
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }

            if (!stat.equals("selesai")) {
                System.out.print("Hitung lagi? (y/n): ");
                pil2 = scanner.nextLine();
            }

        } while (pil != 5 && !pil2.equalsIgnoreCase("n"));

        if (pil2.equals("n")) {
            System.out.println("Keluar...");
        }

    }
}
