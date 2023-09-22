import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//[그리디] 강의실 배정

class Class{
    int start;
    int end;

    Class(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Main_11000 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        Class[] classes = new Class[N];
        for (int i=0; i<N; i++){
            int start = s.nextInt();
            int end = s.nextInt();
            classes[i] = new Class(start, end);
        }

        Arrays.sort(classes, (c1, c2) -> c1.start == c2.start ? c1.end - c2.end : c1.start - c2.start);

        PriorityQueue<Integer> end = new PriorityQueue<>();
        end.offer(classes[0].end);

        for (int i=1; i<N; i++){
            if (end.peek() <= classes[i].start){
                end.poll();
            }
            end.offer(classes[i].end);
        }

        System.out.println(end.size());


    }
}

//물론 강의가 있을 때마다 강의실을 내줄 수 있겠지만 그것은 최적의 답이 아니다. 강의 시간에 맞춰 최소의 강의실을 내주도록 만들자!
//
//1. 주어진 강의 시간들을 오름차순으로 정렬해준다. 만약 시작 시간이 같으면 끝나는 시간 순으로 정렬해준다.
//(4 / 9) , (4 / 8) -> (4 / 8) , (4 / 9)

//2. 우선순위 큐를 사용하여 끝나는 시간을 추가해주고, 다음 강의의 시작하는 시간과 비교하여 해당 강의실에서 진행할 수 있는지를 판단하고,
// 진행 가능 하다면 끝나는 시간을 업데이트 해준다.
//우선순위큐 -> 3 / 5 / 7
//다음 강의가 ( 4 / 8 ) 이라면 3시에 끝나는 강의실에서 이어서 진행할 수 있으므로 그 다음 우선순위 큐는 5 / 7 / 8 의 형태가 된다.
//다음 강의가 오름차순 이므로 ( 4 / 9 ) 이라면 해당 강의 시작
//시간이 우선순위큐에 있는 끝나는 시간보다 이르므로 새로운 강의실을 사용해야한다!
//그렇다면 마지막 우선순위큐는 5 / 7 / 8 / 9 의 형태가 된다.

//3. 우선순위큐의 크기는 사용하는 강의실의 개수가 되므로 해당 크기를 출력해준다.