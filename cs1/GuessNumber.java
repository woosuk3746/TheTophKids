public class GuessNumber{
    private int guesses;
    private int randNum;
    private int high;
    private int low;

    public GuessNumber(){
	randNum = (int)(Math.random() * 100) + 1;
	high = 100;
	low = 1;
	guesses = 0;
    }

    public int guess( int userInput ){
    }	

    public static void main( String[] args ){
	
    }//end main method
}//end class

    
    
