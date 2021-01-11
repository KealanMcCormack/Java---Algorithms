
public class Fibonacci_It {
	static int fibonacciIterative(int n){ //Finds Fibonacci value at n iteratively
		  if (n<=1)
		      return 1; 

		  int fib = 1;
		  int prevFib =  1;

		  for (int i = 2; i < n; i++) { //Adds numbers using a swap motion 
		   int temp = fib;
		   fib = fib + prevFib;
		   prevFib = temp;
		  }
		  return fib;
   }

   public static void main (String args[]){ 
	   long elapsedTime = 0;
		for(int i = 0;i < 10000;i++) {
			final long startTime = System.nanoTime(); 
			fibonacciIterative(25);
			elapsedTime += System.nanoTime() - startTime;  
		}
		
		System.out.println("the time taken " + elapsedTime/10000);  
   }
}
