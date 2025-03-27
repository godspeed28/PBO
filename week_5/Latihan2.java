public class Latihan2 {
    public static int[] hitungNilai(int a, int b) {
        int tambah = a + b;
        int kurang = a - b;
        int kali = a * b;
        int bagi = a / b;
        int modulus = a % b;
        int arr[] = { tambah, kurang, kali, bagi, modulus };
        return arr;
    }

    public static void daftarNilai() {
        int hasil[] = hitungNilai(6, 2);
        String str[] = { "Tambah", "Kurang", "Kali", "Bagi", "Modulus" };
        for (int i = 0; i < hasil.length; i++) {
            System.out.println(str[i] + " = " + hasil[i]);
        }
    }

    public static void main(String[] args) {
        daftarNilai();
    }
}