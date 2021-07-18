//leetcode 137 Single Number II

/*
time: O(n)
space: O(1)
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
    	for(int i = 0; i < A.length; i++){
        	ones = (ones ^ A[i]) & ~twos;
        	twos = (twos ^ A[i]) & ~ones;
    	}
    	return ones;
    }
}
