
public class Fibonacci {
	public static void main(String[] args) {
		long elapsedTime = 0;
		for(int i = 0;i < 10000;i++) {
			final long startTime = System.nanoTime(); 
			fib(5);
			elapsedTime += System.nanoTime() - startTime;  
		}
		
		System.out.println("the time taken " + elapsedTime/10000);  
	}
	
	public static int fib(int n) {
		
		if(n <= 2) {
			return 1;
		}
		
		return fib(n - 1) + fib(n-2);
	}
}
