package codeforces;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.Arrays;
import java.util.stream.StreamSupport;

public class problem1771A {
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
            long x = n;
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = in.nextInt();

            }
            Arrays.sort(arr);
            long mincount = 0;
            int min = arr[0];
            long mxcount = 0;
            int max = arr[n-1];
            long count;
            if(min == max){
               count = x*(x-1);
            }else {
                for (int i = 0; i < n; i++) {
                    if (arr[i] != min) {
                        break;

                    }
                    mincount++;
                }
                for (int i = n - 1; i >= 0; i--) {
                    if (arr[i] != max) {
                        break;

                    }
                    mxcount++;
                }
                count = mxcount*mincount*2;
            }

            out.println(count);



        }
        out.flush();
    }
}
