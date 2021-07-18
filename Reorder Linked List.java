//leetcode 143 Reorder List


/*
time: O(n)
space: O(1)
*/
class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null)
      return;

    ListNode mid = findMid(head);
    ListNode reversed = reverse(mid);
    merge(head, reversed);
  }

  private ListNode findMid(ListNode head) {
    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;

    return slow;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  private void merge(ListNode l1, ListNode l2) {
    while (l2 != null) {
      ListNode next = l1.next;
      l1.next = l2;
      l1 = l2;
      l2 = next;
    }
  }
}

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
*/
