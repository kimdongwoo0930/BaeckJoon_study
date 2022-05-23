import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N,X,Y;
    static int count = 0;
    static int[][] Map;
    static boolean[][] visit;
    static int[] RX = {0,0,-1,1};
    static int[] DY = {1,-1,0,0};
    static ArrayList<Integer> areas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        visit = new boolean[N][N];
        for(int i = 0;i < N; i++){
            String[] L = br.readLine().split("");
            for(int j = 0; j< L.length;j++){
                Map[i][j] = Integer.parseInt(L[j]);
            }
        }
        //System.out.println(Arrays.deepToString(Map));
        for(int i = 0;i<N;i++){
            for(int j = 0; j< N;j++){
                if(!visit[i][j] && Map[i][j] == 1){
                    count = 0;
                    dfs(j,i);
                    count++;
                    areas.add(count);
                }
            }
        }
        System.out.println(areas.size());
        Collections.sort(areas);
        for(int i : areas){
            System.out.println(i);
        }
        //dfs
    }

    static void dfs(int x, int y){
        visit[y][x] = true;

        for(int k =0;k<4;k++){

            X = RX[k] + x;
            Y = DY[k] + y;
            if(X >= 0 && Y >= 0 && X< N && Y < N && !visit[Y][X] && Map[Y][X] == 1){
                dfs(X,Y);
                count++;
            }
        }
    }

}
