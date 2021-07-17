//leetcode 111 Minimum Depth of Binary Tree


/*
time: O(n)
space: O(n)
*/
bfs
public class Solution {
	public int minDepth(TreeNode root) {
	    if (root == null) return 0;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    int depth = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size(); // determine the loop size
	        for (int i = 0; i < size; i++) {
	            TreeNode node = queue.poll();
	            if (node.left == null && node.right == null) {
	                return depth;
	            }
	            if (node.left != null) {
	                queue.add(node.left);
	            }
	            if (node.right != null) {
	                queue.add(node.right);
	            }
	        }
	        depth++;
	    }
	    return depth;
	}
}

dfs
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}


/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
*/

