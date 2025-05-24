
// package eksepsi;
import java.io.*;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class CheckingAccount {
	private double saldo;
	private String saldoId;
	private int rekening;

	// Gunakan Locale Indonesia (bisa via Builder untuk versi terbaru)
	Locale indonesia = new Locale.Builder().setLanguage("id").setRegion("ID").build();

	// Format angka dengan pemisah ribuan titik
	NumberFormat formatRupiah = NumberFormat.getNumberInstance(indonesia);

	public CheckingAccount(int rekening) {
		this.rekening = rekening;
	}

	public void simpanUang(double jumlahsetor) {
		saldo += jumlahsetor;
	}

	public void tarikUang(double jumlahtarik) throws InsufficientFundsException {
		if (jumlahtarik <= saldo) {
			saldo -= jumlahtarik;
		} else {
			double kebutuhan = jumlahtarik - saldo;
			throw new InsufficientFundsException(kebutuhan);
		}
	}

	public String getSaldo() {
		saldoId = formatRupiah.format(saldo);
		return saldoId;
	}

	public int getAngka() {
		return rekening;
	}
}
