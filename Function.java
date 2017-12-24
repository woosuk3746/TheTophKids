import java.util.ArrayList;
public class Function{
    //initializes an ArrayList in which the even indexes are the coefficients and the odd indexes are the powers you are raising the polynomial to
    private ArrayList<Integer> polynomial;
    private int degree;//represents the maximum of the even exponents          

    //Overridden Constructor
    public Function(int d, ArrayList a){
        degree = d;
        polynomial = a;
    }
    //toString() method
    public String toString(){
        String ret = "";
        for (int i = 0; i < (polynomial.size() / 2); i++){
	    ret += polynomial.get(2 * i) + "x^" +  polynomial.get(2 * i + 1) + " + ";
	}
	ret = ret.substring(0, ret.length() - 2);
	return ret;
    }
    //returns the ArrayList with the derivative of the polynomial          
    public ArrayList takeDerivative(){
        for (int i = 0; i < polynomial.size(); i++){
            if (i % 2 == 0 && (i != (polynomial.size() - 2))){
		//the coefficient after taking derivative of polynomial is the exponent times the original coefficient
                polynomial.set(i, polynomial.get(i) * polynomial.get(i + 1));
            }
            else if (i % 2 == 1 && (i != (polynomial.size() - 1))){
                if (polynomial.get(i) >= 1){
		    //the degree gets lowered by one
                    polynomial.set(i, polynomial.get(i) - 1);
                }
	    }
	    else if (i == polynomial.size() - 2){
		polynomial.remove(i);//a constant term is shaved off after taking the derivative of it
		polynomial.remove(i);//the degree of the constant term is also shaved off
	    }
	}
	return polynomial;
    }
    //test out methods
    public static void main(String[] args){
        ArrayList<Integer> function = new ArrayList();
        //we are trying to find the derivative of 2x^3 + 9x^2 + 6x + 7         
        function.add(2);
        function.add(3);
        function.add(9);
        function.add(2);
        function.add(6);
        function.add(1);
        function.add(7);
        function.add(0);
        Function x = new Function(3, function);
	System.out.println(function);
	System.out.println(x);//prints out the actual polynomial
        System.out.println(x.takeDerivative());//should return [6,2,18,1,6,0]  
	System.out.println(x);
    }
}
