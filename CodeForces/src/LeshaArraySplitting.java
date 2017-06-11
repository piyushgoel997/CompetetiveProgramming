import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Piyush on 06-01-2017.
 */
public class LeshaArraySplitting {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int flag = 1;
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (arr[i] != 0) {
                flag = 0;
            }
        }

        if (flag == 1) {
            System.out.print("NO");
        } else {
            function(arr,n);
        }



//        if (n == 1 && arr[0] == 0) {
//            System.out.print("NO");
//        } else if (flag == 0) {
//            function(arr,n);
//        } else {
//            System.out.println("YES");
//            System.out.println(n);
//            for (int i = 1; i <= n; i++) {
//                System.out.println(i + " " + i);
//            }
//        }
    }

    private static void function(int[] arr, int n) {

        int ct = 0;
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        int i = 0;
        while (i < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i + 1);
            while (i < n && arr[i] == 0) {
                i++;
            }
            temp.add(i + 1);
            if (i == n && arr[i - 1] == 0) {
                x.get(ct - 1).set(1, i);
            } else {
                x.add(temp);
                ct++;
            }
            i++;
        }
        System.out.println("YES");
        System.out.println(ct);
        for (int j = 0; j < x.size(); j++) {
            System.out.println(x.get(j).get(0)+" "+x.get(j).get(1));
        }

    }
}
