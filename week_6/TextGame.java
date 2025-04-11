import java.util.ArrayList;

public class TextGame {
    protected ArrayList<Character> characters = new ArrayList<>();

    public void inputText(String text) {
        characters.clear();
        for (char c : text.toCharArray()) {
            characters.add(Character.toUpperCase(c));
        }
    }

    // Overload 1 - String
    public boolean isPalindrome(String text) {
        inputText(text);
        return isPalindrome();
    }

    // Overload 2 - ArrayList
    public boolean isPalindrome(ArrayList<Character> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    // Default behavior
    public boolean isPalindrome() {
        return isPalindrome(this.characters);
    }

    public void displayResult(String word) {
        System.out.println("Kata: " + word + (isPalindrome(word) ? " adalah Palindrome" : " bukan Palindrome"));
    }
}
