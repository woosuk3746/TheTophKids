import cs1.Keyboard;
public class Woo{
    public static void main (String[] args){
	System.out.println("=========================");
	System.out.println("Welcome to the Toph Casino Games");
	System.out.println("=========================");
	
	System.out.println("Choose Your Game (Enter the number of the game)");
	System.out.println("1. Texas Hold 'Em");
	System.out.println("2. Blackjack");
	int s = Keyboard.readInt();
	if (s == 1){
	    Player Tim = new PokerPlayer("Tim", 2);
	    Tim.addCard(new Card((int) (52 * Math.random())));
	    Tim.addCard(new Card((int) (52 * Math.random())));
	    ((PokerPlayer) Tim).bubbleSort();
	    System.out.println(Tim);
	    ((PokerPlayer) Tim).printTemp();
	    Player Andrew = new PokerPlayer("Andrew", 2);
	    Andrew.addCard(new Card((int) (52 * Math.random())));
	    Andrew.addCard(new Card((int) (52 * Math.random())));
	    ((PokerPlayer) Andrew).bubbleSort();
	    System.out.println(Andrew);
	    ((PokerPlayer) Andrew).printTemp();

	    
	    Player Tim2 = new PokerPlayer("Tim", 7);
	    Tim2.addCard(Tim.getCard(0));
	    Tim2.addCard(Tim.getCard(1));
	    Card a = new Card((int) (Math.random() * 52));
	    Card b = new Card((int) (Math.random() * 52));
	    Card c = new Card((int) (Math.random() * 52));
	    Card d = new Card((int) (Math.random() * 52));
	    Card e = new Card((int) (Math.random() * 52));
	    Tim2.addCard(a);
	    Tim2.addCard(b);
	    Tim2.addCard(c);
	    Tim2.addCard(d);
	    Tim2.addCard(e);
	    ((PokerPlayer) Tim2).bubbleSort();
	    System.out.println(Tim2);

	    Player Andrew2 = new PokerPlayer("Andrew", 7);
	    Andrew2.addCard(Andrew.getCard(0));
	    Andrew2.addCard(Andrew.getCard(1));
	    Andrew2.addCard(a);
	    Andrew2.addCard(b);
	    Andrew2.addCard(c);
	    Andrew2.addCard(d);
	    Andrew2.addCard(e);
	    ((PokerPlayer) Andrew2).bubbleSort();
	    System.out.println(Andrew2);
	}
	else if (s == 2){
	    
	}
    }
}
