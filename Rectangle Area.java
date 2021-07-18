//leetcode 223 Rectangle Area

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int together;
        if (C <= E || A >= G || B >= H || D <= F) {
        	together = 0;
        } else {
        	int x = Math.min(C, G) - Math.max(A, E);
        	int y = Math.min(D, H) - Math.max(B, F);
        	together = x * y;
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - together;
    }
}
/*
Example 1:

Rectangle Area
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45
Example 2:

Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
Output: 16
*/
