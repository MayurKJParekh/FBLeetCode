// leetcode 1424 Diagonal Traverse II

/*
time: O(n)
space: O(n)
*/
class Solution {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, List<Integer>> keyToNums = new HashMap<>(); // key = row + col
    int maxKey = 0;

    for (int i = 0; i < nums.size(); ++i)
      for (int j = 0; j < nums.get(i).size(); ++j) {
        final int key = i + j;
        keyToNums.putIfAbsent(key, new ArrayList<>());
        keyToNums.get(key).add(nums.get(i).get(j));
        maxKey = Math.max(key, maxKey);
      }

    for (int i = 0; i <= maxKey; ++i)
      for (int j = keyToNums.get(i).size() - 1; j >= 0; --j)
        ans.add(keyToNums.get(i).get(j));

    return ans.stream().mapToInt(i -> i).toArray();
  }
}

/*
Example 1:

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]
Example 2:

Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
Example 3:

Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]
Example 4:

Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]
*/
