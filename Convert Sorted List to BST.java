//leetcode 109 Convert Sorted List to Binary Search Tree


/*
time: O(nlogn)
space: O(logn)
*/
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }
    public TreeNode helper(ListNode head, ListNode tail) {
    	ListNode slow = head;
    	ListNode fast = head;
    	if (head = tail) return null;

    	while (fast != tail && fast.next != tail) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	TreeNode thread = new TreeNode(slow.val);
    	thread.left = helper(head, slow);
    	thread.right = helper(slow.next, tail);
    	return thread;
    }
}

/*
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Input: head = []
Output: []

Input: head = [0]
Output: [0]

Input: head = [1,3]
Output: [3,1]
*/
