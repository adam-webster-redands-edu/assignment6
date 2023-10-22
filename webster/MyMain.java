package webster;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class MyMain {

    public static void main(String[] args) {
        File inputFile;
        Scanner fileInputScan = null;

        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                inputFile = jfc.getSelectedFile();
                fileInputScan = new Scanner(inputFile);

                int totalLinesOfCode = collectLinesOfCode(fileInputScan);

                System.out.println("Total Lines of Code: " + totalLinesOfCode);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error - This file could not be found.");
        } finally {
            if (fileInputScan != null)
                fileInputScan.close();
        }
    }

    public static int collectLinesOfCode(Scanner fileInputScan) {
        int totalLinesOfCode = 0;

        String codeLine;
        while (fileInputScan.hasNextLine()) {
            codeLine = fileInputScan.nextLine().trim();

            if (isCode(codeLine)) {
                totalLinesOfCode++;
            }
        }
        return totalLinesOfCode;
    }

    public static boolean isCode(String str) {
        return str.length() > 0;
    }
}
