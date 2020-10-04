public class Trie{

// Alphabet size (# of symbols) we pick 26 for English alphabet
static final int ALPHABET_SIZE = 26; 


// class for Trie node 
static class TrieNode { 
TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
// isEndOfWord is true if the node represents end of a word i.e. leaf node
boolean isEndOfWord; 
char letter;

public void setEndOfWord() {
	isEndOfWord = true;
}

public void setLetter(char letter) {
	this.letter = letter; 
}


TrieNode(){ 
 isEndOfWord = false; 
 letter = ' ';

 for (int i = 0; i < ALPHABET_SIZE; i++) 
   children[i] = null; 
 } 
}

static TrieNode root;
// If not key present, inserts into trie 
// If the key is prefix of Trie node,  
//  marks leaf node
static void insert(String key){ 
	TrieNode current = root; //Keeps track of current node
	
	
	for(int i = 0;i < key.length();i++) { //loops through word
		if(current.children[(key.charAt(i) - 97)] == null) { 
			TrieNode temp = new TrieNode(); //Creates a Node
			current.children[(key.charAt(i) - 97)] = temp; //Sets value 
			current.children[(key.charAt(i) - 97)].setLetter(key.charAt(i)); //Adds letter value
		}
		
		current = current.children[(key.charAt(i) - 97)];
	}
	
	current.setEndOfWord();

} 

// Returns true if key presents in trie, else false 
static boolean search(String key) { 
TrieNode current = root; //Keeps track of current node
	
	
	for(int i = 0;i < key.length();i++) { //loops through word
		if(current.children[(key.charAt(i) - 97)] == null) {
			return false;
		}
		
		current = current.children[(key.charAt(i) - 97)];
	}
	
	return true;
	
} 


// Driver 
public static void main(String args[]) { 

// Input keys (use only 'a' through 'z' and lower case) 
String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


String output[] = {"Not present in trie", "Present in trie"}; 

root = new TrieNode(); 

// Construct trie 
int i; 
for (i = 0; i < keys.length ; i++) {
insert(keys[i]); 
}

// Search for different keys 
for (i = 0; i < keys.length ; i++) {
System.out.println(search(keys[i])); 
}

} 

//end of class
} 