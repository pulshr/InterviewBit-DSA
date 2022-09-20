/*

Problem Description
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints
1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format
The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format
Return an integer representing the minimal cost required.



Example Input
Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output
Output 1:

 6
Output 2:

 6

*/

public class Solution {
    int max=100009;
    int[] parent=new int[max];
    int[] rank=new int[max];
    ArrayList<Node> adj;
    public void graph(){
        adj=new ArrayList<Node>();
        for(int i=0;i<max;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public int solve(int A, int[][] B) {
        graph();
        PriorityQueue<Node> pq=new PriorityQueue<>(new CustomComparator());
        DisjointSet d=new DisjointSet();
        for(int[] row:B){
            pq.add(new Node(row[0],row[1],row[2]));
        }
        int cost=0;
        while(!pq.isEmpty()){
            Node x=pq.poll();
            if(d.findParent(x.u)!=d.findParent(x.v)){
                cost+=x.getWeight();
                d.union(x.getU(),x.getV());
            }
        }
        return cost;
    }
    class Node{
        int u;
        int v;
        int weight;
        public Node(int u,int v,int weight){
            this.u=u;
            this.v=v;
            this.weight=weight;
        }
        int getU(){
            return u;
        }
        int getV(){
            return v;
        }
        int getWeight(){
            return weight;
        }
    }
    class CustomComparator implements Comparator<Node>{
        public int compare(Node node1,Node node2){
            return node1.getWeight()-node2.getWeight();
        }
    }
    class DisjointSet{
        public int findParent(int u) {
            if(parent[u]==u) return u;
            return parent[u]=findParent(parent[u]);
        }
        public void union(int u,int v){
            u=findParent(u);
            v=findParent(v);
            if(u==v) return;
            if(rank[u]<rank[v]) {
                parent[u]=v;
            }
            else if(rank[v]<rank[u]){
                parent[v]=u;
            }
            else{
                parent[v]=u;
                rank[u]++;
            }
        }
    }
}