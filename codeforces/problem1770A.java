package codeforces;

import  java.util.*;
import java.io.*;
public class problem1770A{

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
                List<Long> given = new ArrayList<>(n);
                List<Long> replace = new ArrayList<>(m);
                for(int a =0;a<n;a++){
                    given.add(in.nextLong());
                }
                for (int b = 0;b<m;b++){
                    replace.add(in.nextLong());
                }
                Collections.sort(given);
               // Collections.sort(replace);

                long sum =0;
                if(n>=m){
                    for(int i =m;i<n;i++){
                        sum+=given.get(i);
                    }

                    given = given.subList(0,m);
                }



                    for(int i =0;i<replace.size();i++){

                        given.remove(0);
                        given.add(replace.get(i));
                        Collections.sort(given);

                    }

                if(given.isEmpty())System.out.println("y");
                for(long x:given){
                    sum+=x;
                }

                System.out.println(sum);


        }
    }
}