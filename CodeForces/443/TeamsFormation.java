import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by piyus on 26-10-2017 at 20:51.
 */
public class TeamsFormation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int m = s.nextInt();
        Stack<Integer> a = new Stack<>();
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            a.push(x);
            q.offer(x);
        }
        int sizeLeft = n;
        while (true) {
            int count = 0;
            int curr = a.peek();
            while (count < k && !a.isEmpty()) {
                if (a.pop() == curr) count++;
                else break;
            }
            while (count < k && !q.isEmpty()) {
                if (q.poll() == curr) count++;
                else break;
            }
            if (q.isEmpty() && a.isEmpty()) {
                sizeLeft = 0;
                break;
            }
            if (count != k) {
                sizeLeft = (a.size() + q.size() + count);
                break;
            }
        }

    }
}
