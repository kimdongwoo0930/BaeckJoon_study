import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] B = br.readLine().split(" ");
        int N = Integer.parseInt(B[0]);
        String K = B[1];
        String num = "";
        int score = 0;
        int cnt = 1;


        for(int i = 0; i < N; i++){
            String[] L = br.readLine().split(" ");

            for(int j = 1; j < 4; j++){
                num += L[j];
            }
            if(L[0].equals(K)) {
                score = Integer.parseInt(num);
            }
            list.add(Integer.parseInt(num));
            num = "";
        }
        for(int i=0;i<N;i++){
            if(list.get(i) > score){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
