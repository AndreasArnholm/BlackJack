package no.itverket;

class Card {
    Suit suit;
    int rank;

    Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }


    public String getRankString() {
        switch (rank) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                if (rank > 1 && rank < 11) {
                    return String.valueOf(rank);
                } else {
                    throw new IllegalArgumentException("Invalid rank: " + rank);
                }
        }
    }
}