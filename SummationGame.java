/* 
Problem Description

Write a program to find sum all Natural numbers from 1 to N where you have to take N as input from user



Problem Constraints

1 <= N <= 1000



Input Format

A single line representing N



Output Format

A single integer showing sum of all Natural numbers from 1 to N



Example Input

Input 1:

5
Input 2:

10


Example Output

Output 1:

15
Output 2:

55

*/

/*
// Approach 1: TC = O(N) and SC = O(1) 
import java.util.*;
public class SummationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        for(int i=1;i<=num;i++) {
            sum+=i;
        }
        System.out.println(sum);
        scanner.close();
    }
}
 */

// Approach 2: TC = O(1) and SC = O(1) 
import java.util.*;
public class SummationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println((num*(num+1))/2);
        scanner.close();
    }
}