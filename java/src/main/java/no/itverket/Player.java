package no.itverket;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void playTurn(Deck deck) {
        Card card = deck.cards.remove();
        hand.addCard(card);
        System.out.printf("%s drew the card %s %s, and now has a total of %s %n", name, card.suit, card.getRankString(), hand.getTotal());
    }

}
