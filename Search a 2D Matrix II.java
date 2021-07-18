//leetcode 240 Search a 2D Matrix II

/*
Time: O(mnlogmn)
Space: O(1)
*/
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0)
      return false;

    final int m = matrix.length;
    final int n = matrix[0].length;

    int l = 0;
    int r = m * n;

    while (l < r) {
      final int mid = l + (r - l) / 2;
      final int i = mid / n;
      final int j = mid % n;
      if (matrix[i][j] == target)
        return true;
      if (matrix[i][j] < target)
        l = mid + 1;
      else
        r = mid;
    }

    return false;
  }
}
/*
Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/
