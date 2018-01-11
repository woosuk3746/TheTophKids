public abstract class CasinoGame{
    /****************
     *instance vars*
     ****************/
    protected double balance; //calculates the user's balance
    public static Card[] deck;
    
    /*********
     *methods
     *********/
    public boolean isBroke(){
	return balance <= 0;
    }

    public double getBalance(){
	return balance;
    }

    public abstract Player play(PokerPlayer a, PokerPlayer b);
    public static void makeADeck(){
        deck = new Card[52];
	for(int i = 0; i < 52; i++){
	    deck[i] = new Card(i);
	}
    }
    public static void swap( int i, int j ){
	Card tempI = deck[i];
	Card tempJ = deck[j];
	deck[i] = tempJ;
	deck[j] = tempI;
    }
    public static void shuffle(){
	for (int k = 0; k < 1000; k++){
	    swap( (int)(Math.random()*52), (int)(Math.random()*52) );
	}
    }
}
