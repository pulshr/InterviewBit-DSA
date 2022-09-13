/*

Problem Description
Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 100

0 <= A[i] <= 1



Input Format
The only argument given is the integer matrix A.



Output Format
Return the number of islands.



Example Input
Input 1:

 A = [ 
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [   
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]    
     ]


Example Output
Output 1:

 2
Output 2:

 5


Example Explanation
Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:

 There 5 island in total.

*/

public class NumberOfIslands {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int count = 0;
        for(int i=0;i<A.size();i++) {
            for(int j=0;j<A.get(0).size();j++) {
                if(A.get(i).get(j)==1) {
                    count++;
                    dfs(i,j,A);
                }
            }
        }
        return count;
    }
    public void dfs(int row, int col, ArrayList<ArrayList<Integer>> A) {
        if(row<0 || col<0 || row==A.size() || col==A.get(0).size() || A.get(row).get(col)==0) {
            return;
        }
        A.get(row).set(col,0);
        dfs(row-1,col-1,A);
        dfs(row-1,col,A);
        dfs(row-1,col+1,A);
        dfs(row,col-1,A);
        dfs(row,col+1,A);
        dfs(row+1,col-1,A);
        dfs(row+1,col,A);
        dfs(row+1,col+1,A);
    }
    public void bfs(int row, int col,int[][] A) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            int currRow = front[0];
            int currCol = front[1]; 
            if(currRow>=0 && currRow<A.length && currCol>=0 && currCol<A[0].length && A[currRow][currCol]==1) {
                A[currRow][currCol] = 0;
                queue.add(new int[]{currRow-1,currCol-1});
                queue.add(new int[]{currRow-1,currCol});
                queue.add(new int[]{currRow-1,currCol+1});
                queue.add(new int[]{currRow,currCol-1});
                queue.add(new int[]{currRow,currCol+1});
                queue.add(new int[]{currRow+1,currCol-1});
                queue.add(new int[]{currRow+1,currCol});
                queue.add(new int[]{currRow+1,currCol+1});
            }
        }
    }
}
