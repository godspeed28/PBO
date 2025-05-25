// package week_10.phone;

import java.util.*;
import java.lang.Math;

public class Cellphone implements Phone {
    String merk;
    String type;
    int balance;
    int pilPaketData;
    int batteryLevel;
    int status;
    int volume;
    boolean kontakKetemu = false;
    ArrayList<Contact> kontak = new ArrayList<Contact>();
    HashMap<Integer, Integer> paketData = new HashMap<>();
    HashMap<Integer, Integer> paketGb = new HashMap<>();

    public Cellphone(String merk, String type) {
        this.merk = merk;
        this.type = type;
        this.batteryLevel = (int) (Math.random() * (100 - 0 + 1) + 0);
        // this.batteryLevel = 19;
    }

    public void powerOn() {
        this.status = 1;
        System.out.println("Ponsel menyala");
    }

    public void powerOff() {
        this.status = 0;
        System.out.println("Ponsel mati");
    }

    public void volumeUp() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
        } else {
            this.volume++;
            if (this.volume >= 100) {
                this.volume = 100;
            }
        }
    }

    public void volumeDown() {
        this.volume--;
    }

    public int getVolume() {
        return this.volume;
    }

    public void getContact(String nama) {
        for (Contact contact : kontak) {
            if (contact.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Pencarian kontak " + nama + " ketemu");
                System.out.println("Nama: " + contact.getNama());
                System.out.println("Nomor: " + contact.getNomor());
                System.out.println();
                kontakKetemu = true;
            }
        }

        if (!kontakKetemu) {
            System.out.println("Kontak tidak ketemu");
        }
    }

    public void listContact() {
        int no = 0;

        if (!kontak.isEmpty()) {
             System.out.println("Daftar Kontak :");
             for (Contact contact : kontak) {
            System.out.print(++no + ". " + contact.getNama());
            System.out.println(" | " + contact.getNomor());
        }
        }else {
            System.out.println("Daftar kontak kosong.");
        }
       
    }

    public int getBattery() {
        return this.batteryLevel;
    }

    public void getBatteryLevel() {
        // System.out.println("Baterai: " + this.batteryLevel + "%");
        if (this.batteryLevel < 20) {
            System.out.println("Baterai kurang dari 20. Disarankan untuk mengisi daya");
            System.out.println("======================================================");
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public boolean kontakAda(ArrayList<Contact> kontak, String nama, String nomor) {
        for (Contact c : kontak) {
            if (c.getNama().equalsIgnoreCase(nama) && c.getNomor().equals(nomor)) {
                return true;
            }
        }
        return false;
    }

    public boolean kontakAda(ArrayList<Contact> kontak, String nama) {
        for (Contact c : kontak) {
            if (c.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public void insertContact(String nama, String nomor) {
        if (kontakAda(kontak, nama, nomor)) {
            System.out.println("Kontak sudah ada!");
        } else {
            kontak.add(new Contact(nama, nomor));
            System.out.println("Kontak dengan nama: " + nama + " dan nomor: " + nomor + " telah disimpan");
        }
    }

    public void deleteContact(String nama) {
        if (!kontakAda(kontak, nama)) {
            System.out.println("Kontak tidak ada!");
        } else {
            kontak.remove(new Contact(nama, ""));
            System.out.println("Kontak dengan nama: " + nama + " telah dihapus");
        }
    }

    public void topUpBalance(int balance) {
        this.balance += balance;
        System.out.println("Pulsa bertambah " + balance + ". Sisa pulsa: " + this.balance);
    }

    public void beliPaketData(int pilPaketData) throws InsufficientFundsException {
        paketData.put(1, 10000);
        paketData.put(2, 25000);
        paketData.put(3, 40000);
        paketData.put(4, 55000);
        paketData.put(5, 70000);

        paketGb.put(1, 1);
        paketGb.put(2, 5);
        paketGb.put(3, 10);
        paketGb.put(4, 15);
        paketGb.put(5, 20);

        if (paketData.containsKey(pilPaketData)) {
            int harga = paketData.get(pilPaketData);

            if (harga <= this.balance) {
                this.balance -= harga;
                if (paketGb.containsKey(pilPaketData)) {
                    System.out.println("Pembelian paket " + paketGb.get(pilPaketData) + " GB berhasil!");

                }
            } else {
                int kebutuhan = harga - this.balance;
                throw new InsufficientFundsException(kebutuhan);
            }
        } else {
            System.out.println("Pilihan paket tidak tersedia!");
        }

    }

    public void phoneInfo() {
        System.out.println("Merk ponsel: " + this.merk);
        System.out.println("Tipe ponsel: " + this.type);
        getBatteryLevel();
        System.out.println("Sisa pulsa: " + this.balance);
    }
}
