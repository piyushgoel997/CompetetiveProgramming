import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Piyush on 12-01-2017.
 */
public class D {
    // k = no of divs   ==========   2
    // b = binary num
    // start = 1st value of k  =====  0
    public static Pair generateArr(int k, int start, int[] b, int n){

        if (n - start < 2) {
            int[] arr = {b[n - 1]};
            ArrayList<int[]> al = new ArrayList<>();
            al.add(arr);
            return new Pair(al , start);
        }

        Pair p = null;
        int[] num = null;
            int x = n;
            if (k>1) {
                p = generateArr(k - 1, start + 1, b, n);
                x = p.index;
            }

            num = new int[x - start];
            for (int j = start; j < x; j++) {
                num[j - start] = b[j];
            }
//        ArrayList<int[]> a;
//        if (p != null) {
//            a = p.arr;
//        } else {
//            a = new ArrayList<>();
//            int[] arr = new int[n - start];
//            for (int i = start + 1; i < n; i++) {
//                arr[i - start - 1] = b[i];
//            }
//            a.add(arr);
//        }
//        if (num != null) {
//            a.add(num);
//        }

        ArrayList<int[]> a;
        a = p.arr;
        a.add(num);
        Pair ans = new Pair(a,start);
        return ans;
    }

    public static class Pair {
        ArrayList<int[]> arr;
        int index;

        public Pair(ArrayList<int[]> arr, int index) {
            this.arr = arr;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int temp = reader.nextInt();
        int[] b = new int[n];
        int i = 0;
        while  (temp > 0){
            b[i] = temp % 10;
            temp /= 10;
            i++;
        }

        for (int j = 2; j <= n+1; j++) {
            Pair p = generateArr(j, 0, b, n);
            for (int k = 0; k < p.arr.size(); k++) {
                System.out.print(p.arr.get(k) + ",");
            }
            System.out.println();
        }
    }

}
