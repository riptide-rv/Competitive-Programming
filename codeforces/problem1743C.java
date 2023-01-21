package codeforces;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class problem1743C {
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
            String s = in.nextString();
            char[] lids = s.toCharArray();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = in.nextInt();
            }
            long sum =0;
            for(int i =0;i<n-1;i++){

                if(lids[i]=='0'){

                    if(lids[i+1]=='0')continue;
                    int end = i+1;
                    while(end<n && lids[end]=='1')end++;
                    int x ;
                    for( x = i+1;x<end;x++){

                        if(arr[i]>=arr[x]){

                            lids[i] = '1';

                            lids[x] = '0';
                            i = x;

                        }

                    }
                    i = x-1;


                    //if(arr[i]<arr[i+1])continue;
                   // sum = sum+arr[i];
                    //if(i<n-1)lids[i+1]='0';
                }

            }
            //if(lids[n-1]=='1')sum+=arr[n-1];
            /*for(char se:lids){
                System.out.println(se);
            }*/
            for(int i = 0;i<n;i++){
                if(lids[i]=='1')sum+=arr[i];
            }

            out.println(sum);

        }
        out.flush();
    }
}
