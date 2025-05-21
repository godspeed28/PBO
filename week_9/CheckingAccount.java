
// package eksepsi;
import java.io.*;
import java.util.ArrayList;

public class CheckingAccount {
	private double saldo;
	private int rekening;

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

	public double getSaldo() {
		return saldo;
	}

	public int getAngka() {
		return rekening;
	}
}
