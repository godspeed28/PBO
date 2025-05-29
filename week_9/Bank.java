// package eksepsi;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Bank {
	public static void display() {
		System.err.println("Pilih aksi:");
		System.err.print(
				"1. Simpan Uang\n" + "2. Tarik Uang\n" + "3. Lihat Saldo\n" + "4. Keluar\n");
	}

	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount(101);
		Scanner scanner = new Scanner(System.in);
		// Gunakan Locale Indonesia (bisa via Builder untuk versi terbaru)
		Locale indonesia = new Locale.Builder().setLanguage("id").setRegion("ID").build();

		// Format angka dengan pemisah ribuan titik
		NumberFormat formatRupiah = NumberFormat.getNumberInstance(indonesia);

		int pil;
		double jumlahUang;
		String tarikUang;

		System.out.println("Menu Bank");
		System.out.println("Minimal penarikan: Rp20.000");
		do {
			display();
			System.out.print("> ");
			pil = scanner.nextInt();
			scanner.nextLine();

			switch (pil) {
				case 1:

					System.err.println("Saldo anda saat ini = " + ca.getSaldo());
					System.out.print("Masukan nominal uang yang ingin disimpan = Rp");

					jumlahUang = scanner.nextInt();
					scanner.nextLine();

					ca.simpanUang(jumlahUang);

					System.err.println("Berhasil!");
					System.err.println("Saldo anda saat ini = Rp" + ca.getSaldo());

					break;

				case 2:
					System.err.println("Saldo anda saat ini = Rp" + ca.getSaldo());
					System.out.print("Masukan nominal uang yang ingin ditarik = Rp");

					jumlahUang = scanner.nextInt();
					scanner.nextLine();

					tarikUang = formatRupiah.format(jumlahUang);

					boolean valid = false;

					// Pastikan jumlahUang minimal 20000
					if (jumlahUang >= 20000) {
						for (int a = 0; a <= jumlahUang; a += 20000) {
							for (int b = 0; b <= jumlahUang; b += 50000) {
								for (int c = 0; c <= jumlahUang; c += 100000) {
									int total = a + b + c;

									if (total == jumlahUang) {
										System.out.println("Kombinasi:");
										System.out.println("20.000: " + a);
										System.out.println("50.000: " + b);
										System.out.println("100.000: " + c);
										System.out.println("----------------------");
										valid = true;
										break;
									}
								}
								if (valid)
									break;
							}
							if (valid)
								break;
						}
					}

					if (valid) {
						try {
							System.out.println("\nTarik Uang Rp" + tarikUang + " Berhasil!");
							ca.tarikUang(jumlahUang);
						} catch (InsufficientFundsException e) {
							System.out.println(
									"Maaf saldo yang akan Anda ambil kurang Rp " + formatRupiah.format(e.getAmount())
											+ " dari total permintaan Anda");
							// e.printStackTrace();
						}
					} else {
						System.out.println("Penarikan gagal!");
						break;
					}

					break;

				case 3:
					System.err.println("Saldo anda saat ini = Rp" + ca.getSaldo());
					break;

				default:
					break;
			}

		} while (pil != 4);
	}

}
