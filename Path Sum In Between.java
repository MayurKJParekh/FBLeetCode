//leetcode 437 Path Sum III

/*
time: O(nlogn) -> O(n2)
space: O(logn) -> O(n)
*/

class Solution {
  public int pathSum(TreeNode root, int sum) {
    if (root == null)
      return 0;
    return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int dfs(TreeNode root, int sum) {
    if (root == null)
      return 0;
    return (sum == root.val ? 1 : 0) +
        dfs(root.left, sum - root.val) +
        dfs(root.right, sum - root.val);
  }
}

/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
Example 1:

Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
*/
