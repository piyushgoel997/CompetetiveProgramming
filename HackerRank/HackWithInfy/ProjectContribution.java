import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ProjectContribution {

    public static void main(String[] args) {
        System.out.println(getMaxProjects(new Scanner(System.in).nextLine()));
    }

    static int getMaxProjects(String input) {
        ArrayList<String> list = new ArrayList<>();
        String curr = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                list.add(curr);
                curr = "";
            } else {
                curr = curr + input.charAt(i);
            }
        }
        list.add(curr);
        maxProj = new int[list.size()];
        return dp(list, 0);
    }

    private static int[] maxProj;

    private static int dp(ArrayList<String> list, int i) {
        if (i >= list.size() - 5) return 0;
        if (maxProj[i] > 0) return maxProj[i];
        int ans = dp(list, i + 1);
        if (containsAll(list, i)) {
            ans = Math.max(ans, 1 + dp(list, i + 6));
        }
        return maxProj[i] = ans;
    }

    private static boolean containsAll(ArrayList<String> list, int i) {
        HashSet<String> set = new HashSet<>();
        for (int j = i; j < i + 6; j++) set.add(list.get(j));
        String[] arr = {"RA", "DES", "CODE", "TEST", "DEP", "M"};
        return set.containsAll(Arrays.asList(arr));
    }
}
