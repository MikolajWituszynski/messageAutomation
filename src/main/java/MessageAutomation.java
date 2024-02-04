import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

public class MessageAutomation {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide max time (in milliseconds) for sending a message: ");
        String maxInput = scanner.nextLine();
        int maxTime = Integer.parseInt(maxInput);
        System.out.println("Please provide min time (in milliseconds) for sending a message: ");
        String minInput = scanner.nextLine();
        int minTime = Integer.parseInt(maxInput);
        System.out.println("Enter words separated by spaces:");

        // Read words from the user input
        String userInput = scanner.nextLine();

        // Split the input into an array of words
        String[] words = userInput.split(",");

        // Check if there are words
        if (words.length > 0) {
            while (true) {
                // Get a random word from the provided arguments
                String randomWord = words[random.nextInt(words.length)];

                // Type the random word
                typeString(robot, randomWord);

                // Press Enter to send the message
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                // Sleep for 10 seconds
                Thread.sleep((long) (Math.random()*(maxTime-minTime)+minTime));
            }
        } else {
            System.out.println("Please provide at least one word.");
        }
    }

    // Function to simulate typing a string
    private static void typeString(Robot robot, String s) {
        for (char c : s.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
}
