import java.util.Scanner;

public class Main_6996 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();

        for (int i=0; i<N; i++){
            boolean isAnagram = true;
            String w = s.nextLine();
            int length = w.indexOf(" ");
            String w1 = w.substring(0,length);
            String w2 = w.substring(length+1);
            if (w1.length() == w2.length()) { //길이가 같으면 비교 해볼만 함
                int [] alp = new int[26]; //알파벳 배열
                //a-0, b-1, c-2 .. z-25
                for (int j=0; j<w1.length(); j++){
                    char a = w1.charAt(j); //a[j]와 동일
                    char b = w2.charAt(j);
                    alp[a-97]++;
                    alp[b-97]--;
                    //a의 아스키코드는 97이므로 -97을 해주어야 배열에 알맞게 입력된다.
                }
                for (int j=0; j<26; j++){
                    if (alp[j] != 0){
                        isAnagram=false;
                        break;
                    }
                }
                if (isAnagram) {
                    System.out.printf("%s & %s are anagrams.\n",w1,w2);
                    //해당 과정을 모두 통과했다면 anagrams이 맞다.
                } else {
                    System.out.printf("%s & %s are NOT anagrams.\n",w1,w2);
                }

            } else{
                System.out.printf("%s & %s are NOT anagrams.\n",w1,w2);
                //길이가 다르면 바로 anagram이 아님
            }
        }
    }
}
