import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var words = new Words();
        words.setWord(5);
        var word = new Word(words.wordChar);
        var scan = new Scanner(System.in);
        System.out.println(Arrays.toString(words.wordChar));
        while (true) {
            System.out.print("Guess: ");
            var res = scan.next();
            word.compare(res);
            word.printStatus();
        }

    }
}
