import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Word {
    private final Character[] chars;
    private final Status[] status;

    public final Integer length;

    public Word(Character[] word) {
        this.chars = word;
        this.status = new Status[word.length];
        this.length = word.length;
        this.resetStatus();
    }

    private void resetStatus() {
        Arrays.fill(this.status, Status.MISSING);
    }

    public void printStatus() {
        System.out.println(Arrays.toString(status));
    }

    public void compare(String guess) throws WrongLengthException {
        if (guess.length() != chars.length) {
            throw new WrongLengthException("Guess is longer/shorter than original word");
        }

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
}
