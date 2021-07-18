//leetcode 127 Word Ladder

/*
Time: O(|wordList| * 26^{wordList_i})

Space: O(|wordList|)
*/

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord))
      return 0;

    int ans = 0;
    Queue<String> q = new LinkedList<>(Arrays.asList(beginWord));

    while (!q.isEmpty()) {
      ++ans;
      for (int size = q.size(); size > 0; --size) {
        StringBuilder sb = new StringBuilder(q.poll());
        for (int i = 0; i < sb.length(); ++i) {
          final char cache = sb.charAt(i);
          for (char c = 'a'; c <= 'z'; ++c) {
            sb.setCharAt(i, c);
            final String word = sb.toString();
            if (word.equals(endWord))
              return ans + 1;
            if (wordSet.contains(word)) {
              wordSet.remove(word);
              q.offer(word);
            }
          }
          sb.setCharAt(i, cache);
        }
      }
    }

    return 0;
  }
}

/*
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/
