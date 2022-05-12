import java.util.*;

public class Main {
    static ArrayList<Integer> Color = new ArrayList<>(Arrays.asList(0,0,0,0));
    static ArrayList<Integer> Number = new ArrayList<>();
    static ArrayList<Integer> Num = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0));

    static int result = 0;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);


        for(int i = 0; i< 5; i++){
            String C = scan.next();
            int N = scan.nextInt();

            switch (C){
                case "R": Color.set(0,Color.get(0)+1); break;
                case "G": Color.set(1,Color.get(1)+1); break;
                case "B": Color.set(2,Color.get(2)+1); break;
                case "Y": Color.set(3,Color.get(3)+1); break;
            }
            Number.add(N);
            Num.set(N,Num.get(N)+1);

        }
        Collections.sort(Number);
        Collections.reverse(Number);

        if((Number.get(0) - Number.get(4)) == 4 && check_color(Color)){
            result = Number.get(0) + 900;
        }
        else if(Num.contains(4)){
            result = Num.indexOf(4) + 800;
        }
        else if(Num.contains(3)){
            if(Num.contains(2)){
                result = (Num.indexOf(3) * 10) + Num.indexOf(2) + 700;
            }
            else{
                result = Num.indexOf(3) + 400;
            }
        }
        else if(check_color(Color)){
            result = Number.get(0) + 600;
        }
        else if((Number.get(0) - Number.get(4)) == 4){
            result = Number.get(0) + 500;
        }
        else if(Num.contains(2)){
            int sum = Num.indexOf(2);
            Num.set(Num.indexOf(2),0);
            if(Num.contains(2)){
                result = (Num.indexOf(2) * 10) + sum + 300;
            }
            else{
                result = sum + 200;
            }
        }
        else{
            result = Number.get(0) + 100;
        }
    System.out.println(result);
    }

    public static boolean check_color(ArrayList<Integer> color){// 같은색의 개수
        if(color.contains(5)) {
            return true;
        }
        else{
            return false;
        }
    }
}