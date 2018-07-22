package Sept17;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 05-09-2017 at 17:12.
 */
public class Seaco2 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int m = s.nextInt();
            HashMap<Integer, Integer>[] commands = new HashMap[m];
            HashMap<Integer, Integer> finalCommand = new HashMap<>();
            for (int i = 0; i < m; i++) {
                commands[i] = new HashMap<>();
                if (s.nextInt() == 1) {
                    commands[i].put(s.nextInt() - 1, 1);
                    int x = s.nextInt();
                    if (x < n)commands[i].put(x, -1);
                } else {
                    int start = s.nextInt() - 1;
                    int end = s.nextInt();
                    for (int j = start; j < end; j++) mergeHM(commands[i],commands[j]);
//                        commands[j].forEach((k, v) -> commands[finalI].merge(k, v, (l1, l2) -> (l1 + l2) % MOD));
                }
                mergeHM(finalCommand, commands[i]);
//                commands[i].forEach((k, v) -> finalCommand.merge(k, v, (l1, l2) -> (l1 + l2) % MOD));
            }
//            int curr = 0;
//            for (int i = 0; i < n; i++) {
//                if (finalCommand.containsKey(i)) curr += finalCommand.get(i);
//                System.out.print(curr + " ");
//            }

            int[] arr = new int[n];
            for (int k : finalCommand.keySet()) arr[k] = finalCommand.get(k);
            int curr = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                curr += arr[i];
                sb.append(curr);
                sb.append(" ");
//                System.out.print(curr + " ");
            }
            System.out.println(sb);
        }
    }

    private static void mergeHM(HashMap<Integer, Integer> in, HashMap<Integer, Integer> from) {
        for (int k : from.keySet()) {
            if (in.containsKey(k)) in.put(k, (in.get(k) + from.get(k)) % MOD);
            else in.put(k, from.get(k));
        }
    }


//
//    static class Command {
//        HashMap<Integer, Long> change;
//
//        public Command() {
//            change = new HashMap<>();
//        }
//
//        void add(int s, int e, long eff) {
//            change.merge(s, eff, Long::sum);
//            change.merge(e + 1, -eff, Long::sum);
////            if (change.containsKey(s)) {
////                change.put(s, change.get(s) + eff);
////            } else {
////                change.put(s, eff);
////            }
////            if (change.containsKey(e)) {
////                change.put(s, change.get(e) - eff);
////            } else {
////                change.put(e, -eff); ///// TODO if only increasing then the prob is here.
////            }
//        }
//
//        void addMapOfCommand(int x) {
//            commands[x].change.forEach((k, v) -> change.merge(k, v, Long::sum));
//        }
//
//        void apply() {
//            for (int i : change.keySet()) if (i < arr.length) arr[i] = (arr[i] + change.get(i)) % MOD;
//        }
//    }


}
