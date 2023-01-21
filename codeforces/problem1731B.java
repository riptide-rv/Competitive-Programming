package codeforces;

import java.util.Scanner;


public class problem1731B {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>=1){
            long  n = sc.nextLong();
            long mod  = 1000000007;
            long l = mod;
            long sum = ((( (n*(n+1)) %mod)*(4*n-1))%mod*337)%mod;
            System.out.println(sum);
            t--;
        }
    }

}
