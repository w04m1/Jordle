public class Word {
    private final Character[] chars;
    private Status[] status;

    public Word(Character[] word) {
        this.chars = word;
        this.status = new Status[word.length];
    }

    public void compare(String guess) {
        for (int i = 0; i < chars.length; i++) {
            Character temp = guess.charAt(i);
            if (temp == chars[i]) {
                status[i] = Status.CORRECT;
                continue;
            }

        }
    }
}
