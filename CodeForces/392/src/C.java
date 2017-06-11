import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Piyush on 19-01-2017.
 */
public class C {

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

    public static void main(String[] z) throws IOException {
        Scanner reader = new Scanner(System.in);
        long n = reader.nextLong();
        long m = reader.nextLong();
        long k = reader.nextLong();
        long x = reader.nextLong();
        long y = reader.nextLong();

        long max = 1;
        long min = 0;
        long s = 0;


        long q = k / (n * m);
        long r = k % (n * m);

        if (n < 3) {
            max = q;
            min = q;
            s = q;
            if (r > 1) {
                max++;
                if (x == 1) {
                    if (r > y) {
                        s++;
                    }
                } else {
                    r = r - m;
                    if (r > y) {
                        s++;
                    }
                }
            }
            System.out.print(max + " " + min + " " + s);
            return;
        }


        max = q + 1;
        min = (q / 2) + 1;

        if (r > (n - 1) * m) {
            max += 1;
        }
        if (r > (n - 3) * m) {
            if (r > (n - 3) * m) {
                min += 1;
            }


            if (x == 0) {
                s = q / 2 + 1;
            } else if (x == (n - 1)) {
                s = q / 2;
            } else if (x == (n - 2)) {
                s = 2 * (q / 2) + 2;
            } else if (x == 1) {
                s = 2 * (q / 2) + 1;
            } else {
                s = q;
            }


        }
        System.out.println(max + " " + min + " " + s);

    }
}

