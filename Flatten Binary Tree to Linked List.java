//leetcode 114 Flatten Binary Tree to Linked List
    
/*
time: O(n)
space: O(h)h是高度
思路：1.对右边进行bfs到底，把右边的值赋给prev
2. 把左边的值设为null
3. 把prev的值设为root
*/
public class Solution {
	public void flatten(TreeNode root) {
    	helper(root, null);
	}	
	private TreeNode helper(TreeNode root, TreeNode pre) {
	    if (root == null) return pre;
	    pre = helper(root.right, pre);    
	    pre = helper(root.left, pre);
	    root.right = pre;
	    root.left = null;
	    pre = root;
	    return pre;
	}
}

// morris traversal
// O(1)

public class Solution {
	public void flatten(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
		}
	}
}

/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 
Example 1:

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
*/
