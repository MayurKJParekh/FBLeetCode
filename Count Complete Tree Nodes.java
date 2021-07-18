//leetcode 222 Count Complete Tree Nodes

/*
time: O(log^2n)
space: O(1)
*/

class Solution {
  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;

    TreeNode l = root;
    TreeNode r = root;
    int heightL = 0;
    int heightR = 0;

    while (l != null) {
      ++heightL;
      l = l.left;
    }

    while (r != null) {
      ++heightR;
      r = r.right;
    }

    if (heightL == heightR) // root is a complete tree
      return (int) Math.pow(2, heightL) - 1;

    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
/*
Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
*/
