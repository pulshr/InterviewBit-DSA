/*

Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.



Problem Constraints
1 <= N <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.


*/


public class FirstDepth {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<Integer>[] list = createAdjacencyList(A);
        int[] visitedArr = new int[A.size()+1];
        dfs(C,list,visitedArr);
        return (visitedArr[B]==1)?1:0;
    }
    public ArrayList<Integer>[] createAdjacencyList(ArrayList<Integer> A) {
        ArrayList<Integer>[] res = new ArrayList[A.size()+1];
        for(int i=0;i<res.length;i++) {
            res[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<A.size();i++) {
            res[A.get(i)].add(i+1);
        }
        return res;
    }
    public void dfs(int start, ArrayList<Integer>[] list, int[] visitedArr) {
        visitedArr[start] = 1;
        for(int i=0;i<list[start].size();i++) {
            int neighbour = list[start].get(i);
            if(visitedArr[neighbour]!=1) {
                dfs(neighbour,list,visitedArr);
            }
        }
    }
    public void bfs(int start, ArrayList<Integer>[] list, int[] visitedArr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedArr[start] = 1;  
        while(!queue.isEmpty()) {
            int front = queue.poll();
            for(int i=0;i<list[front].size();i++) {
                int neighbour = list[front].get(i);
                if(visitedArr[neighbour]!=1) {
                    visitedArr[neighbour] = 1;
                    queue.add(neighbour);
                }
            }
        }
    }
}