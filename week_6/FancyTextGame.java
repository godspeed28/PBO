class FancyTextGame extends TextGame {

    // Override pengecekan palindrome dengan tampilan animasi sederhana
    @Override
    public boolean isPalindrome() {
        System.out.print("Memeriksa kata: ");
        for (Character c : characters) {
            System.out.print(c + " ");
            try {
                Thread.sleep(200); // animasi sederhana
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
        boolean result = super.isPalindrome();
        System.out.println(result ? "-> Ini adalah palindrome!" : "-> Ini bukan palindrome.");
        return result;
    }
}
