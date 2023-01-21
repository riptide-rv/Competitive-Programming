package codeforces;

import java.util.Scanner;


public class problem1731A {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t>=1){

            int size = sc.nextInt();
            int n = size;
            Long[] arr1 = new Long[n];

            for (int i =0;i<size;i++){
                long elem  = sc.nextLong();
                arr1[i] = elem;
            }
            long pr =1;
            for(int j = 0;j<size;j++){
               pr = pr*arr1[j];
            }
            System.out.println((pr+size-1)*2022);

            t--;
        }
    }

}
