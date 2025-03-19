import java.util.Scanner;

public class Mainquiz {
  public static void main(String[] args) {
    Scanner pertanyaan = new Scanner(System.in);
    // Scanner jwb = new Scanner(System.in);
    System.out.println("Enter username");
    Quiz quiz = new Quiz();

    System.out.println("Selamat datang di Kuis Pengetahuan Umum!");
    System.out.println("Jawab semua pertanyaan dengan memilih nomor");

    for (int i = 0; i < quiz.getQuestionCount(); i++) {
      quiz.displayQuestion(i);
    }

    System.out.println("masukan pilihan pertanyaan: ");
    int pilpertanyaan = pertanyaan.nextInt();

    System.out.println("masukan pilihan jawaban: ");
    int piljwb = pertanyaan.nextInt();

    quiz.checkAnswer(pilpertanyaan - 1, piljwb);

    System.err.println(pilpertanyaan);

    // if(pil == 1){
    // System.out.println("benar");
    // }else{
    // System.out.println("jawaban salah!");
    // }

    // System.out.println(quiz.getScore());

  }
}