package _06_Card_Game;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }
    
    enum Suit{
    	SPADES, CLUBS, HEARTS, DIAMONDS;
    	
    }

    enum Rank{
    	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
    	int value;
    	Rank(int value) {
			this.value = value;
		}
		public int valueGetter() {
    		return value;
    	}
    }
}