import java.util.Scanner;

public class HighCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting the players name and age
        System.out.print("Enter name for Player 1: ");
        String name1 = scanner.nextLine();

        System.out.println("Enter age for Player 1");
        int age1 = scanner.nextInt();

        System.out.print("Enter name for Player 2: ");
        String name2 = scanner.nextLine();

        // weird scanner bug
        scanner.nextLine();

        System.out.println("Enter age for Player 2");
        int age2 = scanner.nextInt();

        Player player1 = new Player(age1, name1);
        Player player2 = new Player(age2, name2);

        Deck deck = new Deck();
        deck.shuffle();

        DiscardPile discardPile = new DiscardPile();

        for (int i = 0; i < 5; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        int score1 = 0, score2 = 0;
        for (int round = 1; round <= 5; round++) {

           // Finding the highest value card in player 1's hand
            Card[] hand1 = player1.getHand();
            Card high1 = hand1[0];
            for (int i = 1; i < hand1.length; i++) {
                if (hand1[i].getValue() > high1.getValue()) {
                    high1 = hand1[i];
                }
            }

           // Finding the highest value card in player 2's hand
            Card[] hand2 = player2.getHand();
            Card high2 = hand2[0];
            for (int i = 1; i < hand2.length; i++) {
                if (hand2[i].getValue() > high2.getValue()) {
                    high2 = hand2[i];
                }
            }

            player1.discardCard(high1, discardPile);
            player2.discardCard(high2, discardPile);

            System.out.println("Round " + round + ":");

            // Printing highest value card
            System.out.println(player1.getName() + " plays: " + high1);
            System.out.println(player2.getName() + " plays: " + high2);

            // determing whether who won round
            if (high1.getValue() > high2.getValue()) {
                score1++;

                System.out.println(player1.getName() + " won this round");

            } else if (high2.getValue() > high1.getValue()) {
                score2++;

                System.out.println(player2.getName() + " won this round");
            }
            // For readability reasons
            System.out.println("");
            System.out.println("");

        }

        // Final scores
        System.out.println("FINAL SCORE: ");
        System.out.println(player1.getName() + ": " + score1);
        System.out.println(player2.getName() + ": " + score2);

        if (score1 > score2){
            System.out.println("Winner: " + player1.getName());
        } else if (score2 > score1){
            System.out.println("Winner: " + player2.getName());
        }else {
            System.out.println("tie");
        }
    }
}

