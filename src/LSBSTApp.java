//Load Shedding Application (using binary search trees)
//29 February
//Let's get it

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

//import org.graalvm.compiler.graph.spi.Canonicalizable.Binary;

import java.io.FileNotFoundException;

public class LSBSTApp {
    public static BinarySearchTree<loadShedding> getData() throws FileNotFoundException {

        BinarySearchTree<loadShedding> data = new BinarySearchTree<loadShedding>(); //array of loadshedding data

        File file = new File(
                "/home/calvin/Desktop/Assignment/src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String currentLine = scanner.nextLine();
            String[] partsOfLine = currentLine.split(" ", 2);

            String searchID = partsOfLine[0];

            partsOfLine[1] = partsOfLine[1].strip();
            String[] areasAffected = partsOfLine[1].split(",");

            data.add(new loadShedding(searchID, areasAffected));
        }

        scanner.close();

        return data;
    }

    public static void main(String[] args) throws FileNotFoundException {

        BinarySearchTree<loadShedding> data = getData();
        
        if (args.length == 0) {
            Iterator<loadShedding> iterate = data.iterator();
            while (iterate.hasNext()) {
                System.out.println(iterate.next().toString());
            }
        }
        
        else {
            String searchID = args[0] + "_" + args[1] + "_" + args[2];
            loadShedding searchItem = new loadShedding(searchID, null);
            loadShedding result = data.get(searchItem);
            if (result == null) {
                System.out.println("Areas not found");
            }
            else {
                System.out.println(result.toString());
            }
        }
	} 
}
