import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int count1 = 0;
    static int count2 = 0;
    static int N;
    static int[] R = {0, 0, -1, 1};
    static int[] D = {1, -1, 0, 0};
    static String[][] photo;
    static String[][] photo2;
    static boolean[][] visit;
    static boolean[][] visit2;


    public static void dfs(int x, int y, boolean[][] bool, String[][] Photo, String Color) {
        bool[x][y] = true;

        for (int M = 0; M < 4; M++) {
            int Cx = x + R[M];
            int Cy = y + D[M];
            if (Cx >= 0 && Cy >= 0 && Cx < N && Cy < N) {
                if (!bool[Cx][Cy] && Photo[Cx][Cy].equals(Color)) {
                    dfs(Cx, Cy, bool, Photo, Color);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        photo = new String[N][N];
        photo2 = new String[N][N];
        visit = new boolean[N][N];
        visit2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] D = br.readLine().split("");
            photo[i] = D;
            for (int j = 0; j < N; j++) {
                if (D[j].equals("G")) photo2[i][j] = "R";
                else photo2[i][j] = D[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, visit, photo, photo[i][j]);
                    count1++;
                }
                if (!visit2[i][j]) {
                    dfs(i, j, visit2, photo2, photo2[i][j]);
                    count2++;

                }
            }
        }
        System.out.println(count1 + " " + count2);
        }
    }
