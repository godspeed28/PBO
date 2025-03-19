
public class Quiz {
    public String[] questions = {
            "Ibu kota Indonesia adalah?",
            "Hewan apa yang paling pendiam?",
            "Planet terbesar di tata surya?"
    };

    private String[][] options = {
            { "1. Jakarta", "2. Bandung", "3. Surabaya", "4. Bali" },
            { "1. Harimau", "2. Semute", "3. Gajah", "4. Kucing" },
            { "1. Mars", "2. Bumi", "3. Jupiter", "4. Saturnus" }
    };

    private int[] correctAnswers = { 1, 2, 3 };
    private int score = 0;

    public int getQuestionCount() {
        return questions.length;
    }

    public void displayQuestion(int index) {
        System.out.println("\nPertanyaan " + (index + 1) + ": " + questions[index]);
        for (int j = 0; j < options[index].length; j++) {
            System.out.println(options[index][j]);
        }
    }

    public void checkAnswer(int index, int userAnswer) {
        if (userAnswer == correctAnswers[index]) {
            System.out.println("Benar!");
            score += 10;
        } else {
            System.out.println("Salah! Jawaban yang benar adalah: " +
                    options[index][correctAnswers[index] - 1]);
        }
    }

    // Method untuk mendapatkan skor
    public int getScore() {
        return score;
    }
}