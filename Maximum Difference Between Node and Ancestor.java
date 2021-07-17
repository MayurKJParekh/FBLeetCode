//leetcode 1026 Maximum Difference Between Node and Ancestor

/*
time: O(n)
space: O()
*/

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val); // initialize both max and min with root.val.
    }
    private int dfs(TreeNode n, int max, int min) {
        if (n == null) return 0;    // base case.
        max = Math.max(n.val, max); // update max.
        min = Math.min(n.val, min); // update min.
        int l = dfs(n.left, max, min); // recurse down.
        int r = dfs(n.right, max, min); // recurse down.
        return Math.max(max - min, Math.max(l, r)); // compare all super/sub differences to get result.
    }
}

/*
Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.

 

Example 1:


Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
Example 2:


Input: root = [1,null,2,null,0,3]
Output: 3
*/
