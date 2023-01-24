import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Main extends App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Selamat datang di 24 game solver!");

        Boolean start = true;
        while (start) {
            System.out.println("Silahkan memilih jenis input yang akan kamu masukkan:");
            System.out.println("1. Generate input dari user");
            System.out.println("2. Generate input secara acak");
            System.out.print("Pilihan anda (1/2): ");
            String choice = scan.nextLine();
            while ((!choice.equals("1") && !choice.equals("2"))) {
                System.out.println("Masukan salah!");
                System.out.print("Pilihan anda (1/2): ");
                choice = scan.nextLine();
            }
            ArrayList<Integer> cards = new ArrayList<>();
            String input;
            int num;
            int numOfCards = 0;
            int numOfSpaces = 0;
            int numOfSolutions = 0;
            Boolean incorrect;
            String currCard = "";
            incorrect = false;
            if (choice.equals("1")) {
                do {
                    System.out.println("Masukkan input dengan contoh format sebagai berikut: A 8 9 Q");
                    input = scan.nextLine();
                    numOfSpaces = 0;

                    for (char curr : input.toCharArray()) {
                        if (numOfSpaces > 3) {
                            System.out.println(numOfSpaces);
                            incorrect = true;
                            System.out.println(3);
                            cards = new ArrayList<>();
                            break;
                        }
                        if (curr == ' ') {
                            numOfSpaces++;
                            if ((currCard.equals("A")) || (currCard.equals("2")) || currCard.equals("3")
                                    || currCard.equals("4")
                                    || currCard.equals("5")
                                    || currCard.equals("6") || currCard.equals("7") || currCard.equals("8")
                                    || currCard.equals("9")
                                    || currCard.equals("10") || currCard.equals("J") || currCard.equals("Q")
                                    || currCard.equals("K")) {
                                incorrect = false;
                                if (currCard.equals("A")) {
                                    cards.add(1);
                                } else if (currCard.equals("J")) {
                                    cards.add(11);
                                } else if (currCard.equals("Q")) {
                                    cards.add(12);
                                } else if (currCard.equals("K")) {
                                    cards.add(13);
                                } else {
                                    cards.add(Integer.parseInt(currCard));
                                }
                                currCard = "";
                            } else {
                                incorrect = true;
                                currCard = "";
                                cards = new ArrayList<>();
                                break;
                            }
                        } else {
                            currCard += curr;
                        }
                    }
                    if (numOfSpaces != 3) {
                        incorrect = true;
                        currCard = "";
                        cards = new ArrayList<>();
                    } else {
                        if ((currCard.equals("A")) || (currCard.equals("2")) || currCard.equals("3")
                                || currCard.equals("4")
                                || currCard.equals("5")
                                || currCard.equals("6") || currCard.equals("7") || currCard.equals("8")
                                || currCard.equals("9")
                                || currCard.equals("10") || currCard.equals("J") || currCard.equals("Q")
                                || currCard.equals("K")) {
                            incorrect = false;
                        } else {
                            incorrect = true;
                            currCard = "";
                            cards = new ArrayList<>();
                        }
                        if (incorrect == false) {
                            if (currCard.equals("A")) {
                                cards.add(1);
                            } else if (currCard.equals("J")) {
                                cards.add(11);
                            } else if (currCard.equals("Q")) {
                                cards.add(12);
                            } else if (currCard.equals("K")) {
                                cards.add(13);
                            } else {
                                cards.add(Integer.parseInt(currCard));
                            }
                            currCard = "";
                        }
                    }
                    if (incorrect) {
                        System.out.println("Masukan tidak sesuai!");
                    }

                } while (incorrect == true);

            }

            else if (choice.equals("2")) {
                int random;
                for (int i = 1; i <= 4; i++) {
                    random = (int) Math.floor(Math.random() * 13 + 1);
                    System.out.println("Kartu ke-" + i + " yang terpilih adalah " + random);
                    cards.add(random);
                }

            }
            long startTime = System.currentTimeMillis();
            Set<String> formula = new HashSet<String>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 4; l++) {
                            if ((i != j) && (i != k) && (i != l) && (j != k) && (j != l) && (k != l)) {
                                formula = App.hitung(cards.get(i), cards.get(j), cards.get(k), cards.get(l),
                                        formula);
                            }

                        }
                    }
                }
            }
            long finishTime = System.currentTimeMillis();
            for (String f : formula) {
                numOfSolutions++;

            }
            System.out.println(numOfSolutions + " solutions found");
            for (String f : formula) {
                System.out.println(f);

            }
            long duration = finishTime - startTime;
            System.out.println("Time taken: " + duration + " ms");
            System.out.println("Apakah kamu ingin menyimpan solusi dalam bentuk file? (y/n)");
            String isfileOut = scan.nextLine();
            while (!isfileOut.equals("y") && !isfileOut.equals("n")) {
                System.out.println("Masukan salah!");
                System.out.println("Apakah kamu ingin menyimpan solusi dalam bentuk file? (y/n)");
                isfileOut = scan.nextLine();
            }
            if (isfileOut.equals("y")) {
                outputFile.solutionFile(formula, numOfSolutions, cards);
            }
            System.out.println("Apakah kamu ingin keluar dari program ini? (y/n)");
            String end = scan.nextLine();
            while (!end.equals("y") && !end.equals("n")) {
                System.out.println("Masukan salah!");
                System.out.println("Apakah kamu ingin keluar dari program ini? (y/n)");
                end = scan.nextLine();
            }
            if (end.equals("y")) {
                start = false;
            } else {
                start = true;
            }

        }
    }

}
