
public class TowerOfHanoi {
	public static void main(String[] args) {
		int n = 12;
		
		
		
		long elapsedTime = 0;
		for(int i = 0;i < 10000;i++) {
			final long startTime = System.nanoTime(); 
			Hanoi(n, "A", "C", "B");
			elapsedTime += System.nanoTime() - startTime;  
		}
		
		System.out.println("the time taken " + elapsedTime/10000);  
   
	}
	
	public static void Hanoi(int n, String source,String dest,String aux ) {
		if(n==1) {
			System.out.println("Disk 1 to " + dest + " from " + source);
		}else {
			  Hanoi(n - 1, source, aux, dest);  
			  System.out.println("Disk " + n + " to " + source + " " + dest);
			  Hanoi(n - 1, aux, dest, source); 

		}
	}
	
}
