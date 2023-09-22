import java.util.Scanner;
//[문자열] 팰린드롬수
public class Main_1259 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        while (true){
            String s1 = s.nextLine();
            boolean isPalindrome = true;
            if (s1.equals("0")) break;

            char [] word = s1.toCharArray();
            int i=0;
            int j=word.length-1;
            while (i<j) {
                if (word[i] == word[j]){
                    //s1.charAt(i) == s1.charAt(j)을 이용 해도 된다.
                    i++;
                    j--;
                } else {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) System.out.println("yes");
            else System.out.println("no");

        }
    }
}
