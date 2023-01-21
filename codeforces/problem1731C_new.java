package codeforces;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

public class problem1731C_new {
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
        /*long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }*/
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
            FastReader in= new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();

            while(testCases-- > 0){



                int n = in.nextInt();
                int ans = n*(n+1)/2;
                //int[] arr = new int[n];
                /*for (int  i =0;i<n;i++){
                    arr[i] = in.nextInt();
                }*/
                int[] arr = Arrays.stream(in.nextLine().split("\\s")).mapToInt(i -> Integer.parseInt(i)).toArray();
                int[] pf = new int[(int)Math.sqrt(2*n)+10];
                int index = 0;
                for(int i = 0;i*i<=2*n;i++){
                    pf[index] = i*i;
                    index++;
                }
                int  cnt = 0;
                int[] xors = new int[n+1];
                xors[0] = 0;
                for(int t=0;t<arr.length;t++){
                    xors[t+1] = xors[t]^arr[t];
                }



                for(int y=0;y<index;y++){

                    //System.out.println(">>"+x);
                   // count = noofxor(arr,x);
                    HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>(2*n+1);
                    //cnt = 0;
                    int xor = 0;

                   // for(int i =0;i<arr.length;i++){
                       // xor = xor^arr[i];
                       // out.println(xor);
                    for(int t = 1;t<n+1;t++) {
                        //out.println(">>" + xors[t]);
                        xor = xors[t];

                        if (freq.get(xor ^ pf[y]) != null) {
                            cnt += freq.get(xor ^ pf[y]);
                        }
                        if (xor == pf[y]) {
                            cnt++;
                        }
                        if (freq.get(xor) != null) freq.put(xor, freq.get(xor) + 1);
                        else freq.put(xor, 1);
                    }

                  //  }






                }

               out.println(ans-cnt);
            }

            out.close();
        } catch (Exception e) {
            return;
        }
    }
    /*public static int noofxor(int[] arr , int B){
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        int cnt = 0;
        int xor = 0;
        for(int i =0;i<arr.length;i++){
            xor = xor^arr[i];
            if(freq.get(xor^B)!=null){
                cnt+=freq.get(xor^B);
            }
            if(xor==B){
                cnt++;
            }
            if(freq.get(xor)!=null)freq.put(xor,freq.get(xor)+1);
            else freq.put(xor,1);

        }
        return cnt;
    }*/
}
