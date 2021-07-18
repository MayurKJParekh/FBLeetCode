//leetcode 239 Sliding Window Maximum

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
		int[] res = new int[nums.length - k + 1];
		// Deque stores indexes of elements i, in descending order of nums[i]
		// First : smallet element in current window
		// Last : biggest element in current window
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[i] > nums[deque.peekFirst()]) {
				deque.pollFirst();
			}	
			deque.offerFirst(i);
			// element to remove from sliding window
			if (i - k == deque.peekLast()) deque.pollLast();
			if (i - k + 1 >= 0) res[i - k + 1] = nums[deque.peekLast()];
		}
		return res;
    }
}

/*
Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]
*/
