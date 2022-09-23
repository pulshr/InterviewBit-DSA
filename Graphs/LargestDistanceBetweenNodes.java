/*

Problem Description
Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints
2 <= |A| <= 40000



Input Format
First and only argument is vector A



Output Format
Return the length of the longest path



Example Input
Input 1:

 
A = [-1, 0]
Input 2:

 
A = [-1, 0, 0]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 Path is 0 -> 1.
Explanation 2:

 Path is 1 -> 0 -> 2.


*/

public class Solution {
    public int ans = 0;
    public int dfs(List<List<Integer> > adjList,int source,boolean [] visited){
        visited[source] = true;
        int o = 1;
        int maxi1 = 0;
        int maxi2 = 0;
        for(int u : adjList.get(source)){
            if(!visited[u]){
                int s = dfs(adjList,u,visited);
                if(s >= maxi1){
                    maxi2 = maxi1;
                    maxi1 = s;
                }
                else if(s >= maxi2)
                {
                    maxi2 = s;
                }
                o = Math.max(o,s + 1);
            }
        }
        ans = Math.max(maxi1 + maxi2,ans);
        return o;
    }
    public int solve(int[] A) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean [] visited = new boolean[A.length];
        Arrays.fill(visited,false);
        boolean isEmpty = true;
        for(int i = 0 ; i < A.length ; ++i){
            adjList.add(new ArrayList<>());
        }
        for(int i = 1 ; i < A.length ; ++i){
            adjList.get(A[i]).add(i);
            adjList.get(i).add(A[i]);
            isEmpty = false;
        }
        dfs(adjList,0,visited);
        return ans;
    }
}