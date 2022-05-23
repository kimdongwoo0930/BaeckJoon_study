
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int MX,MY,X,Y;
    static int area = 0;
    static ArrayList<Integer> areas = new ArrayList<>();

    static int[] RX= {-1,1,0,0};
    static int[] DY = {0,0,-1,1};
    static boolean[][] Map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] D = br.readLine().split(" ");
        Map = new boolean[Integer.parseInt(D[0])][Integer.parseInt(D[1])];
        MX = Integer.parseInt(D[1]);
        MY = Integer.parseInt(D[0]);
        visit = new boolean[Integer.parseInt(D[0])][Integer.parseInt(D[1])];
        for(int K = 0;K<Integer.parseInt(D[2]);K++){
            String[] L = br.readLine().split(" ");
            for(int i=Integer.parseInt(L[0]);i<Integer.parseInt(L[2]);i++){
                for(int j= Integer.parseInt(L[3])-1;j>= Integer.parseInt(L[1]);j--){
                    Map[MY-1-j][i] = true;
                }
            }
        }
        for(int i = 0; i< MY;i++){
            for(int j = 0; j<MX;j++){
                if(!visit[i][j] && !Map[i][j]){
                    area = 0;
                    dfs(j,i);
                    area++;
                    areas.add(area);
                }
            }
        }
        Collections.sort(areas);
        System.out.println(areas.size());
        for(int i : areas) System.out.print(i+" ");
        //System.out.println(Arrays.deepToString(Map));
        //dfs
    }



    static void dfs(int x,int y){
        visit[y][x] = true;

        for(int i = 0;i< 4;i++){
            X = x + RX[i];
            Y = y + DY[i];

            if(X >= 0 && Y >= 0 && X < MX && Y < MY) {
                if (!visit[Y][X] && !Map[Y][X]) {
                    dfs(X,Y);
                    area++;
                }
            }
        }
    }
}
