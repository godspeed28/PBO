
public class Quiz {
    public String[] questions = {
            "Ibu kota Indonesia adalah?",
            "Hewan apa yang paling pendiam?",
            "Planet terbesar di tata surya?",
            "Siapa penemu bola lampu?",
            "Gunung tertinggi di dunia?",
            "Negara dengan populasi terbanyak?",
            "Siapa presiden pertama Indonesia?",
            "Berapa hasil dari 5 × 6?",
            "Lagu kebangsaan Indonesia adalah?",
            "Sungai terpanjang di dunia?"
    };

    private String[][] options = {
            { "1. Jakarta", "2. Bandung", "3. Surabaya", "4. Bali" },
            { "1. Harimau", "2. Semut", "3. Gajah", "4. Kucing" },
            { "1. Mars", "2. Bumi", "3. Jupiter", "4. Saturnus" },
            { "1. Albert Einstein", "2. Thomas Edison", "3. Nikola Tesla", "4. Alexander Graham Bell" },
            { "1. Kilimanjaro", "2. Everest", "3. Elbrus", "4. Fuji" },
            { "1. Indonesia", "2. Amerika Serikat", "3. India", "4. Cina" },
            { "1. Soeharto", "2. Soekarno", "3. Habibie", "4. Gus Dur" },
            { "1. 25", "2. 30", "3. 35", "4. 40" },
            { "1. Indonesia Raya", "2. Tanah Airku", "3. Garuda Pancasila", "4. Bagimu Negeri" },
            { "1. Amazon", "2. Nil", "3. Mississippi", "4. Yangtze" }
    };

    // private int[] correctAnswers = { 1, 2, 3 };
    private int score = 0;

    public int resetScore() {
        return score = 0;
    }

    public int getQuestionCount() {
        return questions.length;
    }

    public void displayQuestion(int index) {
        System.out.println("\nPertanyaan " + (index + 1) + ": " + questions[index]);
        for (int j = 0; j < options[index].length; j++) {
            System.out.println(options[index][j]);
        }
    }

    public int kunciJawaban(int pertanyaan, int userAnswer) {
        if (pertanyaan == 0) {
            if (userAnswer == 1) {
                return userAnswer - 1;
            } else {
                return 0;
            }
        }
        if (pertanyaan == 1) {
            if (userAnswer == 2) {
                return userAnswer - 1;
            } else {
                return 1;
            }
        }
        if (pertanyaan == 2) {
            if (userAnswer == 3) {
                return userAnswer - 1;
            } else {
                return 2;
            }
        }
        if (pertanyaan == 3) {
            if (userAnswer == 2) {
                return userAnswer - 1;
            } else {
                return 1;
            }
        }
        if (pertanyaan == 4) {
            if (userAnswer == 2) {
                return userAnswer - 1;
            } else {
                return 1;
            }
        }
        if (pertanyaan == 5) {
            if (userAnswer == 3) {
                return userAnswer - 1;
            } else {
                return 2;
            }
        }
        if (pertanyaan == 6) {
            if (userAnswer == 2) {
                return userAnswer - 1;
            } else {
                return 1;
            }
        }
        if (pertanyaan == 7) {
            if (userAnswer == 2) {
                return userAnswer - 1;
            } else {
                return 1;
            }
        }
        if (pertanyaan == 8) {
            if (userAnswer == 1) {
                return userAnswer - 1;
            } else {
                return 0;
            }
        }
        if (pertanyaan == 9) {
            if (userAnswer == 2) {
                return userAnswer - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }

    public void checkAnswer(int p, int j) {

        int index = kunciJawaban(p, j);
        if (j - 1 == index) {
            System.out.println("Benar!");
            score += 10;
        } else {
            System.out.println("Salah! Jawaban yang benar adalah: " +
                    options[p][index]);
        }
    }

    // Method untuk mendapatkan skor
    public int getScore() {
        return score;
    }
}