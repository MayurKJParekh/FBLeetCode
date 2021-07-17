//leetcode 1091 Shortest Path in Binary Matrix

/*
time: O(mn)
space: O(mn)
*/

class Solution {

	private int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, 
									{1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
        	return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        int res = 0;
        while (!queue.isEmpty()) {
        	for (int i = queue.size(); i > 0; i--) {
        		int[] cur = queue.poll();
        		if (cur[0] == n - 1 && cur[1] == n - 1) {
        			return res + 1;
        		}

        		for (int k = 0; k < 8; k++) {
        			int x0 = cur[0] + dir[k][0];
        			int y0 = cur[1] + dir[k][1];

        			if (x0 >= 0 && x0 < n && y0 >= 0 && y0 < n && grid[x0][y0] == 0) {
        				queue.offer(new int[] {x0, y0});
        				grid[x0][y0] = ~grid[x0][y0];
        			} 
        		}
        	}
        	res++;
        }
        return -1;
    }
}

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
*/
