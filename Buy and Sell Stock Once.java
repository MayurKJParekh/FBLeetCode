//leetcode 121 Best Time to Buy and Sell Stock

/*
Time: O(n)O(n)
Space: O(1)O(1)
*/
class Solution {
  public int maxProfit(int[] prices) {
    int sellOne = 0;
    int holdOne = Integer.MIN_VALUE;

    for (final int price : prices) {
      sellOne = Math.max(sellOne, holdOne + price);
      holdOne = Math.max(holdOne, -price);
    }

    return sellOne;
  }
}
