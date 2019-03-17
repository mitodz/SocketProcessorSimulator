import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 2\n" +
                "0 1\n" +
                "1 1");
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int time = 0;
        int dur = 0;
        Deque<Pair<Integer,Integer>> bQ = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int d = scanner.nextInt();
            bQ.addLast(new Pair<>(t,d));
            //if (bQ.size()<b && i < n - 1) continue;
            if (!bQ.isEmpty()) {
                Pair<Integer, Integer> temp = bQ.pollFirst();
                if (t<time) {
                    System.out.println(-1);
                    continue;
                }
                time += temp.getKey() + dur;
                dur = temp.getValue();
                System.out.println(time);
            }

        }

    }
}
