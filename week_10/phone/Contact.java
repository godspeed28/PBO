// package week_10.phone;

public class Contact {
    String nama;
    String nomor;

    public Contact(String nama, String nomor) {
        this.nama = nama;
        this.nomor = nomor;
    }

    String getNama() {
        return this.nama;
    }

    String getNomor() {
        return this.nomor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Contact contact = (Contact) obj;
        return nama != null && nama.equalsIgnoreCase(contact.nama);
    }

}
