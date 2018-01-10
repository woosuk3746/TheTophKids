public class TexasHoldem extends CasinoGame{
    public Player play(PokerPlayer user, PokerPlayer AI){
	if (AI.isRoyalFlush() && user.isRoyalFlush()){
	    return AI;
	}
	if (user.isRoyalFlush()){
	    return user;
	}
    }

    public static void main(String[] args){

    }
}
