//leetcode 139 Word Break


/*
time: O(n^3)
space: O(n)
*/

// Bottom Up
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    final int n = s.length();

    Set<String> wordSet = new HashSet<>(wordDict);
    boolean[] dp = new boolean[n + 1]; // dp[i] := true if s[0..i) can be segmented
    dp[0] = true;

    for (int i = 1; i <= n; ++i)
      for (int j = 0; j < i; ++j)
        // s[0..j) can be segmented and s[j..i) in wordSet
        // so s[0..i) can be segmented
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }

    return dp[n];
  }
}

//Top Down
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);
    Map<String, Boolean> memo = new HashMap<>();
    return wordBreak(s, wordSet, memo);
  }

  private boolean wordBreak(final String s, Set<String> wordSet, Map<String, Boolean> memo) {
    if (memo.containsKey(s))
      return memo.get(s);
    if (wordSet.contains(s)) {
      memo.put(s, true);
      return true;
    }

    // 1 <= prefix.length() < s.length()
    for (int i = 1; i < s.length(); ++i) {
      final String prefix = s.substring(0, i);
      final String suffix = s.substring(i);
      if (wordSet.contains(prefix) && wordBreak(suffix, wordSet, memo)) {
        memo.put(s, true);
        return true;
      }
    }

    memo.put(s, false);
    return false;
  }
}



/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
*/
