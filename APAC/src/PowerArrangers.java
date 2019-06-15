import java.util.HashSet;
import java.util.Scanner;

public class PowerArrangers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int F = s.nextInt();
        for (int t = 0; t < T; t++) {
            HashSet[] sets = new HashSet[5];
            for (int i = 0; i < 5; i++) sets[i] = new HashSet<Integer>();

            String ans = "";

            for (int i = 0; i < 119; i++) {
                System.out.println(i * 5 + 1);
                System.out.flush();
                char x = s.next().charAt(0);
                switch (x) {
                    case 'A':
                        sets[0].add(i * 5 + 1);
                        break;
                    case 'B':
                        sets[1].add(i * 5 + 1);
                        break;
                    case 'C':
                        sets[2].add(i * 5 + 1);
                        break;
                    case 'D':
                        sets[3].add(i * 5 + 1);
                        break;
                    case 'E':
                        sets[4].add(i * 5 + 1);
                        break;
                }
            }

            HashSet<Integer> remaining = null;
            for (int i = 0; i < 5; i++) {
                if (sets[i].size() == 23) {
                    remaining = new HashSet<>(sets[i]);
                    ans += i;
                    break;
                }
            }

            sets = new HashSet[5];
            for (int i = 0; i < 5; i++) sets[i] = new HashSet<Integer>();

            for (Integer i : remaining) {
                System.out.println(i + 1);
                System.out.flush();
                char x = s.next().charAt(0);
                switch (x) {
                    case 'A':
                        sets[0].add(i + 1);
                        break;
                    case 'B':
                        sets[1].add(i + 1);
                        break;
                    case 'C':
                        sets[2].add(i + 1);
                        break;
                    case 'D':
                        sets[3].add(i + 1);
                        break;
                    case 'E':
                        sets[4].add(i + 1);
                        break;
                }
            }

            remaining = null;
            for (int i = 0; i < 5; i++) {
                if (sets[i].size() == 5) {
                    remaining = new HashSet<>(sets[i]);
                    ans += i;
                    break;
                }
            }

            sets = new HashSet[5];
            for (int i = 0; i < 5; i++) sets[i] = new HashSet<Integer>();

            for (Integer i : remaining) {
                System.out.println(i + 1);
                System.out.flush();
                char x = s.next().charAt(0);
                switch (x) {
                    case 'A':
                        sets[0].add(i + 1);
                        break;
                    case 'B':
                        sets[1].add(i + 1);
                        break;
                    case 'C':
                        sets[2].add(i + 1);
                        break;
                    case 'D':
                        sets[3].add(i + 1);
                        break;
                    case 'E':
                        sets[4].add(i + 1);
                        break;
                }
            }

            int rem = -1;
            for (int i = 0; i < 5; i++) {
                if (sets[i].size() == 1) {
                    ans += i;
                    for (Object k : sets[i]) {
                        rem = (int) k;
                    }
                    break;
                }
            }

            System.out.println(rem + 2);
            System.out.flush();

            char c = s.next().charAt(0);
            HashSet<Character> temp = new HashSet<>();
            temp.add('A');
            temp.add('B');
            temp.add('C');
            temp.add('D');
            temp.add('E');
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.length(); i++) {
                switch (ans.charAt(i)) {
                    case '0':
                        sb.append("A");
                        temp.remove('A');
                        break;
                    case '1':
                        sb.append("B");
                        temp.remove('B');
                        break;
                    case '2':
                        sb.append("C");
                        temp.remove('C');
                        break;
                    case '3':
                        sb.append("D");
                        temp.remove('D');
                        break;
                    case '4':
                        sb.append("E");
                        temp.remove('E');
                        break;
                }
            }
            sb.append(c);
            temp.remove(c);
            for (Character x : temp) {
                sb.append(x);
            }
            System.out.println(sb);
            System.out.flush();
            char ch = s.next().charAt(0);
            if (ch == 'N') {
                break;
            }
        }

    }
}
