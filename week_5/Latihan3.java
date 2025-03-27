import java.util.Arrays;

public class Latihan3 {

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // Loop sebanyak jumlah elemen
            for (int j = 0; j < n - i - 1; j++) { // Loop untuk membandingkan elemen bersebelahan
                if (arr[j] > arr[j + 1]) { // Jika elemen kiri lebih besar dari kanan, tukar
                    swap(arr, j, j + 1);
                    printArray(arr); // Cetak array setelah pertukaran
                }
            }
        }
    }

    // Quick Sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Tentukan pivot
            printArray(arr);
            quickSort(arr, low, pi - 1); // Urutkan bagian kiri
            quickSort(arr, pi + 1, high); // Urutkan bagian kanan
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot diambil dari elemen terakhir
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // Jika elemen lebih kecil dari pivot, tukar posisinya
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Letakkan pivot di posisi akhirnya
        return i + 1;
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { // Geser elemen ke kanan
                arr[j + 1] = arr[j];
                j--;
                printArray(arr);
            }
            arr[j + 1] = key; // Masukkan elemen pada posisi yang benar
            printArray(arr);
        }
    }

    // Selection Sort
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) { // Cari nilai terkecil
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx); // Tukar elemen terkecil ke posisi yang sesuai
            printArray(arr);
        }
    }

    // Merge Sort
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); // Urutkan bagian kiri
            mergeSort(arr, mid + 1, right); // Urutkan bagian kanan
            merge(arr, left, mid, right); // Gabungkan hasilnya
            printArray(arr);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1]; // Array sementara untuk kiri
        int[] R = new int[n2]; // Array sementara untuk kanan
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    // Utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Print array at each step
    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] data = { 7, 1, 3, 5, 2 };

        System.out.println("Bubble Sort:");
        bubbleSort(data.clone());

        System.out.println("\nQuick Sort:");
        quickSort(data.clone(), 0, data.length - 1);

        System.out.println("\nInsertion Sort:");
        insertionSort(data.clone());

        System.out.println("\nSelection Sort:");
        selectionSort(data.clone());

        System.out.println("\nMerge Sort:");
        mergeSort(data.clone(), 0, data.length - 1);
    }
}
