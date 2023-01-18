import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Selamat datang di 24 game solver!");
        System.out.println("Silahkan memilih jenis input yang akan kamu masukkan:");
        System.out.println("1. Generate input dari user");
        System.out.println("2. Generate input secara acak");
        System.out.print("Pilihan anda (1/2): ");
        int choice = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> cards = new ArrayList<>();
        String card;
        int num;
        Boolean incorrect;
        incorrect = false;
        if (choice == 1) {
            for (int i = 1; i <= 4; i++) {
                System.out.println("Masukkan input kartu ke-" + i);
                card = scan.nextLine();
                if ((card.equals("A")) || (card.equals("2")) || card.equals("3") || card.equals("4") || card.equals("5")
                        || card.equals("6") || card.equals("7") || card.equals("8") || card.equals("9")
                        || card.equals("10") || card.equals("J") || card.equals("Q") || card.equals("K")) {
                    incorrect = false;
                } else {
                    incorrect = true;
                }
                while (incorrect == true) {
                    System.out.println("Inputan kartu anda salah!");
                    System.out.println("Masukkan input kartu ke-" + i);
                    card = scan.nextLine();
                    if ((card.equals("A")) || (card.equals("2")) || card.equals("3") || card.equals("4")
                            || card.equals("5")
                            || card.equals("6") || card.equals("7") || card.equals("8") || card.equals("9")
                            || card.equals("10") || card.equals("J") || card.equals("Q") || card.equals("K")) {
                        incorrect = false;

                    }
                }
                if (card.equals("A")) {
                    cards.add(1);
                } else if (card.equals("J")) {
                    cards.add(11);
                } else if (card.equals("Q")) {
                    cards.add(12);
                } else if (card.equals("K")) {
                    cards.add(13);
                } else {
                    cards.add(Integer.parseInt(card));
                }
            }
            // System.out.println(cards.get(0));

        } else if (choice == 2) {
            int random;
            for (int i = 1; i <= 4; i++) {
                random = (int) Math.floor(Math.random() * 13 + 1);
                System.out.println("Kartu ke-" + i + " yang terpilih adalah " + random);
                cards.add(random);
            }

        } else {
            System.out.println("Input yang kamu berikan salah!");
            System.out.print("Pilihan anda (1/2): ");
        }

        scan.close();
    }
}
