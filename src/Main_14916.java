import java.util.Scanner;

public class Main_14916 {
    public static int count(int[] money, int m){
        for (int i=0; i<=m; i++){
            if (i==0) money[i]=0;
            else if (i==1 || i==3) money[i]=-1;
            else if (i==2) money[i]=1;
            else if (i-5 >= 0) {
                if (money[i - 2] == -1)
                    money[i] = money[i - 5] + 1;
                else if (money[i - 5] == -1)
                    money[i] = money[i - 2] + 1;
                else money[i] = money[i - 2] > money[i-5] ? money[i-5] + 1 : money[i-2]+1;
            } else {
                money[i] = money[i-2] + 1;
            }
        }
        return money[m];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        int [] money = new int[num+1]; //거스름돈 개수

        System.out.println(count(money,num));

    }
}
