/*

Problem Description
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.



Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109



Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]



Output Format
Return an integer denoting the minimum construction cost.



Example Input
Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output
Output 1:

9
Output 2:

37


Example Explanation
Explanation 1:

We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. 
we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of costruction is 9.
Explanation 2:

We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.


*/

public class Solution {
    int[] parent;
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        parent = new int[A + 1];
        for(int i = 1; i <= A; i++) {
            parent[i] = i;
        }
        ArrayList<Pair> list = new ArrayList<Pair>();
        for(ArrayList<Integer> l : B) {
            int u = l.get(0);
            int v = l.get(1);
            int w = l.get(2);
            list.add(new Pair(u, v, w));
        }
        long sum = 0;
        int mod = 1000000007;
        Collections.sort(list, (p1, p2) -> p1.wt - p2.wt);
        for(int i = 0; i < list.size(); i++) {
            Pair p1 = list.get(i);
            if(root(p1.u) != root(p1.v)) {
                union(p1.u, p1.v);
                sum = (sum + p1.wt)%mod;
            }
        }
        return (int)(sum);
    }

    private int root(int x) {
        if(parent[x] == x) return x;
        parent[x] = root(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y) {
        int rx = root(x);
        int ry = root(y);
        if(rx == ry) return false;
        parent[rx] = ry;
        return true;
    }
}

class Pair {
    int u;
    int v;
    int wt;
    public Pair(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}