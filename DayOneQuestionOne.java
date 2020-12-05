import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
public class DayOneQuestionOne {
    public static final int sumGoal = 2020;
    public static void main(String[] args) {
        try {
            File myObj = new File("expense-report.txt");
            Scanner myReader = new Scanner(myObj);
            HashMap<Integer, Integer> diffAndNumber = new HashMap<>();
            while (myReader.hasNextLine()) {
                int data = Integer.parseInt(myReader.nextLine());
                if (diffAndNumber.containsKey(data)) {
                    System.out.println("The two numbers that sum to 2020 are: " + diffAndNumber.get(data) + " and "  + data);
                    System.out.println("Multipled they are: " + (diffAndNumber.get(data) * data));
                    return;
                } else {
                    diffAndNumber.put(sumGoal-data, data);
                }
                
            }
            System.out.println("No numbers that sum to " + sumGoal + " were found.");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
            e.printStackTrace();
        }
    }
}