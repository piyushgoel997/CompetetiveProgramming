package DataStructures;

/**
 * Created by piyus on 13-08-2017 at 23:35.
 * HackerRank. LinkedList - Medium. Correct.
 */
public class CycleDetection {

    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

    class Node {
        int data;
        Node next;
    }

    Node[] list;

    boolean hasCycle(Node head) {

    // the commented code is not working.
    /*
    if (list == null) {
        list = new Node[100];
    }
    if (head == null) {
        return false;
    }
    int i;
    for (i = 0; i < 100; i++) {
        if (list[i] == null) {
            break;
        }
        if (list[i] == head) {
            return true;
        }
    }
    list[i] = head;
    return hasCycle(head.next);
    */



        // Floyd Cycle Detection.

        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;

    }

}
