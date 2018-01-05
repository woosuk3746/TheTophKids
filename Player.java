public class Player{//this class will eventually be abstract
    protected Card[] hand;
    protected int rank;
    private String name;
    private int size;
    private int currentCard;
    public Player(String n, int s){
	name = n;
	hand = new Card[s];
	size = s;
	currentCard = 0;
    }
    public Card[] getCards(){
	Card[] temp = new Card[size];
	for (int i = 0; i < hand.length; i++){
	    temp[i] = hand[i];
	}
	return temp; 
    }
    public void addCard(Card c){
	hand[currentCard] = c;
	currentCard++;
    }
    public String toString(){
	String retStr = name + ": ";
	for (Card c: hand){
	    retStr += c + ",";
	}
	return retStr;
    }
    //public abstract void evaluate();
    public static void main(String[] args){
	Player Aidan = new Player("Aidan", 2);
	Aidan.addCard(new Card((int) (Math.random() * 52)));
	Aidan.addCard(new Card((int) (Math.random() * 52)));
	System.out.println(Aidan);
    }
}
