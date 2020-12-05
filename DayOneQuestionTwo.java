import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class DayOneQuestionTwo {
    public static final int sumGoal = 2020;
    public static void main(String[] args) throws FileNotFoundException {
            File myObj = new File("expense-report.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Integer> expenseReport = new ArrayList<>();
            while (myReader.hasNextLine()) {
                int data = Integer.parseInt(myReader.nextLine());
                expenseReport.add(data);
            }

            for (int i = 0; i < expenseReport.size(); i++) {
                for (int j = i+1; j < expenseReport.size() -1; j++) {
                    for (int k = j+1; k < expenseReport.size() -2; k++) {
                        if (expenseReport.get(i) + expenseReport.get(j) + expenseReport.get(k) == sumGoal) {
                            System.out.println("Numbers: " + expenseReport.get(i) + " and " +expenseReport.get(j) + " and " + expenseReport.get(k));
                            System.out.println("Answer: " + (expenseReport.get(i) * expenseReport.get(j) * expenseReport.get(k))); 
                            return;
                        }
                    }
                }
            }   
            
            System.out.println("No numbers that sum to " + sumGoal + " were found.");
            myReader.close();

    
    }
}