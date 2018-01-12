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
	    System.out.println("Both the user and the AI will start of with a total of 2000 dollars worth of chips");
	    int s = Keyboard.readInt();
	    if (s == 1){
		CasinoGame.makeADeck();
		CasinoGame.shuffle();
		PokerPlayer user = new PokerPlayer("user", 7, 2000); 
		user.withdraw(30);
		user.addCard(CasinoGame.deck[0]);
		user.addCard(CasinoGame.deck[1]);
		System.out.println("User's Hand: " + CasinoGame.deck[0] + " , " + CasinoGame.deck[1]);
		PokerPlayer AI = new PokerPlayer("The Legendary AI", 7,2000);
		AI.withdraw(30);
                AI.addCard(CasinoGame.deck[2]);
                AI.addCard(CasinoGame.deck[3]);
		System.out.println("Make a decision " + "1. Fold\n" + "2. Call\n" + "3. Raise\n"); 
		int t = Keyboard.readInt();
		if (t == 1){
		    AI.deposit(60);
		}
		else if (t == 2){
		    user.withdraw(30);
		    System.out.println("The AI is thinking through his options...\n");
		    double rand = 14.0 * Math.random();
		    if (AI.isPair()){
			if (rand < 13.5){
			    System.out.println("The AI calls!");
			    AI.withdraw(30.0);
			}
			else{
			    System.out.println("The AI folds!");
			    user.deposit(90.0);
			}
		    }
		    else if (AI.highestValue() >= 11){
                        if (rand < 10.0){
                            System.out.println("The AI calls!");
                            AI.withdraw(30.0);
                        }
                        else{
                            System.out.println("The AI folds!");
                            user.deposit(90.0);
                        }
                    }
                    else{
                        if (rand < 6.0){
                            System.out.println("The AI calls!");
			    AI.withdraw(30.0);
			}
                        else{
                            System.out.println("The AI folds!");
                            user.deposit(90.0);
                        }
                    }
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
			if (user.highestValue() == 14){
			    System.out.println("The user has a High Card of Ace");
			}
			else if (user.highestValue()== 13){
                            System.out.println("The user has a High Card of King");
			}
			else if (user.highestValue()== 13){
                            System.out.println("The user has a High Card of Queen");
			}
			else if (user.highestValue()== 13){
                            System.out.println("The user has a High Card of Jack");
			}
			else{
			    System.out.println("The user has a High Card of " + user.highestValue());
			}
		    }
		    AI.addCard(CasinoGame.deck[4]);
                    AI.addCard(CasinoGame.deck[5]);
                    AI.addCard(CasinoGame.deck[6]);
                    AI.addCard(CasinoGame.deck[7]);
                    AI.addCard(CasinoGame.deck[8]);
		    AI.bubbleSort();
		    if (TexasHoldem.play(user, AI).equals(user)){
			user.deposit(90.0);
		    }
		    else if (TexasHoldem.play(user, AI).equals(AI)){
                        AI.deposit(90.0);
                    }
		}
		else if (t == 3){
		    System.out.println("By how much?");
		    double d = Keyboard.readDouble();
		    if (d > user.getBalance()){
			System.out.println("Invalid input!");
		    }
		    System.out.println("The AI is thinking through his options ...\n");
		    double rand = 14.0 * Math.random();
		    if (AI.isPair()){
			if (rand < 13.5){
			    System.out.println("The AI calls!");
			    AI.withdraw(d);
			}
			else{
			    System.out.println("The AI folds!");
			    user.deposit(90.0);
			}
		    }
		    else if (AI.highestValue() >= 11){
			if (rand < 7.0){
                            System.out.println("The AI calls!");
                            AI.withdraw(d);
                        }
                        else{
                            System.out.println("The AI folds!");
                            user.deposit(90.0);
                        }
		    }
		    else{
			if (rand < 3.0){
			    System.out.println("The AI calls!");
			}
			else{
			    System.out.println("The AI folds!");
			    user.deposit(90.0);
			}
		    }
		}
		System.out.println("User's Current Balance: " + user.getBalance()); 
	    }
	    else if (s == 2){
		
	    }
	    else{
		System.out.println("Try again! Enter a proper number!");
	    }
	}
    }
}
    