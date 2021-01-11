import java.lang.reflect.Array;
import java.util.ArrayList;

public class MergeSort {

	public ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> mergeArray = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> temps = new ArrayList<Integer>();
		
		if(a.size() == 1) {
			return a;
		}
		int i = a.size() / 2;
		
		for(int count = 0;count < i;i++) {
			temp.add((Integer) a.remove(count));
		}
		temps.addAll(a);
		left.addAll(mergeSort(temp));
		right.addAll(mergeSort(temps));
		
		mergeArray = merge(left, right);
		return mergeArray;
	}
	
	public ArrayList<Integer> merge( ArrayList<Integer> a,  ArrayList<Integer> b) {
		ArrayList<Integer> S = new ArrayList<Integer>();
		
		while(a.size() != 0 && b.size() != 0) {
			if(a.get(0) <= b.get(0)) {
				S.add(a.remove(0));
			
			}else {
				S.add(b.remove(0));
				
			}
		}
		
		if(a.size() != 0) {
			S.addAll(a);
		}else {
			S.addAll(b);
		}
		return S;
	}
}
