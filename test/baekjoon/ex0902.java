package baekjoon;

import com.sun.istack.internal.NotNull;
import javafx.util.Pair;

import java.util.ArrayList;

public class ex0902 {
    ArrayList<Integer> list = new ArrayList<Integer>();
    @NotNull
    public Pair run(int a, int b){


/*
        int sum = 0;

        for (int i = a; i <= b; i++) {
            if(isPrime(i)) {
                list.add(i);
                sum += i;
            }
        }

        // 소수가 없으면 -1 리턴
        if(list.size() == 0) {
            System.out.println("-1");
            return;
        }
        else{
            list.sort(null);
        }

        System.out.println(sum);
        System.out.println(list.get(0));*/

        return new Pair(1, 2);
    }

    public static boolean isPrime(int value) {

        // 1은 소수가 아니다. 따라서 세지않는다
        if (value == 1) {
            return false;
        }

        // 소수는 2~자기자신의수 -1 까지 나눌때 나머지가 무조건 발생한다.
        // 따라서 나머지가 발생하지않으면 소수가 아니므로 세지않는다.
        for (int j = 2; j <= value - 1; j++) {
            if (value % j == 0) {
                return false;
            }
        }
        return true;
    }
}
