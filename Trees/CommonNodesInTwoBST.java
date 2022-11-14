/**

Problem Description
Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .

In case there is no common node, return 0.

NOTE:

Try to do it one pass through the trees.



Problem Constraints
1 <= Number of nodes in the tree A and B <= 105

1 <= Node values <= 106



Input Format
First argument represents the root of BST A.

Second argument represents the root of BST B.



Output Format
Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .



Example Input
Input 1:

 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
Input 2:

  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11


Example Output
Output 1:

 17
Output 2:

 46


Example Explanation
Explanation 1:

 Common Nodes are : 2, 15
 So answer is 2 + 15 = 17
Explanation 2:

 Common Nodes are : 7, 2, 1, 10, 15, 11
 So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
 
**/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int solve(TreeNode A, TreeNode B) {
        ArrayList<Integer> inOrderA = inOrder(A);
        ArrayList<Integer> inOrderB = inOrder(B);
        long sum = 0;
        int mod = 1000000007;
        int p1 = 0;
        int p2 = 0;
        while(p1<inOrderA.size() && p2<inOrderB.size()) {
            int aVal = (int) inOrderA.get(p1);
            int bVal = (int) inOrderB.get(p2);
            if(aVal==bVal) {
                sum+=aVal;
                sum%=mod;
                p1++;
                p2++;
            } else if(aVal<bVal) {
                p1++;
            } else {
                p2++;
            }
        }
        return (int) (sum%mod);
    }
    public ArrayList<Integer> inOrder(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode curr = A;
        while(curr!=null) {
            if(curr.left==null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr) {
                    pred = pred.right;
                }
                if(pred.right==null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
