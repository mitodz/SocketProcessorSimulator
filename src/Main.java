import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 25\n" +
                "16 0\n" +
                "29 3\n" +
                "44 6\n" +
                "58 0\n" +
                "72 2\n" +
                "88 8\n" +
                "95 7\n" +
                "108 6\n" +
                "123 9\n" +
                "139 6\n" +
                "152 6\n" +
                "157 3\n" +
                "169 3\n" +
                "183 1\n" +
                "192 0\n" +
                "202 8\n" +
                "213 8\n" +
                "229 3\n" +
                "232 3\n" +
                "236 3\n" +
                "239 4\n" +
                "247 8\n" +
                "251 2\n" +
                "267 7\n" +
                "275 7");
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int time = 0;
        int dur = 0;
        Deque<HashMap.Entry<Integer,Integer>> bQ = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int d = scanner.nextInt();
            if (t<time) {
                System.out.print(-1 + " ");//ФИНАЛЬНЫЙ РЕЗУЛЬТАТ С НОВОЙ СТРОКИ!!!
                continue;
            }
            bQ.addLast(new HashMap.SimpleEntry<>(t,d));
            if (bQ.size()<b && i < n - 1) continue;
            while (!bQ.isEmpty()) {
                HashMap.Entry<Integer, Integer> temp = bQ.pollFirst();
                //time += temp.getKey() + dur;
                time = temp.getKey() + dur;
                System.out.print(time + " ");//ФИНАЛЬНЫЙ РЕЗУЛЬТАТ С НОВОЙ СТРОКИ!!!
                dur = temp.getValue();
                time = temp.getKey() + dur;
                //16 29 44 58 72 88 -1 108 123 139 152 -1 169 183 192 202 213 229 232 236 239 247 -1 267 275
            }

        }
    }
}
