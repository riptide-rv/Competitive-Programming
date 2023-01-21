package codeforces;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class problem1763B {
    static class Monster{
        int health,power;
        Monster(int p,int h){
            this.health = h;
            this.power = p;
        }
    }
    static class Comp implements Comparator<Monster> {
        @Override
        public int compare(Monster a, Monster b) {
            if(a.power==b.power)return Integer.compare(a.health, b.health);
            return Integer.compare(a.power,b.power);
        }
    }
    private static class FastScanner {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        private FastScanner()  {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

       /* private short nextShort() throws IOException {
            short ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = (short) (ret * 10 + c - '0');
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return (short) -ret;
            return ret;
        }*/

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

       /* public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = ret * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }*/

      /*  private char nextChar() throws IOException {
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
        }*/

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

            FastScanner in=new FastScanner();
            PrintWriter out = new PrintWriter(System.out);

            int testCases=in.nextInt();
            while(testCases-- > 0){

                int n = in.nextInt();
                int k = in.nextInt();

                int[][] arr = new int[n][2];
                for(int i =0;i<n;i++){
                    arr[i][0] = in.nextInt();

                }
                for (int i = 0;i<n;i++){
                    arr[i][1]=in.nextInt();
                }

                PriorityQueue<Monster> pq = new PriorityQueue<Monster>(new Comp());
                for(int i = 0;i<n;i++ ){
                    pq.add(new Monster(arr[i][1],arr[i][0]));
                }

                int prevk = k;

                while(true){
                    if(k<=0){
                        out.println("NO");
                        break;
                    }
                    while(pq.peek()!=null && pq.peek().health<=prevk){
                        pq.poll();
                    }
                    if(pq.peek()==null){
                        out.println("YES");
                        break;
                    }

                    k-=pq.peek().power;
                    prevk+=k;

                }


            }
            out.close();

    }
}
