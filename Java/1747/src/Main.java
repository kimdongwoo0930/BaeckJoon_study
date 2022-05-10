import java.util.Scanner;

public class Main {

    private static int N;
    private static int result = 0;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        for(int i = N; i < 1000001; i++){
            if (i == 1) continue;
            if (pelindrom(i)){
                if(Prime_Number(i)){
                    result = i;
                    break;
                }
            }
        }

        if(result == 0) result = 1003001;

        System.out.println(result);


    }

    public static boolean Prime_Number(int Num){
        if (Num == 1) return false;
        for(int i = 2; i < Num; i++){
            if (Num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean pelindrom(int Num) {
        String Number = Integer.toString(Num);

        for(int i=0; i < Number.length() / 2; i++){
            if(Number.charAt(i) != Number.charAt(Number.length() -i -1)){
                return false;
            }
        }
        return true;
    }
}
