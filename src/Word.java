import java.util.Arrays;

public class Word {
    private final Character[] chars;
    private Status[] status;

    public Word(Character[] word) {
        this.chars = word;
        this.status = new Status[word.length];
        this.resetStatus();
    }

    private void resetStatus() {
        Arrays.fill(this.status, Status.MISSING);
    }

    public void printStatus() {
        System.out.println(Arrays.toString(status));
    }

    public void compare(String guess) {
        this.resetStatus();
        for (int i = 0; i < chars.length; i++) {
            Character temp = guess.charAt(i);
            if (temp == chars[i]) {
                status[i] = Status.CORRECT;
                continue;
            }
            Boolean in = false;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != temp) {continue;}
                if (status[j] == Status.MISSING) {
                    status[j] = Status.WRONGPOS;
                    break;
                }
                status[j] = Status.MISSING;
            }

        }
    }
}
