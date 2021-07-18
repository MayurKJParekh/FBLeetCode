//leetcode 209 Minimum Size Subarray Sum

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if (s < 0 || nums == null || nums.length == 0) return 0;
        int sum = 0, j = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                len = Math.min(len, i - j + 1);
                sum -= nums[j++];
            }
        }
        return (len == Integer.MAX_VALUE) ? 0 : len;
    }
}

/*
Given an array of positive integers nums and a positive integer target, 
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
*/
