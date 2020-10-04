import java.util.ArrayList;
import java.util.Random;

public class DifferentSorts {
	
	public static void main(String[] args) {
		int n = 100;
		
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		
		Random rand = new Random();
		
		
		
		long endTime = 0;
		long endTime2 = 0;
		long endTime3 = 0;
		long startTime = 0;
		
		int low = 0, high = n - 1;
		
		
			
			for(int j = 0;j < n;j++) {
				int z = rand.nextInt();
				a[j] = z;
				
			}
			
			improvedMergeSort(a);
			
			for(int i = 0;i < a.length;i++) {
				System.out.print(" " + a[i]);
			}
			
			
	
		
	}

	public static void selectionSort (int arr[]){
	    int temp;
	    int min_index;

		for (int i = 0; i < arr.length -1; i++){ //runs though array to find lowest value
	           min_index = i; 
	          for (int j = i + 1; j < arr.length; j++){
	               if (arr[min_index] > arr[j]){
	                      min_index = j;
	                   }
	   //swap arr[i] & arr[min_index]   
	   temp = arr[i] ;
	   arr[i] = arr[min_index]; //swaps lowest value with where the pointer sits
	   arr[min_index] = temp; 

     }	
  }
}
	
public static void mergeSort(int[] a) {
	int n = a.length;
	
	if(n == 1) {
		return;
	}
	
	int mid = n/2; //Splits array
	int[] left = new int[mid];  
	int[] right = new int[n - mid];  
	
	for(int i = 0;i < mid;i++) {
		left[i] = a[i];
	}
	
	for(int i = mid;i < n;i++) {
		right[i - mid] = a[i];
	}
	
	mergeSort(left); //Divide and conquer
	mergeSort(right);
	
	merge(left, right, a); //Merges separated arrays into the original
	

}

public static void merge(int[] left, int[] right,int[] a) {
	int i = 0, j = 0, k = 0;
	while(i < left.length && j < right.length) { //merges arrays based on value stored at index
		if(left[i] <= right[j]) {
			a[k++] = left[i++];
		}else {
			a[k++] = right[j++];
		}
	}
	
	while(i < left.length) //Merges leftovers 
		a[k++] = left[i++];
	
	while(j < right.length)
		a[k++] = right[j++];
}

public static void improvedMerge(int[] left, int[] right,int[] a) {
	int mid = a.length / 2;
	if(left[mid - 1] <= right[0]) { //Allows a quicker merge
		int i = 0, j = 0;
		while(i < left.length) {
			a[i] = left[i];
			i++;
		}
			
		while(j < right.length) {
			a[i] = right[j];
			i++;
			j++;
		}
		return;
	}
	
	int i = 0, j = 0, k = 0;
	while(i < left.length && j < right.length) {//merges arrays based on value stored at index
		if(left[i] <= right[j]) {
			a[k++] = left[i++];
		}else {
			a[k++] = right[j++];
		}
	}
	
	while(i < left.length)
		a[k++] = left[i++];
	
	while(j < right.length)
		a[k++] = right[j++];
}

public static void improvedMergeSort(int[] a) {
	int n = a.length;
	
	if(a.length <= 1 + CUTOFF) { //Speed up by using insertion for small arrays
		insertSort(a);
		return;
	}
	
	int mid = n/2;
	int[] left = new int[mid];  
	int[] right = new int[n - mid];  
	
	for(int i = 0;i < mid;i++) {
		left[i] = a[i];
	}
	
	for(int i = mid;i < n;i++) {
		right[i - mid] = a[i];
	}
	
	improvedMergeSort(left);
	improvedMergeSort(right);
	
	
	improvedMerge(left, right, a);
}
	
	


	
public static void insertSort (int arr[]){
        
        for (int i = 1; i < arr.length; ++i) { //loops through array
            int key = arr[i];
            int j = i -1;
            
            while (j >= 0 && arr[j] > key){
            arr[j+1] = arr[j];
            j = j-1;
            arr[j+1] = key;
        }
      }
    }
	

public static void stalinSort(int arr[]) { //The greatest sort
	int ans[] = new int[arr.length];
	int check = arr[0];
	ans[0] = check;
	
	for(int count = 1;count < arr.length;count++) { //Finds all value greater than the start value
		if(check < arr[count]) {
			check = arr[count];
			ans[count] = check;
		}
	}
	
	for(int count = 1;count < arr.length;count++) { //Adds all values the were in order back into the array
		arr[count] = ans[count];
	}
}

public static void quickSort(int arr[],int low,int high) {
	if(low < high) {
		int pi = partition(arr, low, high);
		
		quickSort(arr, low, pi - 1);
		quickSort(arr, pi + 1, high);
	}
}

public static int partition(int arr[],int low,int high) {
	int pivot = arr[high];
	int i = low - 1;
	
	for(int j = low;j<=high - 1;j++) {
		if(arr[j] < pivot) {
			i++;
			int swap = arr[j];
			arr[j] = arr[i];
			arr[i] = swap;
		}
	}
	
	int swap = arr[i + 1];
	arr[i + 1] = arr[high];
	arr[high] = swap;
	
	return (i+1);
}

public static void shuffle(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        // choose index uniformly in [0, i]
        int r = (int) (Math.random() * (i + 1)); //Randomly mixes an array
        int swap = arr[r];
        arr[r] = arr[i];
        arr[i] = swap;
    }
}

static final int CUTOFF = 10;

public static void enhancedQuickSort(int arr[], int low, int high) {
	shuffle(arr);
	
	if(high <= low + CUTOFF - 1) { //Uses insertion sort for small arrays
		insertSort(arr, low, high);
		return;
	}
	
	int median = (low + high + (arr.length / 2)) / 3;
	int swap = arr[median];
	arr[median] = arr[low];
	arr[low] = swap;
	
	if(low < high) {
		int pi = partition(arr, low, high);
		
		quickSort(arr, low, pi - 1);
		quickSort(arr, pi + 1, high);
	}
}

private static void insertSort(int[] arr, int low, int high) { //sorts part of an array
	for (int i = low + 1; i <= high; i++) {
        int key = arr[i];
        int j = i -1;
        
        while (j >= 0 && arr[j] > key){
        arr[j+1] = arr[j];
        j = j-1;
        arr[j+1] = key;
    }
  }
	
}

}