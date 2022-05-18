import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int X,Y;

    static int count;
    static int[][] Map;
    static boolean[][] visit;
    static int[] d = {-1,1,0,0};
    static int[] r = {0,0,-1,1};


    public static void dfs(int x,int y){
        visit[x][y] = true;

        for(int i = 0;  i < 4; i++){
            int nr = x + r[i];
            int nd = y + d[i];

            if(nr>=0 && nd >= 0 && nr < X && nd < Y){
                if(Map[nr][nd] == 1 && !visit[nr][nd]){
                    dfs(nr,nd);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        for(int i=0; i < T; i++){
            String[] D = br.readLine().split(" ");
            Map = new int[Integer.parseInt(D[0])][Integer.parseInt(D[1])];
            visit = new boolean[Integer.parseInt(D[0])][Integer.parseInt(D[1])];

            X = Integer.parseInt(D[0]);
            Y = Integer.parseInt(D[1]);
            count = 0;


            for(int j = 0; j < Integer.parseInt(D[2]); j++ ){
                String[] L = br.readLine().split(" ");
                Map[Integer.parseInt(L[0])][Integer.parseInt(L[1])] = 1;
            }


            for(int l = 0; l < Integer.parseInt(D[0]); l++){
                for(int k = 0;k<Integer.parseInt(D[1]); k++){
                    if(Map[l][k] == 1 && !visit[l][k]) {

                        dfs(l, k);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }

    }
}
