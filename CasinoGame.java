public abstract class CasinoGame{
    /****************
     *instance vars*
     ****************/
    protected double balance; //calculates the user's balance
    protected Card[] deck;
    
    /*********
     *methods
     *********/
    public boolean isBroke(){
	return balance <= 0;
    }

    public double getBalance(){
	return balance;
    }

    public abstract void play();

    public void makeADeck(){
        deck = new Card[52];
	for(int i = 0; i < 52; i++){
	    deck[i] = new Card(i);
	}
    }
    public void swap( int i, int j ){
	Card tempI = deck[i];
	Card tempJ = deck[j];
	deck[i] = tempJ;
	deck[j] = tempI;
    }
    public void shuffle(){
	for (int k = 0; k < 1000; k++){
	    swap( (int)(Math.random()*52), (int)(Math.random()*52) );
	}
    }
}
