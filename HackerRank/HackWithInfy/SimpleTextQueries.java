import java.util.HashSet;
import java.util.Scanner;

public class SimpleTextQueries {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sentencesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] sentences = new String[sentencesCount];

        for (int i = 0; i < sentencesCount; i++) {
            String sentencesItem = scanner.nextLine();
            sentences[i] = sentencesItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        textQueries(sentences, queries);

        scanner.close();
    }

    static void textQueries(String[] sentences, String[] queries) {
        HashSet[] sen = new HashSet[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            String[] curr = sentences[i].split(" ");
            sen[i] = new HashSet<String>();
            for (String s : curr) {
                sen[i].add(s);
            }
        }

        for (String query : queries) {
            String[] q = query.split(" ");
            boolean none = true;
            for (int j = 0; j < sentences.length; j++) {
                boolean contains = true;
                for (String word : q) {
                    contains = sen[j].contains(word);
                    if (!contains) break;
                }
                if (contains) {
                    none = false;
                    System.out.print(j);
                    System.out.print(" ");
                }
            }
            if (none) System.out.println(-1);
            else System.out.println();
        }
    }
}
