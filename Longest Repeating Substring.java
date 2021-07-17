// leetcode 1062 Longest Repeating Substring

/*
time: O(n^2)
space: O(n^2)
dp[i][j] means longest repeating substring that ends at i and j position of the string.

if s[i] == s[j] then dp[i][j] = dp[i - 1][j - 1] + 1;
else dp[i][j] = 0
*/

class Solution {
    public int longestRepeatingSubstring(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];//dp[i][j] means # of repeated chars for substrings ending at i and j
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}

/*
Input: "abcd"
Output: 0
Explanation: There is no repeating substring.

Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.

Input: "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs <wyn>3</wyn> times.

Input: "aaaaa"
Output: 4
Explanation: The longest repeating substring is "aaaa", which occurs twice.
*/
