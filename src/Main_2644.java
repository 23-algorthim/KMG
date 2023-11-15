import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2644 {
    static List<Integer>[] r;
    static int[] visited;
    static int n,m,x,y;
    static int res=-1;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        x = s.nextInt();
        y = s.nextInt();
        m = s.nextInt();
        r = new ArrayList[n+1];
        visited = new int[n+1];
        for (int i=0; i<n+1; i++){
            visited[i] = 0;
            r[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            int parent = s.nextInt();
            int child = s.nextInt();
            r[parent].add(child);
            r[child].add(parent);
        }

        dfs(x,y,0);
        System.out.println(res);

    }

    private static void dfs(int x, int y, int cnt) {
        if (x==y) {
            res = cnt;
            return;
        }
        visited[x] = 1;
        for (int i=0; i<r[x].size(); i++){
            int next = r[x].get(i);
            if(visited[next]!=1){
//                dfs(next,y,cnt+1);
                //????????????????????????????????
                cnt+=1;
                dfs(next,y,cnt);
            }
        }
    }
}
