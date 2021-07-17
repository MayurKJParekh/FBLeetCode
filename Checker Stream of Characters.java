// leetcode 1032 Stream of Characters

/*
time: O()
space: O()
*/

class StreamChecker {
    class TrieNode {
	    TrieNode[] children = new TrieNode[26];
	    boolean isWord;
	}
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();;
    public StreamChecker(String[] words) {
        buildTrie(words); 
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.children[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }
    
    public void buildTrie(String[] words) {
	    for (String w : words) {
	        TrieNode node = root;
            int len = w.length();
	        for (int i = len - 1; i >= 0; i--) {
                char c = w.charAt(i);
	            if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
	       }
	       node.isWord = true;
	    }
	}
}

/*
Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.
*/
