import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_1755 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int M = s.nextInt();
        int N = s.nextInt();

        List<String> alp = new ArrayList<>();
        alp.add("zero");
        alp.add("one");
        alp.add("two");
        alp.add("three");
        alp.add("four");
        alp.add("five");
        alp.add("six");
        alp.add("seven");
        alp.add("eight");
        alp.add("nine");

        String [] number = new String[N-M+1];
        int [] num = new int[N-M+1];
        int index=0;
        for (int i=M; i<=N; i++){
            num[index] = i;
            number[index]="";
            if (i/10 !=0) {
                number[index] = alp.get(i/10);
            }
            number[index] = number[index].concat(alp.get(i%10));
            index++;
        }

        for (int i=0; i<=N-M; i++){
            for (int j=0; j<=N-M-1-i; j++){
                if (number[j].compareTo(number[j+1])>0){
                    String tmp = number[j+1];
                    number[j+1] = number[j];
                    number[j] = tmp;
                    int tmp2 = num[j+1];
                    num[j+1] = num[j];
                    num[j] = tmp2;
                }
            }
        }
        int idx=0;
        for (int i=1; i<=N-M+1; i++) {
            if (i%10 == 0) System.out.println(num[idx]);
            else System.out.print(num[idx]+" ");
            idx++;
        }

    }
}
