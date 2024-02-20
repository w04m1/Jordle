public class Game {
    public Game() {}

    private int attempts;
    private boolean win;

    private void startGame() {
        // TODO: implement the logic
        while(attempts > 0) {
            attempts--;
        }
    }

    private void resetStat() {
        this.attempts = 6;
        this.win = false;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
