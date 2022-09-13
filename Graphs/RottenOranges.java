/*

Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input
Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:

 
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]


Example Output
Output 1:

 4
Output 2:

 -1


Example Explanation
Explanation 1:

 Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
Explanation 2:

 Task is impossible

*/

public class RottenOranges {
    public int solve(int[][] A) {
        Queue<int[]> queue = new LinkedList<>();
        int maxTime = 0;
        int fresh = 0;
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[i].length;j++) {
                if(A[i][j]==2) {
                    queue.add(new int[]{i,j,0});
                } else if(A[i][j]==1) {
                    fresh++;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            int[] y = {-1,0,0,1};
            int[] x = {0,-1,1,0};
            for(int i=0;i<y.length;i++) {
                int row = front[0]+y[i];
                int col = front[1]+x[i];
                int time = front[2];
                if(row>=0 && col>=0 && row<A.length && col<A[0].length && A[row][col]==1) {
                    fresh--;
                    A[row][col] = 2;
                    maxTime = Math.max(maxTime,time+1);
                    queue.add(new int[]{row,col,time+1});
                }
            }
        }
        if(fresh>0) {
            return -1;
        }
        return maxTime;
    }
}
