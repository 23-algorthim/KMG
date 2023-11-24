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
        //알파벳 초기화

        String [] number = new String[N-M+1];
        int [] num = new int[N-M+1]; //알파벳과 숫자를 다루기
        int index=0;
        for (int i=M; i<=N; i++){
            num[index] = i;
            number[index]="";
            if (i/10 !=0) {
                number[index] = alp.get(i/10);
            }
            number[index] = number[index].concat(alp.get(i%10));
            index++;
        } //숫자에 해당하는 문자들을 가져와서 넣어준다
        //만약 8 이라면 십의 자리는 없으니까 패스, 일의 자리에 해당하는 8 "eight"만 가져와서 concat
        //만약 20 이라면 십의 자리는 2라서 먼저 two를 넣고, 일의 자리에 해당하는 0 "zero"를 가져와서 concat -> twozero

        for (int i=0; i<=N-M; i++){
            for (int j=0; j<=N-M-1-i; j++){ //버블 정렬로 정리, 문자를 기준으로 오름차순 정렬하면서 숫자들도 같이 옮겨준다.
                if (number[j].compareTo(number[j+1])>0){ //compareTo는 호출하는 문자가 사전적으로 앞이면 음수
                                                        //매개변수가 사전적으로 앞이면 양수, 동일하면 0
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
            if (i%10 == 0) System.out.println(num[idx]); //10개씩 끊어서 출력
            else System.out.print(num[idx]+" ");
            idx++;
        }

    }
}
