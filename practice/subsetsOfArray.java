package practice;

import java.net.Inet4Address;
import java.util.Scanner;
import java.util.Vector;

public class subsetsOfArray {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Vector<Integer> arr = new Vector<>(n);
        for(int  i = 0;i<n;i++){
            arr.add(in.nextInt());
        }

        Vector<Vector<Integer>> ans = subsetsrecursion(arr);
        System.out.println(ans);
    }


    static Vector<Vector<Integer>> subsetsmask(int n,Vector<Integer> arr){
        int maskcount = 1<<n;
        Vector<Vector<Integer>> ans =new Vector<Vector<Integer>>(maskcount);
        for(int mask = 0;mask<maskcount;mask++){
            Vector<Integer> subset = new Vector<Integer>(n);
            for(int i = 0;i<n;i++){

                if((mask&(1<<i))!=0){
                    subset.add(arr.get(i));

                }
            }
            ans.add(subset);

        }
        return ans;
    }
    static Vector<Vector<Integer>> subsetsrecursion(Vector<Integer> arr){
        Vector<Vector<Integer>> ans = new Vector<>();
        Vector<Integer> temp = new Vector<Integer>();
        generate(ans,0,temp,arr);
        return ans;
    }
    static void generate(Vector<Vector<Integer>> ans,int i ,Vector<Integer> temp,Vector<Integer> arr ){
        if(i==arr.size()){
            ans.add(new Vector<>(temp));
            return;
        }
        //System.out.println(temp);
        Vector<Integer> temp2 = new Vector<Integer>(temp);

        generate(ans,i+1,temp2,arr);
        temp2.add(arr.get(i));
        generate(ans,i+1,temp2,arr);
    }


}


