import java.util.Arrays;
import java.util.Scanner;
//[Case Work] 나는 학급회장이다.
class Count{
    int one;
    int two;
    int three;

    Count(int i, int j, int k){
        one=i;
        two=j;
        three=k;
    }
}
public class Main_2456 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        Count [] count = new Count[3];
        int []score = new int[]{0,0,0};
        int N = s.nextInt();

        for (int i=0; i<3; i++) count[i] = new Count(0,0,0); //객체 생성

        for (int i=0; i<N; i++){
            for (int j=0; j<3; j++) {
                int num = s.nextInt();
                score[j] += num;
                if (num == 1) count[j].one++;
                else if(num==2) count[j].two++;
                else count[j].three++;
            }
        }// 받은 점수만큼 올려주고, 3점,2점,1점을 구별한다.
        int max = 0;
        int index=-1;
        for (int i=0; i<3; i++) {
            if (max < score[i]) {
                max=score[i];
                index=i;
            }
        } //max 점수 구하기
        boolean indecisive = false;
        index = index+1;
        for (int i=1; i<4; i++){
            if (max == score[i-1] && index != i) {
                if (count[index-1].three < count[i-1].three) {
                    indecisive = false;
                    index=i;
                }
                else if(count[index-1].three == count[i-1].three){
                    if (count[index-1].two < count[i-1].two) index=i;
                    else if(count[index-1].two == count[i-1].two) {
                        indecisive = true;
                    }
                }
            }
        } //같은 점수가 있는데 index가 같지 않으면 3점부터 비교 그 후 2점 비교
        // 2점까지 모두 똑같다면 결정할 수 없음
        // 하지만 3번 후보까지 모두 똑같은데 3점에서 차이가 난다면 결정할 수 있으므로 indecisive=false
        if (indecisive) System.out.println(0+" "+max);
        else  System.out.println(index +" "+max);
    }
}
