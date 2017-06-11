import java.util.Scanner;

/**
 * Created by Piyush on 31-10-2016.
 */
public class GrasshopperAndTheString {
    public static void main(String args[]) {
//        Scanner s = new Scanner(System.in);
//        String str = s.next();
//        int minJumpAbility = 1;
//        for (int i = 0; i <= str.length(); i++) {
//            if (i == str.length()) {
//                minJumpAbility = i;
//                break;
//            }
//            if (isVowel(str.charAt(i))) {
//                minJumpAbility = i;
//                break;
//            }
//        }
//        for (int i = 0; i < str.length(); i++) {
//            while (!isVowel(str.charAt(i))) {
//                i++;
//            }
//            int j = i + 1;
//                int count = 1;
//                while ( j <= str.length()) {
//                    if (j == str.length()) {
//                        if (count > minJumpAbility) {
//                            minJumpAbility = count;
//                        }
//                        break;
//                    }
//                    if (isVowel(str.charAt(j))) {
//                        if (count > minJumpAbility) {
//                            minJumpAbility = count;
//                        }
//                        break;
//                    }
//                    count++;
//                    j++;
//                }
//            i = j-1;
//
//        }
//        System.out.print(minJumpAbility);
        int x = qwer();
        System.out.println(x);

    }

    private static boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y') {
            return true;
        }
//        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
//            return true;
//        }
        return false;
    }

    public static int qwer() {

                Scanner s = new Scanner(System.in);
                String str = s.next();
                int minJumpAbility = 1;
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length()) {
                        minJumpAbility = i;
                        break;
                    }
                    if (isVowel(str.charAt(i))) {
                        minJumpAbility = i+1;
                        break;
                    }
                }
                for (int i = 0; i < str.length(); i++) {
                    if (isVowel(str.charAt(i))) {
                        int count = 1;
                        for (int j = i + 1; j <= str.length(); j++) {
                            if (j == str.length()) {
                                if (count > minJumpAbility) {
                                    minJumpAbility = count;
                                }
                                break;
                            }
                            if (isVowel(str.charAt(j))) {
                                if (count > minJumpAbility) {
                                    minJumpAbility = count;
                                }
                                break;
                            }
                            count++;
                        }
                    }
                }
        return minJumpAbility;
    }

}
