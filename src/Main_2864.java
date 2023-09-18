import java.util.Scanner;
//[그리디] 5와 6의 차이
public class Main_2864 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        StringBuilder num1 = new StringBuilder(s.next());
        StringBuilder num2 = new StringBuilder(s.next());

        char [] n1 = num1.toString().toCharArray();
        char [] n2 = num2.toString().toCharArray();

        num1 = new StringBuilder();
        num2 = new StringBuilder();


        for (int i=0; i<n1.length; i++){
            if (n1[i] == '5') n1[i]='6';
            num1.append(n1[i]);

        }
        for (int i=0; i<n2.length; i++){
            if (n2[i] == '5') n2[i] ='6';
            num2.append(n2[i]);
        }

        int max = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());

        num1 = new StringBuilder();
        num2 = new StringBuilder();


        for (int i=0; i<n1.length; i++){
            if (n1[i] == '6') n1[i]='5';
            num1.append(n1[i]);

        }
        for (int i=0; i<n2.length; i++){
            if (n2[i] == '6') n2[i] ='5';
            num2.append(n2[i]);
        }

        int min = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());

        System.out.print(min);
        System.out.print(' ');
        System.out.print(max);


    }
}
