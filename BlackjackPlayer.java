public class BlackjackPlayer extends Player {
    
    public BlackjackPlayer(String n, int s, double d) {
	super(n,s,d);
    }
    
    public int getTotal() {
	int retInt = 0;
	int aceCtr = 0;
	for (Card x: hand) {
	    if (x != null) {
		if(x.getValue() == 14)
		    aceCtr++;
		else if (x.getValue() > 10)
		    retInt += 10;
		else
		    retInt += x.getValue();
	    }
	}
	if (aceCtr > 0 && 21 - retInt >= 11 + aceCtr - 1) {
	    retInt += 11 + aceCtr - 1;
	}
	else {
	    retInt += aceCtr;
	}
	return retInt;
    }
    
    public boolean isBlackjack() {
	return (hand[2] == null && getTotal() == 21);
    }
    
    public boolean isBusted() {
	return (getTotal() > 21);
    }
    
    public static void main(String args[])  {
	Card ace = new Card(12);
	Card king = new Card(11);
	Card six = new Card(4);
	Card five = new Card(3);
	Card four = new Card(2);			
	
	BlackjackPlayer rod = new BlackjackPlayer("rod", 2, 2000);
	rod.addCard(ace);
	rod.addCard(king);
	System.out.println("\n" + rod);
	System.out.println(rod.getTotal());
	System.out.println(rod.isBusted());
	System.out.println(rod.isBlackjack());
	
	BlackjackPlayer chan = new BlackjackPlayer("chan",3, 2000);
	chan.addCard(king);
	chan.addCard(five);
	chan.addCard(six);
	System.out.println("\n" + chan);
	System.out.println(chan.getTotal());
	System.out.println(chan.isBusted());
	System.out.println(chan.isBlackjack());
	
	BlackjackPlayer reggie = new BlackjackPlayer("reggie",4,2000);
	reggie.addCard(four);
	reggie.addCard(five);
	reggie.addCard(ace);
	reggie.addCard(ace);
	System.out.println("\n" + reggie);
	System.out.println(reggie.getTotal());
	System.out.println(reggie.isBusted());
	System.out.println(reggie.isBlackjack());
	
	BlackjackPlayer keisha = new BlackjackPlayer("keisha",4,2000);
	keisha.addCard(six);
	keisha.addCard(five);
	keisha.addCard(ace);
	keisha.addCard(ace);
	System.out.println("\n" + keisha);
	System.out.println(keisha.getTotal());
	System.out.println(keisha.isBusted());
	System.out.println(keisha.isBlackjack());
	
	BlackjackPlayer aladeen = new BlackjackPlayer("aladeen",4,2000);
	aladeen.addCard(king);
	aladeen.addCard(king);
	aladeen.addCard(ace);
	aladeen.addCard(ace);
	System.out.println("\n" + aladeen);
	System.out.println(aladeen.getTotal());
	System.out.println(aladeen.isBusted());
	System.out.println(aladeen.isBlackjack());		
    }
}
