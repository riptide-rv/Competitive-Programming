package codeforces;
import java.io.*;
import java.util.Arrays;

public class problem1777C {
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
            System.out.println("tescase"+testcases);
            int n = in.nextInt();
            int m = in.nextInt();

            int arr[] = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int elem = m-1;
            int j;
            for(j = n-1;j>=0;j--){
                System.out.println("j>>"+j);
                if(arr[j]%m==0){
                    System.out.println("a");
                    break;
                }
            }
            int  i;
            for( i  =j;i>=0;i-- ){
                System.out.println("i>>"+i);
                while(arr[i]%elem==0){
                    //System.out.println("B");
                    elem--;
                    if(elem==1){
                        //System.out.println("C");
                        break;
                    }
                }
                if(elem==1)break;
            }
            int ans;
            System.out.println("i = "+i);
            System.out.println("j = "+ j);

            if(elem!=1){
                ans = -1;
            }else{
                ans = arr[j] - arr[i];
            }
            System.out.println(ans);

        }
    }
}
