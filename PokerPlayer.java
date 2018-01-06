public class PokerPlayer extends Player{
    private Card[] temp;//temporary storage for hand 
    public PokerPlayer(String n, int s){
	super(n,s);
	temp = new Card[s];
    }
    public void evaluate(){
	bubbleSort();
    }
    public void bubbleSort(){
	//copies elements of hand into temp
	for (int k = 0; k < hand.length; k++){
	    temp[k] = hand[k];
	}
	int numPasses = hand.length - 1;
	for (int i = 0; i < numPasses; i++){
	    for (int j = 0; j < numPasses; j++){
		if (temp[j].getValue() > temp[j + 1].getValue()){
		    Card t = temp[j + 1];
		    temp[j + 1] = temp[j];
		    temp[j] = t;
		}		
	    }
	}
    }
    public boolean isRoyalFlush(){
	if (isStraightFlush()){
	    if (highestValue() == 14){
		return true;
	    }
	}
	return false;
    }
    public boolean isStraightFlush(){
	return (isFlush() && isStraight());
    }
    public boolean isFourOfAKind(){
	return (numberOfKind() == 4);
    }
    public int numberOfKind(){
	int valueCounter = 1;
	int highestValue = 1;
	for (int i = 0; i < temp.length; i++){
	    for (int j = i + 1; j < temp.length; j++){
		//System.out.println("At i = " + i + ":" + temp[i].getValue());
		//System.out.println("At j = " + j + ":" + temp[j].getValue());
		if (temp[i].getValue() == temp[j].getValue()){
		    valueCounter++;
		    //System.out.println(valueCounter);
		}
		if (valueCounter > highestValue){
		    highestValue = valueCounter;
		    //System.out.println(highestValue);
		}
	    }
	    valueCounter = 1;
	}
	return highestValue;
    }
    public boolean isFullHouse(){
	return false;
    }	    
    public boolean isFlush(){
	int heartCounter = 0;
	int diamondCounter = 0;
	int spadeCounter = 0;
	int clubCounter = 0;
	for (int i = 0; i < temp.length; i++){
	    if (temp[i].getSuit().equals("hearts")){
		heartCounter++;
		System.out.println(heartCounter);
	    }
	    if (temp[i].getSuit().equals("diamonds")){
                diamondCounter++;
            }
	    if (temp[i].getSuit().equals("spades")){
                spadeCounter++;
            }
	    if (temp[i].getSuit().equals("clubs")){
                clubCounter++;
            }
	}
	if (clubCounter >= 5){
	    for (int j = 0; j < temp.length; j++){
		if (!temp[j].getSuit().equals("club")){
		    //temp[j] = null;
		}
	    }
	    return true;
	}
	if (heartCounter >= 5){
            for (int j = 0; j < temp.length; j++){
                if (!temp[j].getSuit().equals("heart")){
                    //temp[j] = null;
                }
            }
            return true;
        }
	if (spadeCounter >= 5){
            for (int j = 0; j < temp.length; j++){
                if (!temp[j].getSuit().equals("spade")){
                    //temp[j] = null;
                }
            }
            return true;
        }
	if (diamondCounter >= 5){
            for (int j = 0; j < temp.length; j++){
                if (!temp[j].getSuit().equals("diamond")){
                    //temp[j] = null;
                }
            }
            return true;
        }
	return false;
    }
    public boolean isStraight(){
	int counter = 0;
	Card[] arr = new Card[temp.length];
	for (int i = 0; i < temp.length - 1; i++){
	    //System.out.println("current index: " + i);
	    //System.out.println("current card value: " + temp[i].getValue());
	    //System.out.println("next card value: " + temp[i + 1].getValue());
	    if (temp[i + 1].getValue() == temp[i].getValue() + 1){
		if (counter == 0){
		    arr[counter] = temp[i];
		}
		counter++;
		arr[counter] = temp[i + 1];
		//System.out.println(counter);
		//System.out.println(arr[counter]);
	    }
	    else if (temp[i + 1].getValue() != temp[i].getValue()){
		if (counter < 4){
		    counter = 0;
		}
	    }
	}
	if (counter >= 4){
	    for (int i = 0; i < temp.length; i++){
		boolean found = false;//checks and looks to find value in temp in arr
		for (int j = 0; j < counter + 1; j++){
		    if (temp[i].equals(arr[j])){
			found = true;
		    }
		}
		if (!found){
		    //temp[i] = null;
		}
	    }
	    return true;
	}
	return false;
    }
    public boolean isThreeOfAKind(){
	return (numberOfKind() == 3);
    }
    public boolean isPair(){
	return (numberOfKind() == 2);
    }
    public int highestValue(){
	for (int i = temp.length - 1; i >= 0; i--){
	    if (temp[i] != null){
		return temp[i].getValue();
	    }
	}
	return 0;
    }
    public void printTemp(){
	for (int i = 0; i < temp.length; i++){
	    System.out.print(temp[i] + " ");
	}
	System.out.println();
    }
    public static void main(String[] args){
	Player Aidan = new PokerPlayer("Aidan", 7);
        Aidan.addCard(new Card(24));
        Aidan.addCard(new Card(23));
	Aidan.addCard(new Card(21));
	Aidan.addCard(new Card(7));
	Aidan.addCard(new Card(22));
	Aidan.addCard(new Card(49));
	Aidan.addCard(new Card(25));
	((PokerPlayer) Aidan).bubbleSort();
	System.out.println(Aidan);
	((PokerPlayer) Aidan).printTemp();
	System.out.println(((PokerPlayer) Aidan).isRoyalFlush());
	System.out.println(((PokerPlayer) Aidan).isStraightFlush());
	System.out.println(((PokerPlayer) Aidan).isFlush());
	System.out.println(((PokerPlayer) Aidan).isStraight());
	((PokerPlayer) Aidan).printTemp();
	Player AShao = new PokerPlayer("Andrew" , 7);
	AShao.addCard(new Card(25));
	AShao.addCard(new Card(12));
	AShao.addCard(new Card(14));
	AShao.addCard(new Card(20));
	AShao.addCard(new Card(34));
	AShao.addCard(new Card(51));
	AShao.addCard(new Card(38));
	((PokerPlayer) AShao).bubbleSort();
	System.out.println(AShao);
	((PokerPlayer) AShao).printTemp();
	System.out.println(((PokerPlayer) AShao).isFourOfAKind());
	System.out.println(((PokerPlayer) AShao).isThreeOfAKind());
	System.out.println(((PokerPlayer) AShao).isPair());
    }
}
