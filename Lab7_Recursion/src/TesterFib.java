import java.util.ArrayList;

public class TesterFib {

	public static void main(String[] args) {
		
		int test=45;
		
		Pair x= fib(test);
	System.out.println(x.getFirst());
	System.out.println(fib2(test));
	

	
	
}
private static Pair fib(int n) {
		   if (n==0 || n==1) return new Pair<Integer>(1,1) ;
				   
		   Pair<Integer> p = fib(n-1);
		   
		   return new Pair<Integer>(p.getFirst() + p.second(), p.getFirst());
	}

private static long fib2(int n) { 
	   if (n == 1 || n == 0) return 1; 
	   else return fib2(n-1) + fib2(n-2); 
	} 


}