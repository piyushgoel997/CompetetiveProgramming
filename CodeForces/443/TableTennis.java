import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by piyus on 26-10-2017 at 20:29.
 */
public class TableTennis {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long k = s.nextLong();
        Queue<Integer> queue = new LinkedList<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            queue.offer(x);
            if (x > max) max = x;
        }
        if (k >= n - 1) {
            System.out.println(max);
            return;
        }
        int wins = 0;
        int a = queue.poll();
        int b = queue.poll();
        while (wins < k) {
            if (a > b) {
                queue.offer(b);
                b = queue.poll();
                wins++;
            } else {
                queue.offer(a);
                a = b;
                b = queue.poll();
                wins = 1;
            }
        }
        System.out.println(a);

    }

// THis one was is correct.
/*    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long k = s.nextLong();
        int[] players = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            players[i] = s.nextInt();
            if (players[i] > max) {
                max = players[i];
            }
        }
        if (k >= n - 1) {
            System.out.println(max);
            return;
        }

        int a = 0; // winner
        int b = 1;
        int wins = 0;
        while (wins < k) {
            if (a >= n) a = a - n;
            if (b >= n) b = b - n;
            if (players[a] > players[b]) {
                b++;
                wins++;
            } else {
                a = b;
                b++;
                wins = 1;
            }
        }
        System.out.println(players[a]);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/
}
