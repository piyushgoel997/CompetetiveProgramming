
import java.util.Scanner;

/**
 * Created by Piyush on 23-10-2016.
 */
public class FileFixIt {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] answer = new int[t];
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            TreeNode root = new TreeNode("/");
            for (int j = 0; j < n; j++) {
                String current = s.next();
                if (!current.equals(""))
                    addToTree(root, current.substring(1));
            }
            int steps = 0;
            for (int j = 0; j < m; j++) {
                String current = s.next();
                if (!current.equals(""))
                    steps += addToTree(root, current.substring(1));
            }
            answer[i] = steps;
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #"+(i+1)+": "+ answer[i]);
        }

    }

    private static int addToTree(TreeNode root, String current) {

        if (root == null || current == null || current.length() == 0) {
            return 0;
        }

        int lastIndex = current.length();
        if (current.indexOf("/") != -1) {
            lastIndex = current.indexOf("/");
        }

        String str = current.substring(0, lastIndex);
        int step = 0;
        if (root.searchInChildren(str) == null) {
            root.addChildren(str);
            step = 1;
        }
        if (current.indexOf("/") == -1) {
            return step;
        }
        return addToTree(root.searchInChildren(str), current.substring(current.indexOf("/")+1)) + step;
    }
}
