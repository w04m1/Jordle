import java.util.ResourceBundle;

public class Renderer {
    private final ResourceBundle messages;

    public Renderer () {
        this.messages = ResourceBundle.getBundle("resources/messages");
    }

    public void sendWelcomeMessage() {
        System.out.println(messages.getString("welcomeMessage"));
    }

    public void sendGuessMessage() {
        System.out.print(messages.getString("guessMessage"));
    }

    public void sendContinueMessage() {
        System.out.print(messages.getString("continueMessage"));
    }

    public void sendByeMessage() {
        System.out.println(messages.getString("byeMessage"));
    }

    public void sendErrorMessage(int wordLength) {
        System.out.printf(messages.getString("errorMessage")+ "\n", wordLength);
    }

    public void sendInvalidInputMessage() {
        System.out.print(messages.getString("invalidInputMessage"));
    }

    public void displayEndGameMessage(boolean win) {
        System.out.println(messages.getString(win ? "winMessage": "loseMessage"));
    }

    public void drawGuess(char[] chars, Status[] statuses) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            builder.append(statuses[i])
                    .append(chars[i])
                    .append("\u001B[0m")    // reset style code
                    .append(" ");
        }
        System.out.println(builder);
    }
}
