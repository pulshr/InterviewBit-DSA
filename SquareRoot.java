/*
Square root of a number

Problem Description

Given a number A. Return square root of the number if it is perfect square otherwise return -1.



Problem Constraints

1 <= A <= 108



Input Format

First argument is an integer A.



Output Format

Return an integer which is the square root of A if A is perfect square otherwise return -1.



Example Input

Input 1:

A = 4
Input 2:

A = 1001


Example Output

Output 1:

2
Output 2:

-1


Example Explanation

Explanation 1:

sqrt(4) = 2
Explanation 2:

1001 is not a perfect square.

 */

// Approach 1: TC = O(rootN), SC = O(1) 
// public class SquareRoot {
//     public static int solve(int A) {
//         return (int) Math.sqrt(A);
//     }
// }

//Approach 2: TC = O(logN), SC = O(1)
public class SquareRoot {
    public int solve(int A) {
        long start = 1;
        long end = A;
        while(start<=end) {
            long mid = start + ((end-start)/2);
            long midSq = mid*mid;
            if(midSq==A) {
                return (int) mid;
            } else if(midSq<A) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}