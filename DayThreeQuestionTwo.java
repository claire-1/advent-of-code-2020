import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
public class DayThreeQuestionTwo {
    public static int getNumTrees(ArrayList<ArrayList<Character>> treeMap, int right, int down) {
        int numTrees = 0;
        Character tree = '#';
        
        int numRows = treeMap.size();
        int numColumns = treeMap.get(0).size();
        for (int row = 0, col = 0; row < numRows; row=row+down, col=((col+right)%(numColumns))) {
            if ((treeMap.get(row).get(col)).equals(tree)) {
                numTrees++;
            }
        }

        System.out.println("Number of trees: " + numTrees);
        return numTrees;
    }
    public static void main(String[] args) throws FileNotFoundException{
        File myObj = new File("treeMap.txt");
        Scanner myReader = new Scanner(myObj);

        
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

        myReader.close();

        
        int first = getNumTrees(treeMap,1,1);
        int second = getNumTrees(treeMap,3,1);
        int third = getNumTrees(treeMap,5,1);
        int four = getNumTrees(treeMap,7,1);
        int five = getNumTrees(treeMap,1,2);

        System.out.println("multiplied " + (first * second * third * four * five));
       
    }
}