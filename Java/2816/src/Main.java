import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> CH_list;
    static int select = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String anw = "";
        String tmp;
        CH_list = new ArrayList<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String X = sc.next();
            X.toUpperCase();
            if (X.length() > 11) {
                X = X.substring(0, 11);
            }
            CH_list.add(X);
        }
        while (true){
            if (CH_list.get(0).equals("KBS1") && CH_list.get(1).equals("KBS2")) {
                break;
            } else if (!CH_list.get(0).equals("KBS1")) {
                if (CH_list.get(select).equals("KBS1")) {
                    tmp = CH_list.get(select);
                    CH_list.set(select, CH_list.get(select - 1));
                    CH_list.set(select - 1, tmp);
                    anw += '4';
                    select -= 1;
                } else if (!CH_list.get(select).equals("KBS1")) {
                    select += 1;
                    anw += '1';
                }
            } else if (!(CH_list.get(0).equals("KBS1") && CH_list.get(1).equals("KBS2"))) {
                if (CH_list.get(select).equals("KBS2")){
                    tmp = CH_list.get(select);
                    CH_list.set(select, CH_list.get(select - 1));
                    CH_list.set(select - 1, tmp);
                    anw += '4';
                    select -= 1;
                } else if (!CH_list.get(select).equals("KBS2")) {
                    select += 1;
                    anw += '1';
                }
            }
        }
        System.out.println(anw);
    }
}