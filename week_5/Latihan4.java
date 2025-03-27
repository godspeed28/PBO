import java.util.Scanner;

public class Latihan4 {

    public static void transposeMatrix2x2(int[][] newMatrix, String name) {
        int temp = newMatrix[0][1];
        int count = 0;
        newMatrix[0][1] = newMatrix[1][0];
        newMatrix[1][0] = temp;

        System.out.println("\nHasil transpose Matrix " + name + " : ");

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                count++;
                if (count == 1) {
                    System.out.print("[");
                }
                if (count == newMatrix[0].length) {
                    System.out.print(newMatrix[i][j] + "]");
                    System.err.println();
                }
                if (count != newMatrix[0].length) {

                    System.out.print(newMatrix[i][j] + ", ");
                }
            }
            count = 0;
        }

    }

    public static int[][] sumMatrix(int[][] x, int[][] y, String nameM1, String nameM2) {
        int count = 0;
        int[][] matrix = new int[x.length][y[0].length];
        System.out.println("\nHasil penjumlahan Matrix " + nameM1 + " dan " + nameM2 + ": ");
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                count++;
                if (count == 1) {
                    System.out.print("[");
                }
                if (count == y[0].length) {
                    matrix[i][j] = x[i][j] + y[i][j];
                    System.out.print(x[i][j] + y[i][j] + "]");
                    System.err.println();
                }
                if (count != y[0].length) {
                    matrix[i][j] = x[i][j] + y[i][j];
                    System.out.print(x[i][j] + y[i][j] + ", ");
                }
            }
            count = 0;
        }
        return matrix;
    }

    public static int[][] multiplicationMatrix(int[][] x, int[][] y) {
        int barisA = x.length;
        int kolomA = x[0].length;
        int kolomB = y[0].length;

        // Matriks hasil dengan ukuran [barisA][kolomB]
        int result[][] = new int[barisA][kolomB];

        // Perkalian matriks menggunakan dot product
        for (int i = 0; i < barisA; i++) { // Looping baris A
            for (int j = 0; j < kolomB; j++) { // Looping kolom B
                result[i][j] = 0; // Inisialisasi nilai awal
                for (int k = 0; k < kolomA; k++) { // Loop untuk dot product
                    result[i][j] += x[i][k] * y[k][j]; // Perkalian elemen
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix, String name) {
        int count = 0;
        System.out.println("\nMatrix " + name + " : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count++;
                if (count == 1) {
                    System.out.print("[");
                }
                if (count == matrix[0].length) {
                    System.out.print(matrix[i][j] + "]");
                    System.err.println();
                }
                if (count != matrix[0].length) {
                    System.out.print(matrix[i][j] + ", ");
                }
            }
            count = 0;
        }
    }

    public static int[][] addMatrix(int baris, int kolom, String name) {
        Scanner input = new Scanner(System.in);
        int matrix[][] = new int[baris][kolom];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Masukkan elemen Matrix " + name + " [" + i + "," + j + "] = ");
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris Matrix A = ");
        int baris = input.nextInt();
        System.out.print("Masukkan jumlah kolom Matrix A = ");
        int kolom = input.nextInt();

        int[][] matrixA = addMatrix(baris, kolom, "A");

        System.out.print("Masukkan jumlah baris Matrix B = ");
        baris = input.nextInt();
        System.out.print("Masukkan jumlah kolom Matrix B = ");
        kolom = input.nextInt();

        int[][] matrixB = addMatrix(baris, kolom, "B");

        printMatrix(matrixA, "A");
        printMatrix(matrixB, "B");
        sumMatrix(matrixA, matrixB, "A", "B");

        int[][] matrix = sumMatrix(matrixA, matrixB, "A", "B");
        transposeMatrix2x2(matrix, "C");

        int[][] kaliMatrix = multiplicationMatrix(matrixA, matrixB);

        System.out.println("Hasil Perkalian Matrix A dan B");
        printMatrix(kaliMatrix, "C");

    }
}
