package codeforces;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class problem1368A {
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
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int count = withoutrecursive(a,b,n);
            out.println(count);

        }out.flush();
    }
    /*static int recursive(int a,int b,int n){
        if(a+b>n)return 1;

        if(a>b)return 1 + recursive(a,a+b,n);
        else return 1+ recursive(a+b,b,n);
    }*/
    static int withoutrecursive(int a,int b,int n){
        int count = 0;
        int sum = 0;
        int x=1,y =1,z=0;
        int l,s;
        if(a>b) {l = a;s=b;}
        else {l=b;s=a;}
        while(true){
            count++;
            sum = x*l +y*s;
            if(sum>n)break;
            z = x;
            x = x + y;
            y =z;


        }
        return count;
    }


}
