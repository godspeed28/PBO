public class Latihan1 {

    static void loopArray(int arr[]) {
        System.out.println("Jumlah Data : " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Data ke - " + (1 + i) + " = " + arr[i]);
        }
        int j = 0;
        while (j < arr.length) {
            System.out.println("Hasil dari nilai[" + j + "] = " + arr[j]);
            j++;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 68, 7, 28, 90, 32 };
        loopArray(arr);
    }
}
