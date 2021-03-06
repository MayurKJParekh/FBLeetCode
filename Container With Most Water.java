//leetcode 11 Container With Most Water


//O(n)
//space: O(1)
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while(l < r) {
        	res = Math.max(res, Math.min(height[l], height[r]) * (r - l)); //面积
        	if(height[l] < height[r]) {
        		l++;
        	} else r--;
        }
        return res;
    }
}

/*
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2
*/
