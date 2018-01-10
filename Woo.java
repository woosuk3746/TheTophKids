import cs1.Keyboard;
public class Woo{
    public static void main (String[] args){
	System.out.println("=========================");
	System.out.println("Welcome to the Toph Casino Games");
	System.out.println("=========================");
	for (int i = 0; i < 3; i++){
	    System.out.println("Choose Your Game (Enter the number of the game)");
	    System.out.println("1. Texas Hold 'Em");
	    System.out.println("2. Blackjack");
	    int s = Keyboard.readInt();
	    if (s == 1){
		CasinoGame.makeADeck();
		CasinoGame.shuffle();
		Player user = new PokerPlayer("user", 7);
		user.addCard(CasinoGame.deck[0]);
		user.addCard(CasinoGame.deck[1]);
		System.out.println(CasinoGame.deck[0] + ", " + CasinoGame.deck[1]);
		Player AI = new PokerPlayer("The Legendary AI", 7);
		AI.addCard(CasinoGame.deck[2]);
		AI.addCard(CasinoGame.deck[3]);
	    }
	    else if (s == 2){
		
	    }
	    else{
		System.out.println("Try again! Enter a proper number!");
	    }
	}
    }
}
