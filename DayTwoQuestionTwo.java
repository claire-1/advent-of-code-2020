import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
public class DayTwoQuestionTwo {
    public static final int sumGoal = 2020;
    public static void main(String[] args) throws FileNotFoundException{
        File myObj = new File("passwordPolicies.txt");
        Scanner myReader = new Scanner(myObj);

        int validCount = 0;
        while (myReader.hasNextLine()) {
            String entry = myReader.nextLine();
            String[] splited = entry.split("\\s+");
            int firstOcc = Integer.parseInt(splited[0].split("-")[0]);
            int secondOcc = Integer.parseInt(splited[0].split("-")[1]);
            char letter = (splited[1]).charAt(0);
            String password = splited[2];

            if (!((password.charAt(firstOcc-1) == letter && password.charAt(secondOcc-1) == letter)
                || (password.charAt(firstOcc-1) != letter && password.charAt(secondOcc-1) != letter))) {
                validCount++;
            }
            
        }
        System.out.println("Number valid: " + validCount);
        myReader.close();
    }
}