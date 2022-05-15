import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] com;
    static boolean[] visit;
    static int count = 0;
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        com = new int[N+1][N+1];
        visit= new boolean[N+1];

        for(int i=0;i<K;i++){
            String[] D = br.readLine().split(" ");
            com[Integer.parseInt(D[0])][Integer.parseInt(D[1])] = 1;
            com[Integer.parseInt(D[1])][Integer.parseInt(D[0])] = 1;
        }

        dfs(1);
        System.out.println(count-1);

    }
    public static void dfs(int start){
        visit[start] = true;
        count++;
        for(int i=1;i<N+1;i++){
            if(com[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }
}
