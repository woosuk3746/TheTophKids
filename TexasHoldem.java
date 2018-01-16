public class TexasHoldem extends CasinoGame{
    public static Player play(PokerPlayer user, PokerPlayer AI){
	if (AI.isRoyalFlush() && user.isRoyalFlush()){
	    return AI;
	}
	else if (AI.isRoyalFlush()){
	    return AI;
	}
	else if (user.isRoyalFlush()){
	    return user;
	}
	else if (AI.isStraightFlush() && user.isStraightFlush()){
	    if (user.highestValue() > AI.highestValue()){
		return user;
	    }
	    return AI;
	}
	else if (AI.isStraightFlush()){
	    return AI;
	}
        else if (user.isStraightFlush()){
            return user;
        }
	else if (AI.isFourOfAKind() && user.isFourOfAKind()){
            if (user.highestValue() > AI.highestValue()){
		return user;
	    }
	    return AI;
        }
	else if (AI.isFourOfAKind()){
	    return AI;
	}
        else if (user.isFourOfAKind()){
            return user;
        }
	else if (AI.isFullHouse() && user.isFullHouse()){
            if (user.highestValue() > AI.highestValue()){
		return user;
            }
            return AI;
        }
	else if (AI.isFullHouse()){
	    return AI;
	}
        else if (user.isFullHouse()){
            return user;
        }
	else if (AI.isFlush() && user.isFlush()){
            if (user.highestValue() > AI.highestValue()){
		return user;
            }
            return AI;
        }
	else if (AI.isFlush()){
	    return AI;
	}
        else if (user.isFlush()){
            return user;
        }
	else if (AI.isStraight() && user.isStraight()){
            if (user.highestValue() > AI.highestValue()){
		return user;
            }
            return AI;
        }
	else if (AI.isStraight()){
	    return AI;
	}
        else if (user.isStraight()){
            return user;
        }
	else if (AI.isThreeOfAKind() && user.isThreeOfAKind()){
            if (user.highestThreeOfAKind() > AI.highestThreeOfAKind()){
		return user;
            }
            return AI;
        }
	else if (AI.isThreeOfAKind()){
	    return AI;
	}
        else if (user.isThreeOfAKind()){
            return user;
        }
	else if (AI.isTwoPair() && user.isTwoPair()){
            if (user.highestPair() > AI.highestPair()){
		return user;
            }
            return AI;
        }
	else if (AI.isTwoPair()){
	    return AI;
	}
        else if (user.isTwoPair()){
            return user;
        }
	else if (AI.isPair() && user.isPair()){
	    if (user.highestPair() > AI.highestPair()){
                return user;
            }
            return AI;
        }
	else if (AI.isPair()){
	    return AI;
	}
	else if (user.isPair()){
            return user;
        }
	else{
	    if (user.highestValue() > AI.highestValue()){
                return user;
            }
            return AI;
	}
    }
    
    public static void main(String[] args){
	
    }
}
