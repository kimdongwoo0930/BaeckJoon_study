import java.util.Scanner;

public class Main {

    static int Number;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sum = 0;
        int first;
        int cnt = 0;

        first = N;

        while(true){
            if(N < 10){
                sum = N;
                Number = (N * 10) + sum;
            }
            else{
                sum = (N / 10) + (N % 10);
                Number = ((N % 10)*10) + (sum % 10);
            }
            N = Number;
            cnt++;
            if(Number == first) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
