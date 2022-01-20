package _06_Card_Game;

import javax.swing.JOptionPane;

public class BlackJack {
	public static void main(String[] args) {
		new BlackJack().run();
	}
	CardDealer dealer = new CardDealer();
	int computerScore = 0;
	int playerScore = 0;
	public void run() {
		JOptionPane.showMessageDialog(null, "Welcome to BlackJack!");
		round();
	}
	
	public void round() {
		Card showing = dealer.draw();
		boolean moveOver = false;
		while (!moveOver) {
			
		}
	}
}
