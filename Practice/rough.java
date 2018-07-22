public class rough {
    public static void main(String[] args) {
        for (int n = 1; n < 20; n++) {
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i * (1.0 - Math.pow(5.0 / 6.0, n - i + 1)) / (Math.pow(6.0, i - 1));
            }
            System.out.print(n + " : ");
            System.out.println(sum);
        }
    }
}
