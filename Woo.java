import cs1.Keyboard;
public class Woo{
    private static double ante;//ante the user and AI have to pay
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
    public static void playGame(PokerPlayer user, PokerPlayer AI){
	dealFlop(user);
	dealFlop(AI);
	dealTurn(user);
	dealTurn(AI);
	dealRiver(user);
	dealRiver(AI);
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
    public static void checkWinner(PokerPlayer user, PokerPlayer AI){
	if (TexasHoldem.play(user, AI).equals(user)){
	    System.out.println("The user won!");
	    user.deposit(2 * ante);
	}
	else if (TexasHoldem.play(user, AI).equals(AI)){
	    System.out.println("Unfortunately, the AI won this battle!");
	    AI.deposit(2 * ante);
	}
    }
    public static void main(String[] args){
	System.out.println("====================================");
	System.out.println("* Welcome to the Toph Casino Games *");
	System.out.println("====================================");
	System.out.println("How many rounds of casino games do you want to play?");
	Player user = new PokerPlayer("User", 7, 2000);
	Player AI = new PokerPlayer("AI", 7, 2000);
	int r = Keyboard.readInt();
	for (int i = 0; i < r; i++){
	    System.out.println("Choose Your Game (Enter the number of the game)");
	    System.out.println("1. Texas Hold 'Em");
	    System.out.println("2. Blackjack");
	    System.out.println("Both the user and the AI will start of with a total of 2000 dollars worth of chips"); 
	    int s = Keyboard.readInt();
	    double userBalance = user.getBalance();
	    double AIBalance = AI.getBalance();
	    if (s == 1){
		user = new PokerPlayer("User",7,userBalance);
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
		int t = Keyboard.readInt();
		if (t == 1){
		    AI.deposit(2 * ante);
		}
		else if (t == 2){
		    PokerPlayer AIGen = (PokerPlayer) AI;
		    PokerPlayer userGen = (PokerPlayer) user;
		    user.withdraw(30);
		    System.out.println("The AI is thinking through his options...\n");
		    double rand = 14.0 * Math.random();
		    if (AIGen.isPair()){
			if (rand < 13.5){
			    System.out.println("The AI calls!");
			    AI.withdraw(30.0);
			    playGame(userGen, AIGen);
			    checkWinner(userGen, AIGen);
			    if (TexasHoldem.play(userGen, AIGen).equals(userGen)){
				user.deposit(60.0);
			    }
			    else if (TexasHoldem.play(userGen, AIGen).equals(AIGen)){
                                AI.deposit(60.0);
                            }
			}
			else{
			    System.out.println("The AI folds!");
			    user.deposit(2 * ante + 30);
			}
		    }
		    else if (AIGen.highestValue() >= 11){
                        if (rand < 12.0){
                            System.out.println("The AI calls!");
                            AI.withdraw(30.0);
			    playGame(userGen, AIGen);
                            checkWinner(userGen, AIGen);
			    if (TexasHoldem.play(userGen, AIGen).equals(userGen)){
                                user.deposit(60.0);
                            }
			    else if (TexasHoldem.play(userGen, AIGen).equals(AIGen)){
                                AI.deposit(60.0);
                            }
                        }
                        else{
                            System.out.println("The AI folds!");
			    user.deposit(2 * ante + 30);
			}
                    }
                    else{
                        if (rand < 6.0){
                            System.out.println("The AI calls!");
			    AI.withdraw(30.0);
			    playGame(userGen, AIGen);
                            checkWinner(userGen, AIGen);
			    if (TexasHoldem.play(userGen, AIGen).equals(userGen)){
                                user.deposit(60.0);
                            }
			    else if (TexasHoldem.play(userGen, AIGen).equals(AIGen)){
                                AI.deposit(60.0);
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
			    AI.withdraw(d);
			    ante += d;
			    System.out.println(user.getBalance());
			    playGame(userGen, AIGen);
			    checkWinner(userGen, AIGen);
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
			    ante += d;
			    System.out.println(user.getBalance());
			    playGame(userGen, AIGen);
			    checkWinner(userGen, AIGen);
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
			    ante += d;
			    System.out.println(user.getBalance());
			    playGame(userGen, AIGen);
			    checkWinner(userGen, AIGen);
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
	    else if (s == 2){
<<<<<<< HEAD
		user = new BlackjackPlayer("User", 8, userBalance);
		AI = new BlackjackPlayer("AI", 8, AIBalance);
=======
            
>>>>>>> 1eb1d904fb6377735f8831ae7c9eedbeb4f96475
	    }
	    else{
		System.out.println("Try again! Enter a proper number!");
	    }
	}
    }
}
    
