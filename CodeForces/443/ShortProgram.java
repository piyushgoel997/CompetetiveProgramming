import java.util.Scanner;

/**
 * Created by piyus on 26-10-2017 at 21:08.
 */
public class ShortProgram {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] bits = new int[10];
        // 0 = set 0, 1 = set 1, -1 = no change, 2 = flip
        for (int i = 0; i < bits.length; i++) bits[i] = -1;
        for (int i = 0; i < n; i++) {
            String operator = s.next();
            String num = Integer.toBinaryString(s.nextInt());
            num = "0000000000".substring(num.length()) + num;
            switch (operator) {
                case "&":
                    and(bits, num);
                    break;
                case "|":
                    or(bits, num);
                    break;
                case "^":
                    xor(bits, num);
                    break;
            }
        }
        StringBuilder xor = new StringBuilder();
        StringBuilder or = new StringBuilder();
//        StringBuilder and = new StringBuilder();
        for (int bit : bits) {
//            System.out.print(bit);
            if (bit == 0) {
//                and.append("0");
                or.append("1");
                xor.append("1");
            } else if (bit == 1) {
//                and.append("1");
                or.append("1");
                xor.append("0");
            } else if (bit == 2) {
//                and.append("1");
                or.append("0");
                xor.append("1");
            } else {
//                and.append("1");
                or.append("0");
                xor.append("0");
            }
        }
        int ct = 0;
//        if (String.valueOf(and).equals("1111111111")) and = null;
//        else ct++;
        if (String.valueOf(or).equals("0000000000")) or = null;
        else ct++;
        if (String.valueOf(xor).equals("0000000000")) xor = null;
        else ct++;
        System.out.println(ct);
//        if (and != null) System.out.println("& " + Integer.parseInt(String.valueOf(and), 2));
        if (or != null) System.out.println("| " + Integer.parseInt(String.valueOf(or), 2));
        if (xor != null) System.out.println("^ " + Integer.parseInt(String.valueOf(xor), 2));
    }

    private static void xor(int[] bits, String num) {
        for (int i = 0; i < bits.length; i++) {
            if (num.charAt(i) == '1') {
                // flip bits
                switch (bits[i]) {
                    case -1:
                        bits[i] = 2;
                        break;
                    case 1:
                        bits[i] = 0;
                        break;
                    case 0:
                        bits[i] = 1;
                        break;
                    case 2:
                        bits[i] = -1;
                        break;
                }
            }
        }
    }

    private static void or(int[] bits, String num) {
        for (int i = 0; i < bits.length; i++) {
            if (num.charAt(i) == '1') bits[i] = 1;
        }
    }

    private static void and(int[] bits, String num) {
        for (int i = 0; i < bits.length; i++) {
            if (num.charAt(i) == '0') bits[i] = 0;
        }
    }


//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        Map<String, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < n; i++) {
//            String op = s.next();
//            int x = s.nextInt();
//            if (!map.containsKey(op)) {
//                map.put(op, x);
//            } else {
//                switch (op) {
//                    case "|":
//                        map.put(op, map.get(op) | x);
//                        break;
//                    case "^":
//                        map.put(op, map.get(op) ^ x);
//                        break;
//                    case "&":
//                        map.put(op, map.get(op) & x);
//                }
//                if (op.equals("&")) {
//                    if (map.get(op) == Math.pow(2, 10) - 1) {
//                        map.remove(op);
//                    }
//                } else {
//                    if (map.get(op) == 0) {
//                        map.remove(op);
//                    }
//                }
//            }
//        }
////        for (String key : map.keySet()) {
////            if (key.equals("&")) {
////                if (map.get(key) == Math.pow(2, 10) - 1) {
////                    map.remove(key);
////                }
////            } else {
////                if (map.get(key) == 0) {
////                    map.remove(key);
////                }
////            }
////        }
//        System.out.println(map.size());
//        for (String key : map.keySet()) {
//            System.out.println(key + " " + map.get(key));
//        }
//    }
}
