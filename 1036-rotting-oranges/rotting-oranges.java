class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                int[] current = q.poll();

                int x = current[0];
                int y = current[1];

                // Up
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    fresh--;
                    q.add(new int[]{x - 1, y});
                }

                // Down
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    fresh--;
                    q.add(new int[]{x + 1, y});
                }

                // Left
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    fresh--;
                    q.add(new int[]{x, y - 1});
                }

                // Right
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    fresh--;
                    q.add(new int[]{x, y + 1});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}