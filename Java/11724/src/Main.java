import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer>[] point;
    public static ArrayList<Integer> visit;
    public static int start = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] D = br.readLine().split(" ");
        int N = Integer.parseInt(D[0]);
        int K = Integer.parseInt(D[1]);
        point = new ArrayList[N+1];
        visit = new ArrayList<>();
        int count = 0;

        for(int i = 0;i<N+1;i++){
            point[i] = new ArrayList<>();
            visit.add(0);
        }
        for(int i=0;i<K;i++){
            D = br.readLine().split(" ");
            point[Integer.parseInt(D[0])].add(Integer.parseInt(D[1]));
            point[Integer.parseInt(D[1])].add(Integer.parseInt(D[0]));
        }


        for(int k = 1; k< N+1;k++){
            if (visit.get(k) == 0){
                dfs(k);
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start){
        visit.set(start,1);
        for(int i: point[start]){
            if(visit.get(i).equals(0)){
                dfs(i);
            }
        }
    }
}
