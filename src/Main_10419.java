import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main_10419 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        int answer=0;
        for (int i=0; i<T; i++){
            double d = s.nextDouble();
            int late = (int)sqrt(d);
            if (!(late <= d - (late * late))) {
                while (late > d - (late * late)) {
                    late--;
                }
            }
            answer = late;
            System.out.println(answer);
        }

    }
}
