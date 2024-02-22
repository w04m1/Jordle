import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Word {
    private char[] chars;
    private final Status[] status;
    public final int length;
    private final Words words = new Words();

    public Word(int length) {
        this.length = length;
        this.status = new Status[this.length];
        this.changeWord();
    }

    public void changeWord() {
        this.chars = words.getWord(this.length);
        this.resetStatus();
    }

    private void resetStatus() {
        Arrays.fill(this.status, Status.MISSING);
    }

    public void compare(String guess) throws WrongLengthException {
        if (guess.length() != chars.length) {
            throw new WrongLengthException("Guess is longer/shorter than original word");
        }

        guess = guess.toLowerCase();
        this.resetStatus();
        Map<Character, Integer> charCount = new HashMap<>();

        for (Character c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            char temp = guess.charAt(i);
            if (temp == chars[i]) {
                status[i] = Status.CORRECT;
                charCount.put(temp, charCount.get(temp) - 1);
            } else if (charCount.getOrDefault(temp, 0) > 0) {
                status[i] = Status.WRONGPOS;
                charCount.put(temp, charCount.get(temp) - 1);
            } else {
                status[i] = Status.MISSING;
            }
        }
    }

    public Status[] getStatus() {
        return status;
    }

    public char[] getChars() {
        return chars;
    }
}
