//This is the file which contains main function
import java.util.Scanner;

public class CardSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        boolean running = true;

        System.out.println("Welcome to the Deck of Cards Simulator!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Shuffle Deck");
            System.out.println("2. Sort Deck");
            System.out.println("3. Draw a Random Card");
            System.out.println("4. Draw Multiple Cards");
            System.out.println("5. Print Remaining Deck");
            System.out.println("6. Reset Deck");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.sortDeck();
                    break;
                case 3:
                    deck.drawCard();
                    break;
                case 4:
                    System.out.print("How many cards do you want to draw? ");
                    int count = scanner.nextInt();
                    deck.drawMultipleCards(count);
                    break;
                case 5:
                    System.out.println("Cards in the deck:");
                    deck.printDeck();
                    break;
                case 6:
                    deck.resetDeck();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
