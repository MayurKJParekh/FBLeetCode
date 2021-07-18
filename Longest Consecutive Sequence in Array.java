//leetcode 128 Longest Consecutive Sequence


/*
time: O(n)
space: O(n)
*/

class Solution {
  public int longestConsecutive(int[] nums) {
    int ans = 0;
    Set<Integer> seen = new HashSet<>();

    for (final int num : nums)
      seen.add(num);

    for (int num : nums) {
      // num is the start of a sequence
      if (seen.contains(num - 1))
        continue;
      int length = 1;
      while (seen.contains(++num))
        ++length;
      ans = Math.max(ans, length);
    }

    return ans;
  }
}

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/
