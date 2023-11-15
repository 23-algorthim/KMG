import java.util.Scanner;

public class Main_2748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        long [] fibo = new long[91];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= num; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[num]);
    }
}
