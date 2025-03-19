import java.util.Scanner;

public class Mainquiz {
  public static void main(String[] args) {
    Scanner pertanyaan = new Scanner(System.in);
    Quiz quiz = new Quiz();

    System.out.println("Selamat datang di Kuis Pengetahuan Umum!");
    System.out.println("Jawab semua pertanyaan dengan memilih nomor");

    String pil;

    do {

      for (int i = 0; i < quiz.getQuestionCount(); i++) {
        quiz.displayQuestion(i);
        System.out.print("masukan pilihan jawaban: ");
        int piljwb = pertanyaan.nextInt();
        pertanyaan.nextLine(); // Tambahkan ini untuk membersihkan newline
        quiz.checkAnswer(i, piljwb);
      }

      System.out.println("Score quiz : " + quiz.getScore());

      System.out.print("Main lagi? y/n: ");
      pil = pertanyaan.nextLine().trim();

      quiz.resetScore();

    } while (!pil.equals("n"));

    System.out.println("Terima kasih telah bermain!");
    pertanyaan.close();

  }
}