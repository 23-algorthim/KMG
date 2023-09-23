import java.util.Arrays;
import java.util.Scanner;
//[문자열] 단어 정렬
class Words{
    String word;
    Words(String word){
        this.word=word;
    }
}
public class Main_1181 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        s.nextLine();
        Words [] words = new Words[num];
        for (int i=0; i<num; i++){
            String word = s.nextLine();
            words[i] = new Words(word);
        }
        Arrays.sort(words, (w1, w2) ->
                w1.word.length() == w2.word.length()?
                        w1.word.compareTo(w2.word) : w1.word.length() - w2.word.length());
        //단어끼리 길이가 같다면 compareTo 함수를 통해 사전순으로 비교하여 정렬
        //단어끼리 길이가 다르다면 길이 순으로 정렬

        System.out.println(words[0].word);
        //처음 단어를 먼저 출력하고 아래에서는 다음 단어와 비교하면서 같지 않으면 다음 단어를 출력
        for (int i=0; i<words.length-1; i++){
            if (!words[i].word.equals(words[i+1].word)){
                System.out.println(words[i+1].word);
            }

        }

    }
}
