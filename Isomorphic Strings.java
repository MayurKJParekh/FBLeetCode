// leetcode 205 Isomorphic Strings

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
		int[] book = new int[128];
		for (int i = 0; i < s.length(); i++) {
			int cs = (int) s.charAt(i);
			int ts = (int) t.charAt(i);
			if (map[cs] == 0 && book[ts] == 0) {
				map[cs] = ts;
				book[ts] = 1;
			} else if (map[cs] != ts)
				return false;
		}
		return true;
    }
}

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
*/
