import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//[문자열] 문자열 집합
public class Main_14425 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        Set<String> s = new HashSet<>();
        //배열이 아닌 hashset을 사용
        for (int i=0; i<N; i++){
            s.add(sc.nextLine());
        }

        int result = 0;
        for (int i=0; i<M; i++){
            if (s.contains(sc.nextLine())){
                result++;
            }
//            for (int j=0; j<N; j++){
//                if (s[j].equals(word)){
//                    result++;
//                    break;
//                }
//            }
            //한번씩 같은 단어 인지 체크 하는 것보다
            //집합에 포함 되어 있는지 확인하는 contains 함수를 통해
            //시간 초과를 해결
        }
        System.out.println(result);
    }
}
