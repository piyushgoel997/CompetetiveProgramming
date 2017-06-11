import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Piyush on 12-01-2017.
 */
public class B {
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

    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    // for counting the number of factors of 'n'
    public static int sieveOfEratosthenes(int n) {
        int count = 0;
        boolean[] a = new boolean[n+1];
        for (int i = 2; i < n + 1; i++) {
            a[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (a[i] == true) {
                int j = i * i;
                while (j <= n) {
                    a[j] = false;
                    j = j + i;
                }
            }
        }
        for (int i = 2; i < n + 1; i++) {
            if (a[i] == true) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int n = r.nextInt();
        HashMap<Integer, Integer> factors = new HashMap<>();
        int[] nos = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = r.nextInt();
            nos[i] = temp;
            if (temp > 3) {
                factors.put(temp, sieveOfEratosthenes(temp));
            } else {
                factors.put(temp, 1);
            }
        }
        int ans = 1;
        for (int i = 0; i < factors.size(); i++) {
            ans = Math.max(ans, factors.get(nos[i]));
        }
        System.out.println(ans);
    }
}
