import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Karandeep Singh Grewal - kgrewal2
 */
public class CSVBuffer43Reusable {
    public String[] headerArray;
    public int totalColumns;
    public List<String[]> data;

    public void loadFile(String filepath) throws FileNotFoundException {
        data = getData(filepath);
        headerArray = getHeader(filepath);
        totalColumns = getTotalColumns(filepath);
    }

    private String[] getHeader(String filepath) throws FileNotFoundException {
        String[] headerRow = null;
        Scanner scanner = new Scanner(new File(filepath));
        if (scanner.hasNext()) {
            headerRow = scanner.nextLine().split(",");
        }
        return headerRow;
    }

    private int getTotalColumns(String filepath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filepath));
        return scanner.nextLine().split(",").length;
    }

    // Data won't include the header row
    private List<String[]> getData(String filePath) throws FileNotFoundException {
        List<String[]> csvData;
        Scanner scanner = new Scanner(new File(filePath));
        csvData = new ArrayList<>();
        scanner.nextLine();    // Skip Header Row
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            if (nextLine.equals("")) {
                continue; // Ignore empty csv rows
            }
            if (nextLine.charAt(nextLine.length() - 1) == ',') {
                nextLine += " "; // Add space as last cell value for csv rows ending with comma
            }
            String[] rowData = nextLine.split(",");
            if (rowData.length == getTotalColumns(filePath)) {
                csvData.add(rowData);
            }
        }
        return csvData;
    }
}
