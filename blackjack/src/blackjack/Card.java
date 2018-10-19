package blackjack;
public enum Card implements Comparable<Card> {

    ACE(1, 11),
    KING(13, 10),
    QUEEN(12, 10),
    JACK(11, 10),
    TEN(10, 10),
    NINE(9, 9),
    EIGHT(8, 8),
    SEVEN(7, 7),
    SIX(6, 6),
    FIVE(5, 5),
    FOUR(4, 4),
    THREE(3, 3),
    TWO(2, 2);

    private final int rank;
    private final int value;
    private static final String[] CARD_NAMES = {
            "joker", "ace", "two", "three",
            "four", "five", "six", "seven",
            "eight", "nine", "ten", "jack",
            "queen", "king"
    };

    private Card(final int rank, final int value) {
        this.rank = rank;
        this.value = value;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return CARD_NAMES[rank] + " value: " + value;
    }
}