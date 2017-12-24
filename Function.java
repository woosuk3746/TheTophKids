import java.util.ArrayList;
public class Function{
    //initializes an ArrayList in which the even indexes are the coefficients and the odd indexes are the powers you are raising the polynomial to
    private ArrayList<Integer> polynomial;
    private int degree;//represents the maximum of the even exponents          
    public Function(int d, ArrayList a){
        degree = d;
        polynomial = a;
    }
    //returns the ArrayList with the derivative of the polynomial              
    public ArrayList takeDerivative(){
        ArrayList<Integer> ret = new ArrayList();
        for (int i = 0; i < polynomial.size(); i++){
            if (i % 2 == 0 && (i != (polynomial.size() - 2))){
                ret.add(polynomial.get(i) * polynomial.get(i + 1));
            }
            else if (i % 2 == 1){
                if (polynomial.get(i) >= 1){
                    ret.add(polynomial.get(i) - 1);
                }
	    }
	}
        return ret;
    }
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
        System.out.println(x.takeDerivative());//should return [6,2,18,1,6,0]  
    }
}
