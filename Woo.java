import cs1.Keyboard;
public class Woo{
    private static double bigBlind;//big blind the user or AI has to pay
    private static double smallBlind;//small blind the user or AI has to pay
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
		PokerPlayer user = new PokerPlayer("user", 7, 2000);
		user.withdraw(40);
		user.addCard(CasinoGame.deck[0]);
		user.addCard(CasinoGame.deck[1]);
		System.out.println("User's Hand:" + CasinoGame.deck[0] + ", " + CasinoGame.deck[1]);
		PokerPlayer AI = new PokerPlayer("The Legendary AI", 7,2000);
		AI.withdraw(20);
                AI.addCard(CasinoGame.deck[2]);
                AI.addCard(CasinoGame.deck[3]);
		System.out.println("Make a decision " + "1. Fold\n" + "2. Call\n" + "3. Bet\n"); 
		int t = Keyboard.readInt();
		if (t == 1){
		    AI.deposit(60);
		}
		else if (t == 2){
		    user.addCard(CasinoGame.deck[4]);
		    user.addCard(CasinoGame.deck[5]);
		    user.addCard(CasinoGame.deck[6]);
		    user.addCard(CasinoGame.deck[7]);
		    user.addCard(CasinoGame.deck[8]);
		    user.bubbleSort();
		    System.out.println("User's Hand: ");
		    user.printTemp();
		    if (user.isRoyalFlush()){
			System.out.println("The user has a Royal Flush!");
		    }
		    else if (user.isStraightFlush()){
                        System.out.println("The user has a Straight Flush with ");
                    }
		    else if (user.isFourOfAKind()){
                        System.out.println("The user has a Four Of A Kind ");
                    }
		    else if (user.isFullHouse()){
                        System.out.println("The user has a Full House " );
                                           
                    }
		    else if (user.isFlush()){
                        System.out.println("The user has a flush ");
					   
                    }
		    else if (user.isStraight()){
                        System.out.println("The user has a straight ");
                    }
		    else if (user.isThreeOfAKind()){
                        System.out.println("The user has a triple ");
                    }
		    else if (user.isTwoPair()){
                        System.out.println("The user has two pairs ");
                    }
		    else if (user.isPair()){
                        System.out.println("The user has a pair ");
                    }
		    else{
			System.out.println("The user has a High Card of " + user.highestValue());
		    }
		}
	    }
	    else if (s == 2){
		
	    }
	    else{
		System.out.println("Try again! Enter a proper number!");
	    }
	}
    }
}
