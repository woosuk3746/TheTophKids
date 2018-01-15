public class Player{//this class will eventually be abstract
    protected Card[] hand;
    protected int rank;
    protected double balance;
    protected String name;
    protected int size;
    private int currentCard;
    public Player(String n, int s, double b){
	name = n;
	hand = new Card[s];
	size = s;
	balance = b;
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
    public Card getCard(int i){
	return hand[i];
    }
    public String toString(){
	String retStr = name + ": ";
	for (Card c: hand){
	    if (c != null){
                retStr += c + ", ";
            }
	}    
	return retStr.substring(0,retStr.length()-2);
    }
    public double getBalance(){
	return balance;
    }
    public void deposit(double amnt){
	balance += amnt;
	System.out.println("This is a deposit.");
	System.out.print(" Name: " + name);
	System.out.print(" Balance: " + balance);
	System.out.println(" amnt: " + amnt);
    }
    public void withdraw(double amnt){
        balance -= amnt;
	System.out.println("This is a withdrawal.");
	System.out.println(" Name: " + name);
	System.out.println(" Balance: " + balance);
    System.out.println(" amnt: " + amnt);
    }
    public static void main(String[] args){
	Player Aidan = new Player("Aidan", 4, 2000);
	Aidan.addCard(new Card((int) (Math.random() * 52)));
	Aidan.addCard(new Card((int) (Math.random() * 52)));
	Aidan.addCard(new Card((int) (Math.random() * 52)));
	Aidan.addCard(new Card((int) (Math.random() * 52)));
	System.out.println(Aidan);
    }
}
