import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 27-12-2017 at 22:38.
 */
public class ColorfulPoints {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int[] last = new int['z'];
        Arrays.fill(last, -1);

        int max = 0;
//        for (int i = 0; i < ; i++) {
//
//        }



//        Node head = new Node();
//        head.prev = null;
//        Node p = head;
//        head.color = str.charAt(0);
//        for (int i = 1; i < str.length(); i++) {
//            Node x = new Node();
//            x.color = str.charAt(i);
//            x.prev = p;
//            p.next = x;
//            p = x;
//        }
//        p.next = null;
//
//        int ans = 0;
//        while (possible(head)) {
//            ans++;
//            System.out.println();
//        }
//        System.out.println(ans);
    }

//    private static boolean possible(Node head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        boolean changed = false;
//        while (head.color != head.next.color) {
//            head = head.next;
//            changed = true;
//        }
//        Node x = head.next;
//        while (x.next != null) {
//            if (x.next.color != x.color || x.prev.color != x.color) {
//                System.out.print(x.color);
//                delete(x);
//                changed = true;
//            }
//            x = x.next;
//        }
//        if (x.prev != null) {
//            if (x.color != x.prev.color) {
//                x.prev.next = null;
//                changed = true;
//            }
//        }
//        return changed;
//    }
//
//    private static void delete(Node x) {
//        x.prev.next = x.next;
//        x.next.prev = x.prev;
//    }
//
//    private static class Node {
//        char color;
//        Node next;
//        Node prev;
//    }

}
