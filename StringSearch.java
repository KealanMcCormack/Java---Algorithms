
public class StringSearch {

    public static void main(String[] args) 
	{ 
	        //alter to take text file in..
    	String txt = "1111011110111110111011110111101111110111111001111111111";
    	String pat = "1111111";

        
        long endTime = 0;
        long startTime = 0;
        //new KMPsearch().KMPSearch(pat, txt); 
        
        
        for(int i = 0;i < 100000000;i++) {
        	startTime = System.nanoTime(); 
        	bruteForceSubString(pat, txt);
			endTime += System.nanoTime() - startTime;
        }
        
        System.out.println("Time taken " + (endTime / 100000000));
    } 
	  
	public static int bruteForceSubString(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int count = 0;
		
		for(int i = 0;i <= n-m;i++) {
			
			int j;
			for(j = 0;j < m;j++) {
				if(text.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			
			if(j == m) {
				return i;
			}
			
		}
		return -1;
	}
}
