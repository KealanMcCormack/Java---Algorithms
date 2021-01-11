import java.util.Random;


public class Main {
	
	public static void main(String[] args) { //Gives a demonstration of Algorithms and a rough idea of Run times
		System.out.println("A run through of various algorithms included in this repo");
		
		System.out.println("The Russian peasant multiplication Algorithm");
		
		int a = 478, b = 7023;
		
		System.out.println("Values used " + a + " and " + b);
		
		int niters = 1000000;
		long startTime = System.nanoTime(); 
		
		for(int count = 0;count < niters;count++) {
		  Peasants.peasantAlg(a, b);
		}
		double time = ((System.nanoTime() - startTime)/(double)niters);
		 
		System.out.println("Answer is " + Peasants.peasantAlg(a,b));
		System.out.println("Time taken " + time);
		
		
		System.out.println("");
		System.out.println("The Fibonacci Algorithm");
		
		a = 10;
		
		System.out.println("Value used " + a);
		
		startTime = System.nanoTime(); 
		for(int i = 0;i < 100000;i++) {
			Fibonacci.fib(a);
		}
		
		time = ((System.nanoTime() - startTime)/(double)100000);
		System.out.println("Answer is " + Fibonacci.fib(a));
		System.out.println("the time taken " + time); 
		
		
		System.out.println("");
		System.out.println("The Tower of Hanoi Algorithm");
		
		a = 6;
		
		System.out.println("Value used " + a);
		
		startTime = System.nanoTime(); 
		
		TowerOfHanoi.Hanoi(a, "A", "C", "B"); //Run once to avoid filling the console
		
		System.out.println("the time taken " + (System.nanoTime() - startTime)); 
		
		System.out.println("");
		System.out.println("The Selection Sort, Insertion Sort and Stalin Sort ALgorithms");
		
        int n = 100; //Number of variables to be sorted
		
		int[] x = new int[n];
		int[] y = new int[n];
		
		Random rand = new Random();
		
		long endTime = 0;
		long endTime2 = 0;
		startTime = 0;
		
		for(int i = 0;i < 10000;i++) {
			
			for(int j = 0;j < n;j++) { //Fills arrays with random numbers
				int k = rand.nextInt();
				x[j] = k;
				y[j] = k;
			}
			
			startTime = System.nanoTime(); 
			DifferentSorts.selectionSort(x);
			endTime += System.nanoTime() - startTime;
			
			
            startTime = System.nanoTime(); 
            DifferentSorts.insertSort(y);
			endTime2 += System.nanoTime() - startTime;
			
		}
		
		System.out.println("Time taken for Selection Sort " + (endTime / 10000));
		System.out.println("Time taken for Insertion Sort " + (endTime2 / 10000));
		
		System.out.println("Selection Sort sorted array");
		for(int i = 0;i < n;i++) {
			System.out.print(" " + x[i]);
		}
		System.out.println("");
		System.out.println("Insertion Sort sorted array");
		for(int i = 0;i < n;i++) {
			System.out.print(" " + y[i]);
		}
		System.out.println("");
		
		System.out.println("");
		System.out.println("The Merge Sort and Enhanced Merge Sort ALgorithms");
		
		
		n = 100; //Number of variables to be sorted
		
		x = new int[n];
		y = new int[n];
				
		endTime = 0;
		endTime2 = 0;
		startTime = 0;
		
		for(int i = 0;i < 10000;i++) {
			
			for(int j = 0;j < n;j++) { //Fills arrays with random numbers
				int k = rand.nextInt();
				x[j] = k;
				y[j] = k;
			}
			
			startTime = System.nanoTime(); 
			DifferentSorts.mergeSort(x);
			endTime += System.nanoTime() - startTime;
			
			
            startTime = System.nanoTime(); 
            DifferentSorts.improvedMergeSort(y);
			endTime2 += System.nanoTime() - startTime;
			
		}
		
		System.out.println("Time taken for Merge Sort " + (endTime / 10000));
		System.out.println("Time taken for Improved Merge Sort " + (endTime2 / 10000));
		
		System.out.println("Merge Sort sorted array");
		for(int i = 0;i < n;i++) {
			System.out.print(" " + x[i]);
		}
		System.out.println("");
		
		System.out.println("Improved Merge Sort sorted array");
		for(int i = 0;i < n;i++) {
			System.out.print(" " + y[i]);
		}
		System.out.println("");
		
		System.out.println("");
		System.out.println("The Quick Sort and Enhanced Quick Sort ALgorithms");
		
        n = 100; //Number of variables to be sorted
		
		x = new int[n];
		y = new int[n];
				
		endTime = 0;
		endTime2 = 0;
		startTime = 0;
		
		int low = 0, high = n - 1;
		
		for(int i = 0;i < 10000;i++) {
			
			for(int j = 0;j < n;j++) { //Fills arrays with random numbers
				int k = rand.nextInt();
				x[j] = k;
				y[j] = k;
			}
			
			startTime = System.nanoTime(); 
			DifferentSorts.quickSort(x, low, high);
			endTime += System.nanoTime() - startTime;
			
			
            startTime = System.nanoTime(); 
            DifferentSorts.enhancedQuickSort(y, low, high);
			endTime2 += System.nanoTime() - startTime;
			
		}
		
		System.out.println("Time taken for Quick Sort " + (endTime / 10000));
		System.out.println("Time taken for Enhanced Quick Sort " + (endTime2 / 10000));
		
		System.out.println("Quick Sort sorted array");
		for(int i = 0;i < n;i++) {
			System.out.print(" " + x[i]);
		}
		System.out.println("");
		
		System.out.println("Enhanced Quick Sort sorted array");
		for(int i = 0;i < n;i++) {
			System.out.print(" " + y[i]);
		}
		System.out.println("");
		
		System.out.println("");
		System.out.println("The Brute force search and KMP search ALgorithms");
		
		String txt = "ABABDABACDABABCABAB"; 
	    String pat = "ABABCABAB";
	    
	    System.out.println("The text for the search Algorithms " + txt);
	    System.out.println("The pattern for the search Algorithms " + pat);
	    
	    startTime = System.nanoTime(); 
		for(int i = 0;i < 10000;i++) {
			StringSearch.bruteForceSubString(txt, pat);
		}
		
		time = ((System.nanoTime() - startTime)/(double)10000);
		System.out.println("Brute Force answer is " + StringSearch.bruteForceSubString(txt, pat));
		System.out.println("the time taken " + time); 
		
		KMPsearch kmp = new KMPsearch();
		
		System.out.println("KMP search answer is " );
		startTime = System.nanoTime(); 
		kmp.KMPSearch(pat, txt); //Run once to avoid flooding console
		time = (System.nanoTime() - startTime);
		System.out.println("the time taken " + time + " , this is not averaged out so maybe higher than brute force"); 
	}
	
}
