// package eksepsi;

import java.util.Scanner;

public class Bank {
	public static void display() {
		System.err.println("Pilih aksi:");
		System.err.print(
				"1. Simpan Uang\n" + "2. Tarik Uang\n" + "3. Lihat Saldo\n" + "4. Keluar\n");
	}

	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount(101);
		Scanner scanner = new Scanner(System.in);

		int pil;
		double jumlahUang;

		System.out.println("Menu Bank");
		do {
			display();
			System.out.print("> ");
			pil = scanner.nextInt();
			scanner.nextLine();

			switch (pil) {
				case 1:

					System.err.println("Saldo anda saat ini = " + ca.getSaldo());
					System.out.print("Masukan nominal uang yang ingin disimpan = ");

					jumlahUang = scanner.nextInt();
					scanner.nextLine();

					ca.simpanUang(jumlahUang);

					System.err.println("Berhasil!");
					System.err.println("Saldo anda saat ini = " + ca.getSaldo());

					break;

				case 2:
					System.err.println("Saldo anda saat ini = " + ca.getSaldo());
					System.out.print("Masukan nominal uang yang ingin ditarik = ");

					jumlahUang = scanner.nextInt();
					scanner.nextLine();

					try {
						System.err.println("Berhasil!");
						System.out.println("\nTarik Uang Rp " + jumlahUang);
						ca.tarikUang(jumlahUang);
					} catch (InsufficientFundsException e) {
						System.out.println("Maaf saldo yang akan Anda ambil kurang Rp " + e.getAmount()
								+ " dari total permintaan Anda");
						// e.printStackTrace();
					}

					break;

				case 3:
					System.err.println("Saldo anda saat ini = " + ca.getSaldo());
					break;

				default:
					break;
			}

		} while (pil != 4);
	}

}
