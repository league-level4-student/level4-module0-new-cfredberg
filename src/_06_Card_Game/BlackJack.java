package _06_Card_Game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BlackJack {
	public static void main(String[] args) {
		new BlackJack().run();
	}
	CardDealer dealer = new CardDealer();
	int computerScore = 0;
	int playerScore = 0;
	int moveTotal = 0;
	int dealerMoveTotal = 0;
	public void run() {
		JOptionPane.showMessageDialog(null, "Welcome to BlackJack!");
		boolean quit = false;
		while (!quit) {
			dealer.newDeck();
			dealer.shuffle();
			round();
			quit = !showWinner();
		}
	}
	
	public void round() {
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		dealerHand.add(dealer.draw());
		ArrayList<Card> myHand = new ArrayList<Card>();
		myHand.add(dealer.draw());
		myHand.add(dealer.draw());
		boolean moveOver = false;
		//Player's turn
		while (!moveOver) {
			int move = JOptionPane.showOptionDialog(null, "The dealer is showing a " + dealerHand.get(0).getRank() + " of " + dealerHand.get(0).getSuit() + ".\nYour hand is " + myHandString(myHand) + ".", "Your Move", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[] {"Hit", "Stand"}, 0);
			if (move == 0) {
				myHand.add(dealer.draw());
			}else {
				moveOver = true;
			}
			int handTotal = myHandTotal(myHand);
			if (handTotal > 21) {
				moveOver = true;
				JOptionPane.showMessageDialog(null, "The dealer is showing a " + dealerHand.get(0).getRank() + " of " + dealerHand.get(0).getSuit() + ".\nYou Busted.\nYour hand is " + myHandString(myHand) + ".");
			}
			moveTotal = handTotal;
		}
		//Dealer's Turn
		moveOver = false;
		while (!moveOver) {
			dealerHand.add(dealer.draw());
			JOptionPane.showMessageDialog(null, "The dealer's hand is " + myHandString(dealerHand) + ".");
			int move = 0;
			if (myHandTotal(dealerHand) > 16) {
				move = 1;
			}
			if (move == 0) {
				JOptionPane.showMessageDialog(null, "The dealer decides to hit.");
				myHand.add(dealer.draw());
			}else {
				JOptionPane.showMessageDialog(null, "The dealer decides to stand.");
				moveOver = true;
			}
			int handTotal = myHandTotal(myHand);
			if (handTotal > 21) {
				moveOver = true;
			}
			dealerMoveTotal = handTotal;
		}
	}
	
	public String myHandString(ArrayList<Card> myHand) {
		String hand = "";
		if (myHand.size() == 2) {
			return myHand.get(0).getRank() + " of " + myHand.get(0).getSuit() + " and " + myHand.get(1).getRank() + " of " + myHand.get(1).getSuit();
		}
		for (int i = 0; i < myHand.size(); i++) {
			if (i == myHand.size()-1) {
				hand = hand + "and " + myHand.get(i).getRank() + " of " + myHand.get(i).getSuit();
			}else {
				hand = hand + myHand.get(i).getRank() + " of " + myHand.get(i).getSuit() + ", ";
			}
		}
		return hand;
	}
	
	public int myHandTotal(ArrayList<Card> myHand) {
		int runningTotal = 0;
		for (int i = 0; i < myHand.size(); i++) {
			runningTotal = runningTotal + myHand.get(i).getRank().value;
		}
		return runningTotal;
	}
	public boolean showWinner() {
		int result = 0;
		if (moveTotal > dealerMoveTotal) {
			if (moveTotal <= 21) {
				result = JOptionPane.showOptionDialog(null, "You Win! You had a higher total! Would you like to play again?", "You Win!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}else if (moveTotal > 21 && dealerMoveTotal <= 21) {
				result = JOptionPane.showOptionDialog(null, "You Lose. You Busted. Would you like to play again?", "You Lose.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}else {
				result = JOptionPane.showOptionDialog(null, "You have both busted. Would you like to play again?", "Both Busted.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}
		}else if (moveTotal < dealerMoveTotal) {
			if (dealerMoveTotal <= 21) {
				result = JOptionPane.showOptionDialog(null, "You Lose. The dealer had a higher total. Would you like to play again?", "You Lose.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}else if (dealerMoveTotal > 21 && moveTotal <= 21) {
				result = JOptionPane.showOptionDialog(null, "You Win! The dealer busted! Would you like to play again?", "You Win!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}else {
				result = JOptionPane.showOptionDialog(null, "You have both busted. Would you like to play again?", "Both Busted.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}
		}else {
			if (moveTotal > 21 && dealerMoveTotal > 21) {
				result = JOptionPane.showOptionDialog(null, "You have both busted. Would you like to play again?", "Both Busted.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}else {
				result = JOptionPane.showOptionDialog(null, "You have tied the dealer. Would you like to play again?", "Tied.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Yes", "No"}, 0);
			}
		}
		if (result == 0) {
			return true;
		}
		return false;
	}
}
