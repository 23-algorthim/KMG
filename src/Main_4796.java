import java.util.Scanner;

//[그리디] 캠핑
public class Main_4796 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int num = 1;
        while (true) {
            int use = s.nextInt();
            int camp = s.nextInt();
            int vac = s.nextInt();

            if (use==0 && camp==0 && vac==0) break;

            int result = (vac / camp) * use;

            vac -= (vac/camp) * camp;


//            if (vac < use) {
//                result += vac;
//            } else{
//                result += use;
//            }

            result += Math.min(vac, use);
            System.out.println("Case "+ (num++) +": "+result);
        }

    }
}
