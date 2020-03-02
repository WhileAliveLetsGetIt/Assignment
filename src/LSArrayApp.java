//Load Shedding Application (using arrays)
//29 February
//Let's get it

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LSArrayApp {

    public static loadShedding[] getTheData() throws FileNotFoundException {

        loadShedding[] data = new loadShedding[2976]; //array of loadshedding data

        File file = new File(
                "/home/calvin/Desktop/Assignment/src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner scanner = new Scanner(file);
        int counter = 0;

        while (scanner.hasNextLine()) {

            String currentLine = scanner.nextLine();
            String[] partsOfLine = currentLine.split(" ", 2);

            String searchID = partsOfLine[0];

            partsOfLine[1] = partsOfLine[1].strip();
            String[] areasAffected = partsOfLine[1].split(",");

            data[counter] = new loadShedding(searchID, areasAffected);

            counter = counter + 1;
        }

        scanner.close();

        return data;
    }
    
    public static void main(String[] args) throws FileNotFoundException {

        loadShedding[] data = getTheData();

        int pos = 0;

        boolean found = false;
        
        if (args.length == 0) {
            while (pos < data.length) {
                System.out.println(data[pos].toString());
                pos = pos + 1;
            }
        }
        
        else {
            String searchID = args[0] + "_" + args[1] + "_" + args[2];

            while (pos < data.length) {
                if (data[pos].getId().equals(searchID)) {
                    System.out.println(data[pos].toString());
                    found = true;
                }
                pos = pos + 1;
            }

            if (found == false) {
                System.out.println("Areas not found");
            }
        }
	}    
}
