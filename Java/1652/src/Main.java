import java.util.Scanner;

public class Main {

    public static int N;
    public static String St;
    public static int R = 0,D = 0;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        char [][] Map = new char[N][N];

        for(int i = 0; i < N; i++){
            St = scan.next();
            for(int j = 0; j < N; j++){
                Map[i][j] = St.charAt(j);
            }
        }

        for(int i = 0; i< N; i++){
            int cnt_D = 0;
            int cnt_R = 0;
            for(int j = 0; j < N; j++){
                if( Map[i][j] == '.'){
                    cnt_R++;
                }
                else if( Map[i][j] == 'X'){
                    if (cnt_R >= 2) R++;
                    cnt_R = 0;
                }

                if (Map[j][i] == '.'){
                    cnt_D++;
                }
                else if(Map[j][i] == 'X'){
                    if(cnt_D >= 2) D++;
                    cnt_D = 0;
                }
            }

        if (cnt_R >= 2) R++;
        if (cnt_D >= 2) D++;
        }
    System.out.println(R+" "+D);

    }
}
