import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MessageAutomation {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Random random = new Random();

        // Array of random words
        String[] words = {"Hello", "What is your level", "Really interesting","keep grinding","Have a nice day","i want a rifter",
                "wherea re you from"};

        while (true) {
            // Generate a random word
            String randomWord = words[random.nextInt(words.length)];

            // Type the random word
            typeString(robot, randomWord);

            // Press Enter to send the message
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Sleep for 1 minute (adjust as needed)
            Thread.sleep(10000);
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
