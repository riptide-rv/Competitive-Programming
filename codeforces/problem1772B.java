package codeforces;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class problem1772B {
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

            ArrayList<Integer> arr = new ArrayList<>(4);

            for(int i=0;i<4;i++){
                arr.add(in.nextInt());
            }
            int a =arr.remove(2);
            arr.add(a);
            HashMap<Integer,Integer> hash = new HashMap<>(4);
            hash.put(arr.get(0),0);
            hash.put(arr.get(1),1);
            hash.put(arr.get(3),3);
            hash.put(arr.get(2),2);
            int min = Collections.min(arr);
            int max = Collections.max(arr);
            String ans = "NO";
            if((hash.get(min)+2)%4==hash.get(max)){
               int x = hash.remove(min);
               //out.println("x"+x);
               int y = hash.remove(max);
             //  out.println("y"+y
              // );
               //System.out.println(arr.get((x+1)%4));
               //System.out.println(arr.get((y+1)%4));
               if(arr.get((x+1)%4)>min && arr.get((y+1)%4)>min &&arr.get((x+1)%4)<max && arr.get((y+1)%4)<max)ans = "YES";
            }
            out.println(ans);

        }
        out.flush();
    }
}
