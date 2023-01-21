package codeforces;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.stream.IntStream;

public class problem1731C{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int n = in.nextInt();
                long ans = (long)n*(n+1)/2;
                int[] arr = new int[n];
                for(int k = 0;k<n;k++){
                    arr[k] = in.nextInt();
                }
                int to_check = (int)Math.sqrt(2*n)+1;
                //ArrayList<Integer> pf = new ArrayList<Integer>(to_check);
                long[] pf = new long[to_check];
                for(int i = 0;i<to_check;i++){
                    pf[i] = i*i;
                }

                long[] hash = new long[4*n+1];
                hash[0] = 1;
                int xor = 0;

                for(int elm:arr){
                    xor = xor^elm;
                    for(long p: pf){
                        long  v = xor^p;
                        if(v<=2*n){
                            ans-=hash[(int)v];

                        }

                    }
                    hash[xor]++;
                }
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
