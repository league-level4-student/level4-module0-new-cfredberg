package _06_Card_Game;

import java.util.ArrayList;
import java.util.Random;

public class CardDealer {
    
    ArrayList<Card> deck = new ArrayList<Card>();
    public void newDeck() {
    	for (int i = 0; i < Card.Rank.values().length; i++) {
    		for (int j = 0; j < Card.Suit.values().length; j++) {
    			deck.add(new Card(Card.Rank.values()[i], Card.Suit.values()[j]));
    		}
    	}
    }
    
    public void shuffle() {
    	ArrayList<Card> tempDeck = new ArrayList<Card>();
    	for (int i = 0; i < deck.size(); i++) {
    		int size = 52-i;
    		int rndNum = new Random().nextInt(size);
    		tempDeck.add(deck.get(rndNum));
    		deck.remove(rndNum);
    	}
    	deck = tempDeck;
    }
    
    public Card draw() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
    }
}
