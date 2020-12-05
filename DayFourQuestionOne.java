import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
public class DayFourQuestionOne {
    public static void main(String[] args) throws FileNotFoundException{
        File myObj = new File("passports.txt");
        Scanner myReader = new Scanner(myObj);

        int numValid = 0;
        HashMap<String, String> passport = new HashMap<>();
        Set<String> keys = Set.of("byr","iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        while (myReader.hasNextLine()) {
            String passportRow = myReader.nextLine();

            if (passportRow.isBlank()) {
                if (passport.keySet().containsAll(keys)) {
                    numValid++;
                }
                passport.clear();

            } else {
                String[] fields = passportRow.split("\\s+");
                for (String field : fields) {
                    String[] fieldParts = field.split(":");
                    passport.put(fieldParts[0], fieldParts[1]);
                }
            }            
        }

        System.out.println("Number of valid passports: " + numValid);
        myReader.close();
    }
}