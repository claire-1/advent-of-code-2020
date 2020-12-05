import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
public class DayTwoQuestionOne {
    public static final int sumGoal = 2020;
    public static void main(String[] args) throws FileNotFoundException{
        File myObj = new File("passwordPolicies.txt");
        Scanner myReader = new Scanner(myObj);

        int validCount = 0;
        while (myReader.hasNextLine()) {
            String entry = myReader.nextLine();
            String[] splited = entry.split("\\s+");
            int minTimes = Integer.parseInt(splited[0].split("-")[0]);
            int maxTimes = Integer.parseInt(splited[0].split("-")[1]);
            char letter = (splited[1]).charAt(0);
            char[] password = splited[2].toCharArray();

            int numLetterOcc = 0;
            for (char currLetter : password) {
                if (currLetter == letter) {
                    numLetterOcc++;
                }

                if (numLetterOcc > maxTimes) {
                    break;
                }
            }

            if (!(numLetterOcc > maxTimes || numLetterOcc < minTimes)) {
                validCount++;
            }
            

            
        }
        System.out.println("Number valid: " + validCount);
        myReader.close();
    }
}