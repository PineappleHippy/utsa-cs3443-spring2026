import application.letter.FormLetterBatch;
import java.util.Scanner;

public class Driver {

    // Set to true for quick testing, false for user interactive mode
    private static final boolean TESTING = true;

    public static void main(String[] args) throws Exception {
        FormLetterBatch batch = new FormLetterBatch();

        // Internal test program
        if (TESTING) {
            batch.generateAll("template.txt", "input", "output");
        } 
        
        // User interface
        else {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter template file name: ");
            String templatePath = scanner.nextLine();

            System.out.print("Enter input directory name: ");
            String inDirName = scanner.nextLine();

            System.out.print("Enter output directory name: ");
            String outDirName = scanner.nextLine();

            scanner.close();

            batch.generateAll(templatePath, inDirName, outDirName);
            System.out.println("Alrighty! Letters written to: " + outDirName);
        }
    }
}