package no.itverket;

import java.util.*;

class Deck {
    LinkedList<Card> cards;

    Deck() {
        cards = new LinkedList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                cards.offer(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
