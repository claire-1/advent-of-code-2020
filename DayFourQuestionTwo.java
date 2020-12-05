import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
public class DayFourQuestionTwo {
    public static void main(String[] args) throws FileNotFoundException{
        File myObj = new File("passports.txt");
        Scanner myReader = new Scanner(myObj);

        int numValid = 0;
        HashMap<String, String> passport = new HashMap<>();
        Set<String> keys = Set.of("byr","iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        // Pattern hclPattern = Pattern.compile("[a-z]");
        // Matcher m = p.matcher(inputstring);
        // if (m.find())


        while (myReader.hasNextLine()) {
            String passportRow = myReader.nextLine();

            if (passportRow.isBlank()) {
                if (passport.keySet().containsAll(keys) 
                    && Integer.parseInt(passport.get("byr")) >= 1920 && Integer.parseInt(passport.get("byr")) <= 2002
                    && Integer.parseInt(passport.get("iyr")) >= 2010 && Integer.parseInt(passport.get("iyr")) <=2020
                    && Integer.parseInt(passport.get("eyr")) >= 2020 && Integer.parseInt(passport.get("eyr")) <=2030
                    && ((passport.get("hgt").substring(passport.get("hgt").length()-2).equals("cm") 
                            && Integer.parseInt(passport.get("hgt").substring(0, passport.get("hgt").length()-2)) >= 150 
                            && Integer.parseInt(passport.get("hgt").substring(0, passport.get("hgt").length()-2)) <= 193)
                        || (passport.get("hgt").substring(passport.get("hgt").length()-2).equals("in") 
                            && Integer.parseInt(passport.get("hgt").substring(0, passport.get("hgt").length()-2)) >= 59 
                            && Integer.parseInt(passport.get("hgt").substring(0, passport.get("hgt").length()-2)) <= 76)
                    )
                    && passport.get("hcl").matches("#[0-9a-f][0-9a-f][0-9a-f][0-9a-f][0-9a-f][0-9a-f]")
                    && (passport.get("ecl").equals("amb") || passport.get("ecl").equals("blu") || passport.get("ecl").equals("brn")
                    || passport.get("ecl").equals("gry") || passport.get("ecl").equals("grn") || passport.get("ecl").equals("hzl")
                    || passport.get("ecl").equals("oth"))
                    && passport.get("pid").matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")
                    ) {
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