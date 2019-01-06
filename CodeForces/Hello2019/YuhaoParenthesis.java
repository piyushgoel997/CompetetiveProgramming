import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class YuhaoParenthesis {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();
        int bal = 0;
        for (int i = 0; i < n; i++) {
            String str = s.next();
            int x = check(str);
            if (x == 0) {
                bal++;
                continue;
            }
            if (x != -1) {
                a.putIfAbsent(x, 0);
                a.put(x, a.get(x) + 1);
                continue;
            }
            StringBuilder rev = new StringBuilder();
            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) == '(') rev.append(')');
                else rev.append('(');
            }
            x = check(rev.toString());
            if (x != -1) {
                b.putIfAbsent(x, 0);
                b.put(x, b.get(x) + 1);
            }
        }
        int pairs = 0;
        for (Integer x : a.keySet()) if (b.containsKey(x)) pairs += Math.min(a.get(x), b.get(x));
        pairs += bal / 2;
        System.out.println(pairs);
    }

    public static int check(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (stack.empty()) return -1;
                else stack.pop();
            } else {
                stack.push('(');
            }
        }
        return stack.size();
    }
}
