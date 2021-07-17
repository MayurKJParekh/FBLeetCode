//leetcode 122 Best Time to Buy and Sell Stock II


/*
time: O(n)
space: O(1)
*/
class Solution {
  public int maxProfit(int[] prices) {
    int sell = 0;
    int hold = Integer.MIN_VALUE;

    for (final int price : prices) {
      sell = Math.max(sell, hold + price);
      hold = Math.max(hold, sell - price);
    }

    return sell;
  }
}
