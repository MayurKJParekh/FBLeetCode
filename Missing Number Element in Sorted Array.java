// leeetcode 1060 Missing Element in Sorted Array

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        // ceiling
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // amount missing on left
            int missingOnLeft = nums[mid] - nums[0] - mid;
            if (missingOnLeft == k) break;
            else if (missingOnLeft < k) low = mid + 1;
            else high = mid - 1;
        }
        low--; // previous index
        int missingOnLeft = nums[low] - nums[0] - low;
        return nums[low] + k - missingOnLeft;
    }
}

/*
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.

Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.

Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
*/
