import java.util.Scanner;

public class Main_17202 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String num1 = s.nextLine();
        String num2 = s.nextLine();

        char [] number1 = num1.toCharArray();
        char [] number2 = num2.toCharArray();

        int [] sum = new int[16];
        int j=0;
        for (int i=0; i<16; i+=2){
            sum[i] = number1[j]-'0';
            sum[i+1] = number2[j]-'0';
            j++;
        }
        int len = 16;
        while (len > 2){
            for (int i=0; i<len-1; i++){
                sum[i] = (sum[i]+sum[i+1])%10;
            }
            len--;
        }

        System.out.print(sum[0]);
        System.out.print(sum[1]);
    }
}
