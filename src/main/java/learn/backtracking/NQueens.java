package learn.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
 * a queen and an empty space respectively.
 */
public class NQueens {
    private int[] col;
    private int[] diag1;
    private int[] diag2;
    private List<List<String>> ans = new ArrayList<>();
    private int n;

    /**
     *  Time complexity: O(N!)
     *  Space complexity: O(N)
     * @param n
     * @return Collection of solutions
     */
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        col = new int[n];
        diag1 = new int[n*2];
        diag2 = new int[n*2];
        solve(0, new ArrayList<>());
        return ans;
    }

    /**
     *
     * @param r row number
     * @param cur current solution store
     */
    private void solve(int r, ArrayList<String> cur){
        if (r==n){
            ans.add(new ArrayList<>(cur));
            return;
        }
        char[] row = new char[n];
        for(int i = 0;i<row.length;i++){
            row[i]='.';
        }
        for (int c=0;c<n;c++){
            if (col[c] ==1 || diag1[c+r] ==1 || diag2[c-r+n-1] == 1){
                continue;
            }
            row[c] = 'Q';
            cur.add(new String(row));
            col[c] = 1; diag1[c+r] = 1; diag2[c-r+n-1]=1;

            solve(r+1, cur);

            col[c] = 0; diag1[c+r] = 0; diag2[c-r+n-1]=0;
            row[c] = '.';
            cur.remove(cur.size()-1);
        }
    }
}
