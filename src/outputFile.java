import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class outputFile {
    private static String filename;
    static Scanner scan = new Scanner(System.in);

    public static void createFile() {
        try {
            System.out.println("Masukkan nama file: ");
            filename = scan.nextLine();
            File solution = new File("test\\" + filename);
            while (!solution.createNewFile()) {
                System.out.println("Nama file yang kamu inginkan sudah ada!");
                System.out.println("Coba masukkan nama file yang lain: ");
                filename = scan.nextLine();
                solution = new File("test/" + filename);
            }
            System.out.println("File created: " + solution.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solutionFile(Set<String> solutionFormula, Integer numOfSol, ArrayList<Integer> cards) {
        try {
            createFile();
            FileWriter writer = new FileWriter("test/" + filename);
            writer.write("SOLUSI DARI 24 GAME SOLVER \n");
            writer.write(
                    "Masukan : " + cards.get(0) + " " + cards.get(1) + " " + cards.get(2) + " " + cards.get(3) + "\n");
            writer.write(numOfSol + " solutions found" + "\n");
            for (String f : solutionFormula) {

                writer.write(f + "\n");

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
