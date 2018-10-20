package blackjack;
//Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
public class Card {
    private final int rank;
    private final int suit;
    private  int value;

    // Kinds of suits
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;

    // Kinds of ranks
    public final static int ACE   = 1;
    public final static int DEUCE = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;

    public Card(int rank, int suit) {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        this.rank = rank;
        this.suit = suit;
        giveValue(rank);
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    
    public int getValue(){
        return value;
    }

    public static boolean isValidRank(int rank) {
        return ACE <= rank && rank <= KING;
    }

    public static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }
    
    private void giveValue(int rank){
        switch (rank) {
        case ACE:
            value = 1;
            break;
        case DEUCE:
            value = 2;
            break;
        case THREE:
            value = 3;
            break;
        case FOUR:
            value = 4;
            break;
        case FIVE:
            value = 5;
            break;
        case SIX:
            value = 6;
            break;
        case SEVEN:
            value = 7;
            break;
        case EIGHT:
            value = 8;
            break;
        case NINE:
            value = 9;
            break;
        case TEN:
            value = 10;
            break;
        case JACK:
            value = 10;
            break;
        case QUEEN:
            value = 10;
            break;
        case KING:
            value = 10;
            break;
        }
    }
    public static String rankToString(int rank) {
        switch (rank) {
        case ACE:
            return "Ace";
        case DEUCE:
            return "Deuce";
        case THREE:
            return "Three";
        case FOUR:
            return "Four";
        case FIVE:
            return "Five";
        case SIX:
            return "Six";
        case SEVEN:
            return "Seven";
        case EIGHT:
            return "Eight";
        case NINE:
            return "Nine";
        case TEN:
            return "Ten";
        case JACK:
            return "Jack";
        case QUEEN:
            return "Queen";
        case KING:
            return "King";
        default:
            //Handle an illegal argument.  There are generally two
            //ways to handle invalid arguments, throwing an exception
            //(see the section on Handling Exceptions) or return null
            return null;
        }    
    }
    
    
    public static String suitToString(int suit) {
        switch (suit) {
        case DIAMONDS:
            return "Diamonds";
        case CLUBS:
            return "Clubs";
        case HEARTS:
            return "Hearts";
        case SPADES:
            return "Spades";
        default:
            return null;
        }    
    }
    
    public String toString() {
        String msg = rankToString(rank) + " of " + suitToString(suit);
        return msg;
    }

}
