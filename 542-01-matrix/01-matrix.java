class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];

        // -1 means not visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        // Put all 0s into queue first
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    ans[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {

                int newx = x + dx[k];
                int newy = y + dy[k];

                if (newx >= 0 && newx < m &&
                    newy >= 0 && newy < n &&
                    ans[newx][newy] == -1) {

                    ans[newx][newy] = ans[x][y] + 1;

                    q.add(new int[]{newx, newy});
                }
            }
        }

        return ans;
    }
}