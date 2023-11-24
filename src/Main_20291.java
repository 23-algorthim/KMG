import java.util.*;

class Extension {
    String file;
    int count = 1;
}

public class Main_20291 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Extension> extensions = new ArrayList<>();

        int N = s.nextInt();
        s.nextLine();
        for (int i = 0; i < N; i++) {
            String file = s.nextLine();
            int point = file.indexOf(".");
            String ex = file.substring(point + 1); //확장자만 분리
            boolean exists = false;
            for (Extension exten : extensions) { //해당 확장자가 있는지 확인
                if (exten.file.equals(ex)) {
                    exists = true; //있다면 count만 올려주기
                    exten.count++;
                    break;
                }
            }
            if (!exists) { //없으면 새로운 객체를 생성하여 add
                Extension e = new Extension();
                e.file = ex;
                extensions.add(e);
            }
        }

        // 람다식 및 Comparator를 사용하여 사전순으로 정렬
        extensions.sort(Comparator.comparing(e -> e.file));
        ///여기서 e -> e.file는 Extension 객체를 받아서 그 객체의 file 필드를 반환하는 람다식
        // 이 Comparator는 Extension 객체를 비교할 때
        // 해당 객체의 file 필드 값을 기준으로 비교, 기본이 사전 순

        for (Extension e : extensions) {
            System.out.println(e.file + " " + e.count);
        }
    }
}
