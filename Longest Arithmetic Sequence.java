//leetcode 1027 Longest Arithmetic Sequence

/*
time: O(n^2)
space: O(n^2)
*/

class Solution {
	public int longestArithSeqLength(int[] A) {
        if (A.length <= 1) return A.length;
        int longest = 0;
        // Declare a dp array that is an array of hashmaps.
        // The map for each index maintains an element of the form-
        //   (difference, length of max chain ending at that index with that difference).        
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < A.length; ++i) {
            // Initialize the map.
            dp[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 1; i < A.length; ++i) {
            int x = A[i];
            // Iterate over values to the left of i.
            for (int j = 0; j < i; ++j) {
                int y = A[j];
                int d = x - y;  
                // We at least have a minimum chain length of 2 now,
                // given that (A[j], A[i]) with the difference d, 
                // by default forms a chain of length 2.
                int len = 2;   
                if (dp[j].containsKey(d)) {
                    // At index j, if we had already seen a difference d,
                    // then potentially, we can add A[i] to the same chain
                    // and extend it by length 1.
                    len = dp[j].get(d) + 1;
                }
                // Obtain the maximum chain length already seen so far at index i 
                // for the given differene d;
                int curr = dp[i].getOrDefault(d, 0);
                // Update the max chain length for difference d at index i.
                dp[i].put(d, Math.max(curr, len));
                // Update the global max.
                longest = Math.max(longest, dp[i].get(d));
            }
        }
        return longest;
    }
}

/*
Given an array of integers A, A returns the length of the longest sequence of arithmetic.

Recall A sequence is a list of A [i_1], A [i_2], ..., A [i_k] where 0 <= i_1 <i_2 <... <i_k <= A.length - 1. And if B [i + 1] - B [i] (0 <= i <B.length - 1) values ​​are identical, then B is a sequence of arithmetic.

Example 1
Input: [3,6,9,12]
Output: 4
Explanation:
is the tolerance of the entire array 3 of the arithmetic sequence.

Example 2
Input: [9,4,7,2,10]
Output: 3
Explanation:
is the longest arithmetic sequence [4,7,10].

Example 3
Input: [20,1,15,3,10,5,8]
Output: 4
Explanation:
is the longest arithmetic sequence [20,15,10,5].
*/
