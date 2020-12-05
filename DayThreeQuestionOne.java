import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
public class DayThreeQuestionOne {
    public static void main(String[] args) throws FileNotFoundException{
        File myObj = new File("treeMap.txt");
        Scanner myReader = new Scanner(myObj);

        Character tree = '#';
        int numTrees = 0;
        ArrayList<ArrayList<Character>> treeMap = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String entry = myReader.nextLine();
            char[] line = entry.toCharArray();

            ArrayList<Character> chars = new ArrayList<Character>();
            for (char c : line) {
                chars.add(c);
            }
            treeMap.add(chars);
        }

        int numRows = treeMap.size();
        int numColumns = treeMap.get(0).size();
        for (int row = 0, col = 0; row < numRows; row=row+1, col=((col+3)%(numColumns))) {
            if ((treeMap.get(row).get(col)).equals(tree)) {
                numTrees++;
            }
        }
        System.out.println("Number of trees: " + numTrees);
        myReader.close();
    }
}