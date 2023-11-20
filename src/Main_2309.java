import java.util.Arrays;
import java.util.Scanner;

public class Main_2309 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int []boys = new int[9];
        for (int i=0; i<9; i++){
            boys[i] = s.nextInt();
        }

        int []rboys = new int[7];

        int height;
        boolean find = false;
        for (int i=0; i<8; i++){
            for (int j=i+1; j<9; j++){
                height=0;
                for (int k=0; k<9; k++){
                    if (k!=i && k!=j) height+=boys[k]; //9명의 난쟁이 중 7명씩 더한다
                }
                if (height == 100) { //7명 모두 합한 결과가 100인 경우 7 난쟁이 찾음!
                    find = true;
                    int index=0;
                    for (int k=0; k<9; k++){
                        if (k!=i && k!=j) rboys[index++] = boys[k]; //해당 난쟁이들 키를 rboys 배열에 옮김
                    }
                    Arrays.sort(rboys); //오름차순 배열
                }

            }
        }
        if (find){ //찾으면 난쟁이 출력
            for (int k=0; k<7; k++){
                System.out.println(rboys[k]);
            }
        } else { //못찾으면 아무거나(?) 출력
            for (int k=0; k<7; k++){
                System.out.println(boys[k]);
            }
        }
    }
}
