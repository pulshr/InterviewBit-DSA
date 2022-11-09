/**

Problem Description
Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.



Problem Constraints
1 <= N, M <= 100



Input Format
The first argument is a 2-D binary array A.



Output Format
Return an integer denoting the area of the largest rectangle containing only ones.



Example Input
Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0] 
     ]
Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ] 


Example Output
Output 1:

 4
Output 2:

 3


Example Explanation
Explanation 1:

 As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).
Explanation 2:

 As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2).

**/

public class Solution {
    public int maximalRectangle(int[][] A) {
int m = A.length;
int n = A[0].length;

for (int i = 1; i < m; ++i) {
for (int j = 0; j < n; ++j) {
if (A[i][j] == 1) {
A[i][j] = A[i - 1][j] + 1;
}
}
}

int max = 0;
for (int[] a : A) {
max = Math.max(max, getMaxArea(a, getNextLow(a), getPrevLow(a)));
}

return max;
}

int[] getNextLow(int[] in) {
int n = in.length;
Deque<Integer> nl = new LinkedList<>();
int[] ans = new int[n];
for (int i = n - 1; i >= 0; --i) {
while (!nl.isEmpty() && in[nl.peek()] >= in[i]) {
nl.pop();
}
if (nl.isEmpty()) {
ans[i] = n;
} else {
ans[i] = nl.peek();
}
nl.push(i);
}
return ans;
}

//getting previous low array with stack
int[] getPrevLow(int[] in) {
int n = in.length;
int[] ans = new int[n];
Deque<Integer> pl = new LinkedList<>();
for (int i = 0; i < n; ++i) {
while (!pl.isEmpty() && in[pl.peek()] >= in[i]) {
pl.pop();
}
if (pl.isEmpty()) {
ans[i] = -1;
} else {
ans[i] = pl.peek();
}
pl.push(i);
}
return ans;
}
int getMaxArea(int[] h, int[] nl, int[] pl) {
int n = nl.length;
int max = 0;
for (int i = 0; i < n; ++i) {
max = Math.max(max, h[i] * (nl[i] - pl[i] - 1));
}

return max;
}
}
