public class Card{
    private String suit;//diamond, spade, club, heart
    private int value;//Jack: 11, Queen: 12, King: 13, Ace: 14
    public Card(int v){
	value = (v % 13) + 2;
	if (v > 38){
	    suit = "diamonds";
	}
	else if (v > 25){
	    suit = "clubs";
	}
	else if (v > 12){
	    suit = "hearts";
	}
	else{
	    suit = "spades";
	}
    }
    public String toString(){
	if (value <= 10){
	    return value + " of " + suit;
	}
	else if (value == 11){
	    return "Jack of " + suit;
	}
	else if (value == 12){
	    return "Queen of " + suit;
	}
	else if (value == 13){
	    return "King of " + suit;
	}
	else{
	    return "Ace of " + suit;
	}
	    
    }
    public int getValue(){
	return value;
    }
    public String getSuit(){
	return suit;
    }
    public static void main(String[] args){
	Card c = new Card(37);
	System.out.println(c);//should return 13(King) of clubs
	System.out.println(c.getValue());
	System.out.println(c.getSuit());
	Card a = new Card(15);
	System.out.println(a);//should return 4 of hearts
	System.out.println(a.getValue());
	System.out.println(a.getSuit());
    }
}
