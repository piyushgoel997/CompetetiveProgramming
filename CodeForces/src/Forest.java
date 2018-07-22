
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Piyush on 15-01-2017.
 */
public class Forest {

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }



        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

//    public static class Pair {
//        int num;
//        boolean visited;
//
//        public Pair(int num) {
//            this.num = num;
//            this.visited = false;
//        }
//    }

    public static class Pair2 {
        int num;
        int treeNo;

        public Pair2(int num) {
            this.num = num;
            this.treeNo = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int n = r.nextInt();
        Pair2[] pairs = new Pair2[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair2(r.nextInt()-1);
        }

        System.out.println(solve2(n,pairs));
    }

//    private static int solve(int n, Pair[] pairs) {
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            Pair p = pairs[i];
//            if (!p.visited) {
//                p.visited = true;
//                if (visit(pairs, p.num) == i) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

//    private static int visit(Pair[] pairs, int num) {
//        if (pairs[num].visited) {
//            return num;
//        }
//        pairs[num].visited = true;
//        return visit(pairs,pairs[num].num);
//    }

    public static int solve2(int n, Pair2[] pairs) {
        int count = 1;
        pairs[0].treeNo = 1;
        for (int i = 0; i < n; i++) {
            Pair2 p = pairs[i];
            if (p.treeNo == 0) {
                int x = visit2(pairs, p.num, i);
                if (x == -1) {
                    count++;
                    p.treeNo = count;
                } else {
                    p.treeNo = pairs[x].treeNo;
                }
            }
        }
        return count;
    }

    private static int visit2(Pair2[] pairs, int num, int i) {
        if (pairs[num].treeNo != 0) {
            return num;
        }
        if (num == i) {
            return -1;
        }
        return visit2(pairs, pairs[num].num,i);
    }
}
