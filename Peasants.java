public class Peasants {
	public static void main(String[] args) {
		
		int a = 4383, b = 8238;  
		int niters = 100000000;
		final long startTime = System.nanoTime(); 
		
		for(int count = 0;count < niters;count++) {
		  peasantAlg(a, b);
		}
		
		 
		System.out.println(peasantAlg(a,b));
		System.out.println("Time taken " + ((System.nanoTime() - startTime)/(double)niters));  

	}
	
	public static long peasantAlg(int a, int b) {
		long res = 0;
		long lb = b;
		
		while(a >= 1) {
			
			if((a & 1) == 1) {
				res += lb;
			}
			
			a >>= 1;
			lb <<= 1;
			
		}
		return res;
	}
}
