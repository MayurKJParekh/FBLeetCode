//leetcode 113 Path Sum II

/*
time: O(n)
space: O(h)
*/
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> cur = new ArrayList<Integer>(); 
        pathSum(root, sum, cur, res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return; 
        }
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(cur));
        } else {
            pathSum(root.left, sum - root.val, cur, res);
            pathSum(root.right, sum - root.val, cur, res);
        }
        cur.remove(cur.size() - 1);
    }
}

/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:

Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
*/
