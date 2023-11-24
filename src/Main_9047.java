import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_9047 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        for (int i=0; i<N; i++){
            Integer [] input = new Integer[4];
            int result = s.nextInt();
            int count = 0;
            while (result != 6174){
                input[0] = result/1000;
                input[1] = (result%1000)/100;
                input[2] = (result%100)/10;
                input[3] = result%10;
                //자리 수 별로 배열에 넣고
                Arrays.sort(input, Comparator.reverseOrder());
                //내림차순으로 정렬
                result = input[0]*1000 + input[1] * 100 + input[2] * 10 + input[3];
                //정렬된 수와
                int sub = input[3]*1000 + input[2] * 100 + input[1] * 10 + input[0];
                //역전된 수
                result = Math.abs(result-sub); //차이 이기 때문에 절댓값 처리
                count++; //한번 반복 될 때마다 count++
            }
            System.out.println(count);
        }
    }
}
