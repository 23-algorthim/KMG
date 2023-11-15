import java.util.Scanner;

public class Main_11727 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n=s.nextInt();

        int []tile = new int[n+1];

        for (int i=1; i<=n; i++){
            if (i==1) tile[i] = 1;
            else if (i==2) tile[i] = 3;
            else {
                tile[i] = (tile[i-1] + 2*tile[i-2]) % 10007;
            }
        }
        System.out.println(tile[n]);


    }
}
