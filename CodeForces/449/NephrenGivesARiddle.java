import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by piyus on 02-12-2017 at 20:10.
 */
public class NephrenGivesARiddle {

    public static final String F0 = "What are you doing at the end of the world? Are you busy? Will you save us?";
    public static final String A = "What are you doing while sending \"";
    public static final String B = "\"? Are you busy? Will you send \"";
    public static final String C = "\"?";

    private static BigInteger[] lengths;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        int[] ns = new int[Q];
        BigInteger[] ks = new BigInteger[Q];
        int maxN = 1;
        for (int q = 0; q < Q; q++) {
            ns[q] = s.nextInt();
            ks[q] = BigInteger.valueOf(s.nextLong() - 1);
            if (ns[q] > maxN) maxN = ns[q];
        }
        lengths = new BigInteger[maxN];
        lengths[0] = BigInteger.valueOf(F0.length());
        for (int i = 1; i < lengths.length; i++) {
            lengths[i] = (lengths[i - 1].multiply(BigInteger.valueOf(2))).add(BigInteger.valueOf(A.length() + B.length() + C.length()));
        }
//        System.out.println(lengths[maxN-1]);
        for (int i = 0; i < Q; i++) {
            System.out.print(query(ns[i], ks[i]));
        }
    }

    private static char query(int n, BigInteger k) {
        if (n == 0) {
            if (k.compareTo(BigInteger.valueOf(F0.length()))>=0) return '.';
            return F0.charAt(k.intValue());
        }
        if (k.compareTo(BigInteger.valueOf(A.length())) < 0) {
            return A.charAt(k.intValue());
        }
        k = k.subtract(BigInteger.valueOf(A.length()));
        if (lengths[n - 1].compareTo(k) > 0) {
            return query(n - 1, k);
        }
        k = k.subtract(lengths[n - 1]);
        if (k.compareTo(BigInteger.valueOf(B.length())) < 0) {
            return B.charAt(k.intValue());
        }
        k = k.subtract(BigInteger.valueOf(B.length()));
        if (k.compareTo(lengths[n - 1]) < 0) {
            return query(n - 1, k);
        }
        k = k.subtract(lengths[n - 1]);
        if (k.compareTo(BigInteger.valueOf(C.length()))<0) {
            return C.charAt(k.intValue());
        }
        return '.';
    }

}
