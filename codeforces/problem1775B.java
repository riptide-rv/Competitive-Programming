package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class problem1775B {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        while(t!=0){
            solve(br,pr);
            t--;
        }
        pr.flush();
        pr.close();
    }


    public static void solve(BufferedReader br,PrintWriter pr) throws IOException{
        String[] temp=br.readLine().split(" ");
        long n=Long.parseLong(temp[0]);
        long x=Long.parseLong(temp[1]);
        if(x>n){
            pr.println(-1);
            return;
        }
        else if(x==n){
            pr.println(n);
            return;
        }
        int leftMostOneToZero=-1;
        List<Integer> oneToOne=new ArrayList<>();
        for(int i=0;i<=60;i++){
            if((n&(1L<<i))!=0){
                if((x&(1L<<i))!=0){
                    //x bit=1
                    oneToOne.add(i);
                }
                else{
                    //x bit=0
                    leftMostOneToZero=i;
                }
            }
            else{
                if((x&(1L<<i))!=0){
                    pr.println(-1);
                    return;
                }
            }
        }
        for(int i:oneToOne){
            if(i<leftMostOneToZero){
                pr.println(-1);
                return;
            }
        }
        if((n&(1L<<(leftMostOneToZero+1)))!=0){
            pr.println(-1);
            return;
        }
        long res=(1L<<(leftMostOneToZero+1));
        for(int i=leftMostOneToZero+2;i<=60;i++){
            if((n&(1L<<i))!=0){
                res|=(1L<<i);
            }
        }
        pr.println(res);







    }
}
