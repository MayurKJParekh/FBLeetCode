// leetcode 1197 Minimum Knight Moves

/*
time: O(8 * abs(x)* abs(y))
space: O()
*/

class Solution {
    private final static int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, -1}, {-2, 1}};
    public int minKnightMoves(int x, int y) {
    	x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");
       
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                if (r == x && c == y) return count;
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (!visited.contains(nr + "," + nc) && nr >= -1 && nc >= -1) {
                        q.add(new int[] {nr, nc});
                        visited.add(nr + "," + nc);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}

BFS
/*
Time: O(xy)
Space: O(xy)
*/

class Solution {
  public int minKnightMoves(int x, int y) {
    return dp(Math.abs(x), Math.abs(y));
  }

  private Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();

  private int dp(int x, int y) {
    if (x + y == 0) // (0, 0)
      return 0;
    if (x + y == 2) // (0, 2), (1, 1), (2, 0)
      return 2;
    Pair<Integer, Integer> key = new Pair<>(x, y);
    if (memo.containsKey(key))
      return memo.get(key);

    final int minMove = Math.min(
        dp(Math.abs(x - 2), Math.abs(y - 1)),
        dp(Math.abs(x - 1), Math.abs(y - 2))) + 1;
    memo.put(key, minMove);
    return minMove;
  }
}
