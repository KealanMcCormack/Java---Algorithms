class KMPsearch { 
	    void KMPSearch(String pat, String txt) 
	    { 
	        int M = pat.length(); 
	        int N = txt.length(); 
	  
	        // create lps[] that will hold the longest 
	        // prefix suffix values for pattern 
	        int lps[] = new int[M]; 
	        int i = 0; // index for txt
	        int j = 0; // index for pat[] 
	  
	        // Preprocess the pattern (calculate lps[] 
	        // array) 
	        computeLPSArray(pat, M, lps); 
	  
	        
	        while(i < N) {  
	        	if(pat.charAt(j) == txt.charAt(i)) { //If characters match variables are increased
	        		i++;
	        		j++;
	        	}
	        	
	        	if(j == M) { //If j equals M pattern has been found
	        		System.out.println("Pattern found at " + (i - j));
	        		j = lps[j - 1];
	        	}
	        	
	        	//If character match fails
	        	if(i < N && pat.charAt(j) != txt.charAt(i)) {
	        		if(j == 0) {
	        			i++;
	        		}else {
	        			j = lps[j - 1];
	        		}
	        	}
	        }
	        
	    } 
	  
	    void computeLPSArray(String pat, int M, int lps[]) 
	    { 
	        // length of the previous longest prefix suffix 
	        int len = 0; 
	        int i = 1; 
	        lps[0] = 0; // lps[0] is always 0 
	  
	        // the loop calculates lps[i] for i = 1 to M-1 
	        while (i < M) { 
	            if (pat.charAt(i) == pat.charAt(len)) { 
	                len++; 
	                lps[i] = len; 
	                i++; 
	            } 
	            else // (pat[i] != pat[len]) 
	            { 
	                // This is tricky. Consider the example. 
	                // AAACAAAA and i = 7. The idea is similar 
	                // to search step. 
	                if (len != 0) { 
	                    len = lps[len - 1]; 
	  
	                    // Also, note that we do not increment 
	                    // i here 
	                } 
	                else // if (len == 0) 
	                { 
	                    lps[i] = len; 
	                    i++; 
	                } 
	            } 
	        } 
	    } 
	    
	    public int KMPSearchIndexReturn(String pat, String txt) //Function that returns the index
	    { 
	        int M = pat.length(); 
	        int N = txt.length(); 
	  
	        // create lps[] that will hold the longest 
	        // prefix suffix values for pattern 
	        int lps[] = new int[M]; 
	        int i = 0; // index for txt
	        int j = 0; // index for pat[] 
	  
	        // Preprocess the pattern (calculate lps[] 
	        // array) 
	        computeLPSArray(pat, M, lps); 
	  
	        
	        while(i < N) {  
	        	if(pat.charAt(j) == txt.charAt(i)) { //If characters match variables are increased
	        		i++;
	        		j++;
	        	}
	        	
	        	if(j == M) { //If j equals M pattern has been found
	        		return (i - j);
	        	}
	        	
	        	//If character match fails
	        	if(i < N && pat.charAt(j) != txt.charAt(i)) {
	        		if(j == 0) {
	        			i++;
	        		}else {
	        			j = lps[j - 1];
	        		}
	        	}
	        }
	        return -1;
	    } 
	  
	    // Driver program to test above function 
	    public static void main(String args[]) 
	    { 
	    	String txt = "1111011110111110111011110111101111110111111001111111111";
	    	String pat = "1111111";
	        
	        long endTime = 0;
	        long startTime = 0;
	        //new KMPsearch().KMPSearch(pat, txt); 
	        System.out.println(new KMPsearch().KMPSearchIndexReturn(pat, txt) );
	        
	        KMPsearch kmp = new KMPsearch(); 
	        for(int i = 0;i < 100000000;i++) {
	        	startTime = System.nanoTime(); 
	        	kmp.KMPSearchIndexReturn(pat, txt);
				endTime += System.nanoTime() - startTime;
	        }
	        
	        System.out.println("Time taken " + (endTime / 100000000));
	    } 
	} 