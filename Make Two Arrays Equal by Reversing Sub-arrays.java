// leetcode 1460 Make Two Arrays Equal by Reversing Sub-arrays

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : target) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int b : arr) {
            if (!map.containsKey(b)) {
                return false;
            } 
            if (map.get(b) == 1) map.remove(b); 
            else map.put(b, map.get(b) - 1); 
        }
        return map.size() == 0; 
    }
}

/*
Example 1:

Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.
Example 2:

Input: target = [7], arr = [7]
Output: true
Explanation: arr is equal to target without any reverses.
Example 3:

Input: target = [1,12], arr = [12,1]
Output: true
Example 4:

Input: target = [3,7,9], arr = [3,7,11]
Output: false
Explanation: arr doesn't have value 9 and it can never be converted to target.
Example 5:

Input: target = [1,1,1,1,1], arr = [1,1,1,1,1]
Output: true
*/
