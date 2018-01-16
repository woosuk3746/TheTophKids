import cs1.Keyboard;
public class Woo{
    private static double ante;//ante the user and AI have to pay
    private static boolean folded;//returns whether the AI has folded
    private static double pot;
    public static void checkHand(PokerPlayer user){
	if (user.isRoyalFlush()){
	    System.out.println("The " + user.getName() + " has a Royal Flush!");
	}
	else if (user.isStraightFlush()){
	    System.out.println("The " + user.getName() + " has a Straight Flush with ");
	}
	else if (user.isFourOfAKind()){
	    System.out.println("The " + user.getName() + " has a Four Of A Kind ");
	}
	else if (user.isFullHouse()){
	    System.out.println("The " + user.getName() + " has a Full House " );
	}
	else if (user.isFlush()){
	    System.out.println("The " + user.getName() +  " has a flush ");   
	}
	else if (user.isStraight()){
	    System.out.println("The " + user.getName() +  " has a straight ");
	}
	else if (user.isThreeOfAKind()){
	    System.out.println("The " + user.getName() + " has a triple ");
	}
	else if (user.isTwoPair()){
	    System.out.println("The " + user.getName() +  " has two pairs ");
	}
	else if (user.isPair()){
	    System.out.println("The " + user.getName() + " has a pair ");
	}
	else{
	    if (user.highestValue() == 14){
		System.out.println("The " + user.getName() +  " has a High Card of Ace");
	    }
	    else if (user.highestValue() == 13){
		System.out.println("The " + user.getName() +  " has a High Card of King");
	    }
	    else if (user.highestValue()== 12){
		System.out.println("The " + user.getName() +  " has a High Card of Queen");
	    }
	    else if (user.highestValue()== 11){
		System.out.println("The " + user.getName() +  " has a High Card of Jack");
	    }
	    else{
		System.out.println("The " + user.getName() +  " has a High Card of " + user.highestValue());
	    }
	}
    }
    public static void dealFlop(PokerPlayer a){
	for (int i = 4; i < 7; i++){
	    a.addCard(CasinoGame.deck[i]);
	}
    }
    public static void dealTurn(PokerPlayer a){
	a.addCard(CasinoGame.deck[7]);
    }
    public static void dealRiver(PokerPlayer a){
	a.addCard(CasinoGame.deck[8]);
    }
    public static void calcBet(PokerPlayer AI, PokerPlayer user, double d){
	double r = 10 * Math.random();
	if (r > d){
	    int a = (int) (ante + ante * Math.random());
	    System.out.println("The AI bets " + a);
	    pot += a;
	    AI.withdraw(a);
	    System.out.println("Make a decision: \n 1. Fold \n 2. Call");
	    int s = Keyboard.readInt();
	    if (s == 1){
		folded = true;
		System.out.println("The AI wins!");
		AI.deposit(pot);
	    }
	    else if (s == 2){
		pot += a;
		user.withdraw(a);
	    }	
	}
	else{
	    System.out.println("The AI checks.");
	}
    }
    public static void checkOrBet(PokerPlayer user, PokerPlayer AI){
	folded = false;
	System.out.println("Make a decision: \n 1. Check \n 2. Bet");
	int s = Keyboard.readInt();
	if (s == 1){
	    if (AI.isFlush()){
		calcBet(AI,user, 0);
	    }
	    else if (AI.isStraight()){
		calcBet(AI,user, 1);
	    }
	    else if (AI.isThreeOfAKind()){
		calcBet(AI,user, 2);
	    }
	    else if (AI.isTwoPair()){
		calcBet(AI,user, 3);
	    }
	    else if (AI.isPair()){
                calcBet(AI,user, 4);
            }
	    else{
		calcBet(AI,user, 9);
	    }
	}
	else if (s == 2){
	    System.out.println("How much?");
	    double d = Keyboard.readDouble();
	    pot += d;
	    user.withdraw(d);
	    double rand = 2000 * Math.random() - d;
	    if (rand > 1200.00){
		System.out.println("The AI calls!");
		AI.withdraw(d);
		pot += d;
	    }
	    else{
		double c = 10 * Math.random();
		if (c < 3.0){
		    System.out.println("The AI calls!");
		    AI.withdraw(d);
		    pot += d;
		}
		else{
		    System.out.println("The AI folds!");
		    user.deposit(pot);
		    folded = true;
		}
	    }
	}
	System.out.println("Pot: " + pot);
    }
    public static void playGame(PokerPlayer user, PokerPlayer AI){
	folded = false;
	dealFlop(user);
	dealFlop(AI);
	user.bubbleSort();
	AI.bubbleSort();
	System.out.println(user);
	checkOrBet(user, AI);
	if (!folded){
	    dealTurn(user);
	    dealTurn(AI);
	    user.bubbleSort();
	    AI.bubbleSort();
	    System.out.println(user);
	    checkOrBet(user, AI);
	    if (!folded){
		dealRiver(user);
		dealRiver(AI);
		user.bubbleSort();
		AI.bubbleSort();
		System.out.println(user);
		checkOrBet(user, AI);
		if (!folded){
		    System.out.println("Here were the community cards");
		    System.out.print(CasinoGame.deck[4] + " ");
		    System.out.print(CasinoGame.deck[5] + " ");
		    System.out.print(CasinoGame.deck[6] + " ");
		    System.out.print(CasinoGame.deck[7] + " ");
		    System.out.print(CasinoGame.deck[8] + " ");
		    System.out.println();
		    user.bubbleSort();
		    System.out.println("Your Hand: ");
		    System.out.println(user);
		    checkHand(user);	
		    AI.bubbleSort();
		    System.out.println("AI's Hand: ");
		    System.out.println(AI);
		    checkHand(AI);
		}
	    }
	}
    }
    public static void checkWinner(PokerPlayer user, PokerPlayer AI){
	if (TexasHoldem.play(user, AI).equals(user)){
	    System.out.println("The user won!");
	    user.deposit(pot);
	}
	else if (TexasHoldem.play(user, AI).equals(AI)){
	    System.out.println("Unfortunately, the AI won this battle!");
	    AI.deposit(pot);
	}
    }
    public static void main(String[] args){
	System.out.println("====================================");
	System.out.println("* Welcome to the Toph Casino Games *");
	System.out.println("====================================");
	System.out.println("Please enter your name.");
	String name = Keyboard.readString();
	System.out.println("How many rounds of casino games do you want to play?");
	Player user = new Player(name, 7, 2000);
	Player AI = new Player("AI", 7, 2000);
	int r = Keyboard.readInt();
	for (int i = 0; i < r; i++){
	    System.out.println("Choose Your Game (Enter the number of the game)");
	    System.out.println("1. Texas Hold 'Em");
	    System.out.println("2. Blackjack"); 
	    int s = Keyboard.readInt();
	    double userBalance = user.getBalance();
	    double AIBalance = AI.getBalance();
        
        //texas holdem
	    if (s == 1){
        System.out.println("Both the user and the AI will start of with a total of 2000 dollars worth of chips");
		user = new PokerPlayer(name,7,userBalance);
		AI = new PokerPlayer("AI", 7, AIBalance);
		System.out.println("How much do you want the ante to be for each round?");
		ante = Keyboard.readDouble();
		//creates a deck
		CasinoGame.makeADeck();
		//shuffles the deck to ensure a fair game
		CasinoGame.shuffle(); 
		user.withdraw(ante);
		user.addCard(CasinoGame.deck[0]);
		user.addCard(CasinoGame.deck[1]);
		System.out.println("Your Hand: " + CasinoGame.deck[0] + " , " + CasinoGame.deck[1]);
		AI.withdraw(ante);
                AI.addCard(CasinoGame.deck[2]);
                AI.addCard(CasinoGame.deck[3]);
		System.out.println("Make a decision: \n" + "1. Fold\n" + "2. Call(30)\n" + "3. Raise\n");
		pot = 2 * ante;
		int t = Keyboard.readInt();
		//Does following if user decides to fold
		if (t == 1){
		    System.out.println("The AI won!");
		    AI.deposit(pot);
		}
		//Does following if user decides to call
		else if (t == 2){
		    PokerPlayer AIGen = (PokerPlayer) AI;
		    PokerPlayer userGen = (PokerPlayer) user;
		    user.withdraw(30);
		    pot += 30;
		    System.out.println("The AI is thinking through his options...\n");
		    AIGen.bubbleSort();
		    userGen.bubbleSort();
		    double rand = 14.0 * Math.random();
		    //System.out.println(AIGen.highestValue());
		    if (AIGen.isPair()){
			if (rand < 13.5){
			    System.out.println("The AI calls!");
			    pot += 30;
			    AI.withdraw(30.0);
			    playGame(userGen, AIGen);
			    if (!folded){
				checkWinner(userGen, AIGen);
			    }
			   
			}
			else{
			    System.out.println("The AI folds!");
			    user.deposit(pot);
			}
		    }
		    else if (AIGen.highestValue() >= 11){
                        if (rand < 12.0){
                            System.out.println("The AI calls!");
                            AI.withdraw(30.0);
			    pot += 30;
			    playGame(userGen, AIGen);
			    if (!folded){
				checkWinner(userGen, AIGen);
			    }
			}
			else{
			    System.out.println("The AI folds!");
			    user.deposit(pot);
			}
		    }
                    else{
                        if (rand < 6.0){
                            System.out.println("The AI calls!");
			    AI.withdraw(30.0);
			    pot += 30;
			    playGame(userGen, AIGen);
			    if (!folded){
				checkWinner(userGen, AIGen);
			    }
			}
                        else{
                            System.out.println("The AI folds!");	    
			    user.deposit(2 * ante + 30);
			}
                    }		    
		}
		else if (t == 3){
		    PokerPlayer AIGen = (PokerPlayer) AI;
		    PokerPlayer userGen = (PokerPlayer) user;
		    System.out.println("By how much?");
		    double d = Keyboard.readDouble(); 
		    while (d > user.getBalance()){
			System.out.println("Invalid input!");
			System.out.println("By how much?");
			d = Keyboard.readDouble();
		    }
		    user.withdraw(d);
		    
		    System.out.println("The AI is thinking through his options ...\n");
		    double rand = 14.0 * Math.random();
		    if (AIGen.isPair()){
			if (rand < 13.5){
			    System.out.println("The AI calls!");
			    AI.withdraw(d + 30);
			    pot += d + 30;
			    System.out.println(user.getBalance());
			    playGame(userGen, AIGen);
			    if (!folded){
				checkWinner(userGen, AIGen);
			    }
			    System.out.println(user.getBalance());
			}
			else{
			    System.out.println("The AI folds!");
			    System.out.println(user.getBalance());
			    user.deposit(2 * ante + d);
			    System.out.println(user.getBalance());
			}
		    }
		    else if (AIGen.highestValue() >= 11){
			if (rand < 10.0){
                            System.out.println("The AI calls!");
                            AI.withdraw(d);
			    pot += d;
			    System.out.println(user.getBalance());
			    playGame(userGen, AIGen);
			    if (!folded){
				checkWinner(userGen, AIGen);
			    }
			    System.out.println(user.getBalance());
                        }
                        else{
                            System.out.println("The AI folds!");
			    System.out.println(user.getBalance());
                            user.deposit(2 * ante + d);
			    System.out.println(user.getBalance());
                        }
		    }
		    else{
			if (rand < 5.0){
			    System.out.println("The AI calls!");
			    AI.withdraw(d);
			    pot += d;
			    System.out.println(user.getBalance());
			    playGame(userGen, AIGen);
			    if (!folded){
				checkWinner(userGen, AIGen);
			    }
			    System.out.println(user.getBalance());
			}
			else{
			    System.out.println("The AI folds!");
			    System.out.println(user.getBalance());
			    user.deposit(2 * ante + d);
			    System.out.println(user.getBalance());
			}
		    }
		}
		System.out.println("User's Current Balance: " + user.getBalance());
		System.out.println("AI's Current Balance: " + AI.getBalance());
	    }
        
        //blackjack
	    else if (s == 2){
                
				System.out.println("You will start out with 2000 dollars. You are up against a dealer!");
				BlackjackPlayer userB = new BlackjackPlayer(name, 20, userBalance);
				BlackjackPlayer dealer = new BlackjackPlayer("Dealer", 20, AIBalance);     
            
                
                System.out.println("How much would you like to bet?");
                    int betAmt = Keyboard.readInt();
                
                
                
                while(! ( (betAmt <= userB.getBalance()) && (betAmt >0) ) ){
                    System.out.println("Please enter a valid betting amount. Remember that your betting cap is " + userB.getBalance() + " dollars.");
                    betAmt = Keyboard.readInt();                
                }
                userB.withdraw(betAmt);
                
            
				CasinoGame blackjackGame = new CasinoGame();
				blackjackGame.makeADeck();
				blackjackGame.shuffle();
				userB.addCard(blackjackGame.deck[0]);
				userB.addCard(blackjackGame.deck[1]);
				dealer.addCard(blackjackGame.deck[51]);
				dealer.addCard(blackjackGame.deck[50]);
				System.out.println("Cards dealt! \n\n");
				System.out.println(userB);
            
                
				if(userB.isBlackjack()) {
					System.out.println("You have blackjack!");//player has blackjack
					if(!(dealer.isBlackjack())) {
						System.out.println(dealer);
						System.out.println("Congratulations you win! The amount you bet is doubled and deposited to your balance.");//player but not dealer has blackjack
                        userB.deposit(betAmt * 2);
					}
					else {
						System.out.println(dealer);
						System.out.println("Unfortunately the dealer has blackjack too. Nobody wins. The money you bet will return to your balance.");//both blackjack, tie
                        userB.deposit(betAmt);
					}
				}
				else {
					if(dealer.isBlackjack()) {
						System.out.println(dealer);
						System.out.println("Unfortunately the dealer has blackjack and you don't. The dealer wins. You now lose twice the amount you bet.");//Dealer blackjack
                        userB.withdraw(betAmt * 2);
					}
					else {
						System.out.println("\nThe dealer's face-up card: " + dealer.hand[0]);
						int cardCtr = 2;
						while(!(userB.isBusted())) {
							System.out.println("\nYour total: " + userB.getTotal() + "\n\nYour turn \nHit or stand?\n1: Hit\t 2: Stand\n");
							int choice = Keyboard.readInt();
							if(choice == 1) {
								System.out.println("You were dealt a " + blackjackGame.deck[cardCtr]);
								userB.addCard(blackjackGame.deck[cardCtr]);
								cardCtr += 1;
								System.out.println(userB);
								System.out.println("Your total: " + userB.getTotal());
								if(userB.isBusted()) {
									break;
								}
							}
							else {
								System.out.println(userB);
								System.out.println("\nYour final total: " + userB.getTotal());
								break;
							}
						}
						if(userB.isBusted()){								
						System.out.println("Unfortunately the dealer has blackjack and you don't. The dealer wins. You now lose twice the amount you bet.");
                        userB.withdraw(betAmt * 2);}
						else {
							System.out.println("\nThe dealer's other card: " + dealer.hand[0]);
							System.out.println(dealer);
							int dealerCtr = 49;
							while(dealer.getTotal() < 17){
								System.out.println("\nThe dealer's total: " + dealer.getTotal());
								System.out.println("Because the dealer's total is less than 17, he hits.");
								System.out.println("The dealer drew a: " + blackjackGame.deck[dealerCtr]);
								dealer.addCard(blackjackGame.deck[dealerCtr]);						
								dealerCtr -= 1;
							}
							if(dealer.isBusted()) {
								System.out.println("\nThe dealer has busted! You win!");
								System.out.println(dealer);
								System.out.println("\nThe dealer's total: " + dealer.getTotal());
							}
							else {
								System.out.println("\nThe dealer's final total: " + dealer.getTotal());
								System.out.println("Because the dealer's total is 17 or more, he stands.");
								if(userB.getTotal() > dealer.getTotal()) {
									System.out.println("\nCongratulations, your final total is larger than the dealer's final total.\nYou win!\nThe amount you bet is doubled and deposited to your balance.");
                                    userB.deposit(betAmt * 2);
									System.out.println("\nYour final total: " + userB.getTotal() + "\nThe dealer's final total: " + dealer.getTotal());
									System.out.println(userB);
									System.out.println(dealer);
								}
								else if(userB.getTotal() < dealer.getTotal()) {
									System.out.println("\nUnfortunately your final total is smaller than the dealer's final total.\nThe dealer wins.\nYou now lose twice the amount you bet.");
                                    userB.withdraw(betAmt * 2);
									System.out.println("\nYour final total: " + userB.getTotal() + "\nThe dealer's final total: " + dealer.getTotal());
									System.out.println(userB);
									System.out.println(dealer);
								}
								else {
									System.out.println("\nYour final total is equal to the dealer's final total.\nNobody wins.\nThe amount you bet will return to your balance.");
                                    userB.deposit(betAmt);
								}
							}
						}
					}
				}			
			}
	    else{
		System.out.println("Try again! Enter a proper number!");
	    }
	}
    }
}
    
