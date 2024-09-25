package no.itverket;

import static no.itverket.Program.MAX_TOTAL;

public class Hand {

    private int total = 0;

    public void addCard(Card card) {
        this.total += Math.min(card.rank, 10);

        if (card.getRankString().equals("A") && total + 10 <= MAX_TOTAL) {
            this.total += 10;
        }
    }

    public int getTotal() {
        return total;
    }
}
