package learn.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {
    /**
     * Time complexity: O(MxN)
     * Space complexity: O(min(M,N))
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows==0)
            return 0;
        int cols = grid[0].length;

        Queue<Integer> queue = new LinkedList<>(); // space O(min(M,N))
        int result = 0;

        for (int i = 0; i < rows; i++) { // T(MxN) + T(MxN) -> O(MxN)
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){ //T(N) + T(MxN)
                    result++;
                    grid[i][j]='0';
                    queue.add(i * cols + j);
                    while (!queue.isEmpty()){ // worst case T(MxN) one time
                        var item = queue.remove();
                        int r = item/cols;
                        int c = item%cols;

                        if (r>0 && grid[r-1][c]=='1') {
                            queue.add((r - 1) * cols + c);
                            grid[r-1][c] = '0';
                        }
                        if (r<rows-1 && grid[r+1][c]=='1') {
                            queue.add((r + 1) * cols + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c>0 && grid[r][c-1]=='1') {
                            queue.add(item - 1);
                            grid[r][c-1] = '0';
                        }
                        if (c<cols-1 && grid[r][c+1]=='1') {
                            queue.add(item + 1);
                            grid[r][c+1] = '0';
                        }
                    }
                }
            }
        }

        return result;

    }
}
