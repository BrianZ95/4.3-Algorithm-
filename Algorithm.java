import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithm {
    public static void main(String[] args) {
        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);

            // Variables for statistics
            int twoLetterWords = 0;
            int longestWordLength = 0;
            int longestWordCount = 0;
            int palindromes = 0;

            // Process file
            while (scanner.hasNext()) {
                String word = scanner.next();
                int length = word.length();

                // Check for two-letter words
                if (length == 2) {
                    twoLetterWords++;
                }

                // Check for longest word
                if (length > longestWordLength) {
                    longestWordLength = length;
                    longestWordCount = 1; // Reset count for new longest word
                } else if (length == longestWordLength) {
                    longestWordCount++;
                }

                // Check for palindrome
                if (isPalindrome(word)) {
                    palindromes++;
                }
            }
            scanner.close();

            // Print results
            System.out.println("Two-letter words: " + twoLetterWords);
            System.out.println("Longest word length: " + longestWordLength);
            System.out.println("Number of words tied for longest: " + longestWordCount);
            System.out.println("Palindromes: " + palindromes);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Helper function to check if a word is a palindrome
    private static boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
