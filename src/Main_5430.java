import java.util.*;
//[문자열] AC
public class Main_5430 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

//        int T = s.nextInt();
//        s.nextLine();
//        for (int i=0; i<T; i++){
//            boolean isEmpty = false;
//            boolean isReverse = false;
//            char [] p = s.nextLine().toCharArray();
//            //명령어
//            int n = s.nextInt();
//            s.nextLine();
//            String arr1 = s.nextLine();
//            List<String> array;
//            if (n==0) {
//                array = new ArrayList<>(n);
//                for (char c : p) {
//                    if (c == 'D') {
//                        isEmpty = true;
//                        break;
//                    }
//                }
//            } else {
////                String[] arr = arr1.split("\\[")[1].split("]")[0].split(",");
//                String [] arr = arr1.substring(1,arr1.length()-1).split(",");
//                // '['와 ']'을 분리해주고 나머지 숫자들을 ','으로 분리해서 배열에 넣는다.
//                array = new ArrayList<>(Arrays.asList(arr));
//                // 숫자 밖에 없는 배열을 ArrayList에 넣어준다.
//                for (char c : p) {
//                    if (c == 'R') {
//                        isReverse = !isReverse;
//                        //R을 인식할 때마다 reverse하는 것은 시간이 더 걸리므로
//                        //변수로 처리해준다.
//                    }
//                    if (c == 'D') {
//                        if (array.isEmpty()) {
//                            isEmpty = true;
//                            break;
//                        }
//                        if (isReverse){
//                            array.remove(array.size()-1);
//                        } else array.remove(0);
//                    }
//                }
//            }
//            if (isEmpty) {
//                System.out.println("error");
//                continue;
//            }
//            if (isReverse) {
////                Collections.reverse(array);
//                System.out.print("[");
//                for (int k=array.size()-1; k>=0; k--) {
//                    System.out.print(array.get(k));
//                    if (k!=0) System.out.print(",");
//                }
//                System.out.println("]");
//
//            } else {
//                System.out.print("[");
//                for (int k = 0; k < array.size(); k++) {
//                    System.out.print(array.get(k));
//                    if (k != array.size() - 1) System.out.print(",");
//                }
//                System.out.println("]");
//            }
//
//        }

        int T = s.nextInt();
        s.nextLine();
        for (int i=0; i<T; i++){
            boolean isReverse = false;
            boolean isEmpty = false;
            char [] p = s.nextLine().toCharArray();
            int n = s.nextInt();
            s.nextLine();

//            String a = s.nextLine();
//            String [] arr = a.substring(1,a.length()-1).split(",");
//
//            Deque<String> dq = new ArrayDeque<>(Arrays.asList(arr));
            //이런 형태면 비어있는 리스트가 들어왔을 때 [""]의 형태가 된다.

            StringTokenizer st = new StringTokenizer(s.nextLine(), "[],");
            //StringTokenizer에서 문자열을 특정 구분자를 기준으로 분리할 수 있다.
            Deque<Integer> dq = new ArrayDeque<>();

            for (int j=0; j<n; j++){
                dq.add(Integer.parseInt(st.nextToken()));
            }


            for (char c : p){
                if (c == 'R') isReverse = !isReverse;
                if (c == 'D'){
                    if (dq.isEmpty()) {
                        isEmpty = true;
                        break;
                    } else {
                        if (isReverse) dq.removeLast();
                        else dq.removeFirst();
                    }
                }
            }

            if (isEmpty) {
                System.out.println("error");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (!dq.isEmpty()) {
                //덱이 비어 있으면 []만 출력 하도록 확인 해준다.
                if (isReverse) {
                    sb.append(dq.pollLast());
                    while (!dq.isEmpty()) {
                        sb.append(",").append(dq.pollLast());
                    }
                } else {
                    sb.append(dq.pollFirst());
                    while (!dq.isEmpty()) {
                        sb.append(",").append(dq.pollFirst());
                    }

                }
            }
            sb.append("]");

            System.out.println(sb);


        }
    }
}
