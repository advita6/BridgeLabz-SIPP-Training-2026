import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FeedbackAnalyzer {

    public static void main(String[] args) {
        String fileName = "feedback.txt";
        int goodCount = 0;
        int messageLimit = 5; // Limit to reading 5 feedback messages

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int linesRead = 0;

            // Read lines until the file ends OR we hit our 5-message limit
            while ((line = reader.readLine()) != null && linesRead < messageLimit) {
                // Skip empty lines so they don't count towards the 5 messages
                if (line.trim().isEmpty()) continue;

                linesRead++;

                // Convert the line to lowercase to make the search case-insensitive
                if (line.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }

            // Display the final counted result
            System.out.println("Good Feedback Count = " + goodCount);

        } catch (FileNotFoundException e) {
            System.err.println("Error: The file '" + fileName + "' was not found.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}