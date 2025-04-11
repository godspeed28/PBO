import java.util.Scanner;

// Kelas Main (program utama)
public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String play;
        do {

            System.out.print("Masukkan sebuah kata: ");
            String kata = input.next();

            TextGame game2 = new FancyTextGame();
            game2.displayResult(kata);

            System.out.print("main lagi y/n: ");
            play = input.next();

        } while (play.equalsIgnoreCase("y"));

        System.out.println("Terimakasih sudah bermain!");

        // TextGame game1 = new TextGame();
        // game1.displayResult("Malam");
        // System.out.println();

    }
}
