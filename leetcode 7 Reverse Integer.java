//leetcode 7 Reverse Integer


//int θε΄ -2^32 ~ 2^32 - 1
//corner case: θΆη

//O(n)
//space: O(1)

public class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
        	res = res * 10 + x % 10;
        	x /= 10;
        	if (res > Integer.MAX_VALUE || res < Integer.MIN_VALIE) return 0;
        }
        return (int)res;
    }
}