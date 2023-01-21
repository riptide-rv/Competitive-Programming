package codeforces;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class problem1783C {
    private static class FastScanner {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        private FastScanner() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private short nextShort() throws IOException {
            short ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = (short) (ret * 10 + c - '0');
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return (short) -ret;
            return ret;
        }

        private int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = ret * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = ret * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        private char nextChar() throws IOException {
            byte c = read();
            while (c <= ' ') c = read();
            return (char) c;
        }

        private String nextString() throws IOException {
            StringBuilder ret = new StringBuilder();
            byte c = read();
            while (c <= ' ') c = read();
            do {
                ret.append((char) c);
            } while ((c = read()) > ' ');
            return ret.toString();
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    public static void main(String[] args) throws IOException {
       FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int testcases = in.nextInt();
        while (testcases -- >0){
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> arr = new ArrayList<>(n);
            int[] arrc = new int[n];
            for(int i =0;i<n;i++){
                arrc[i] = in.nextInt();
                arr.add(arrc[i]);
            }

            Collections.sort(arr);
            int lastp = -1;
            int lastelem = -1;
            int lastsum = 0;
            int sum = 0;
            for(int  i =0;i<n;i++){
                sum = sum+arr.get(i);
                if(sum<=m){
                    lastsum = sum;
                    lastp = i;
                    lastelem = arr.get(i);
                }else{
                    break;
                }

            }


            int myWinning = lastp +1;
            int mypos ;
            if(myWinning == 0 ){
                mypos = n+1;
            }else if(myWinning==n){
                mypos = 1;
            }else{
                mypos = n -myWinning +1;
                if(lastelem>=arrc[lastp+1] || lastsum - lastelem+arrc[lastp+1]<=m)mypos--;
            }
            out.println(mypos);

        }
        out.flush();
    }
}
