package no.itverket;


import java.util.Scanner;

public class Program {

    static final int MAX_TOTAL = 21;
    static final int MAX_DEALER = 17;

    public static void main(String[] args) {
        final Deck deck = new Deck();
        deck.shuffle();

        final Player player = new Player("The Player");
        final Player dealer = new Player("The Dealer");

        // The dealer draws the first card
        dealer.playTurn(deck);

        // The player plays
        if (playerPlays(deck, player)) {
            return; // The player busts
        }

        // The dealer plays
        if (dealerPlays(deck, dealer)) {
            return; // The dealer busts
        }

        announceWinnerIfNoOneBusted(player, dealer);
    }

    /**
     * Returns true if player busts
     */
    public static boolean playerPlays(Deck deck, Player player) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Stand, Hit");
            final String read = scanner.nextLine().toLowerCase();

            if (read.equals("hit")) {
                player.playTurn(deck);

                if (player.getHand().getTotal() > MAX_TOTAL) {
                    System.out.printf("%s's total is above %s, which means the dealer won :(%n", player.getName(), MAX_TOTAL);
                    return true;
                }

                if (player.getHand().getTotal() == MAX_TOTAL) {
                    System.out.printf("%s got a BlackJack!%n", player.getName());
                    return false;
                }

            } else if (read.equals("stand")) {
                System.out.printf("%s chose to stand with a total of %s%n", player.getName(), player.getHand().getTotal());
                return false;
            } else {
                System.out.printf("Invalid input, please try again %n");
            }
        }
    }

    /**
     * Returns true if dealer busts
     */
    public static boolean dealerPlays(Deck deck, Player dealer) {
        while (dealer.getHand().getTotal() < MAX_DEALER) {
            dealer.playTurn(deck);

            if (dealer.getHand().getTotal() > MAX_TOTAL) {
                System.out.printf("With a total of %s %s is busted, which means the remaining players won!%n", dealer.getHand().getTotal(), dealer.getName());
                return true;
            }
        }

        return false;
    }


    public static void announceWinnerIfNoOneBusted(Player player, Player dealer) {
        if (player.getHand().getTotal() == dealer.getHand().getTotal()) {
            System.out.printf("The score is a tie with both having %s %n", player.getHand().getTotal());
        } else if (player.getHand().getTotal() > dealer.getHand().getTotal()) {
            System.out.printf("%s won with a score of %s, %s only had %s %n", player.getName(), player.getHand().getTotal(), dealer.getName(), dealer.getHand().getTotal());
        } else {
            System.out.printf("%s lost with a score of %s, %s won with %s %n", player.getName(), player.getHand().getTotal(), dealer.getName(), dealer.getHand().getTotal());
        }
    }
}
