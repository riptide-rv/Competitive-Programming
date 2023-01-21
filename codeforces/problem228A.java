package codeforces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class problem228A {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int unique = 0;
        HashSet<Long> h = null;
        List<Long> list =  new ArrayList<Long>(4);
        for(int i =0;i<4;i++){
            long a = sc.nextInt();
            list.add(a);
            h = new HashSet<Long>(list);

            




        }
        System.out.print(4-h.size());
    }
}
