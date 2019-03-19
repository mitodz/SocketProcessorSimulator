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
        int j=0;//счётчик для первоначального заполнения буфера
        int time = 0;
        Deque<HashMap.Entry<Integer,Integer>> bQ = new ArrayDeque<>();//очередь в буффере
        while (bQ.size()<b && j<n) { //первоначальное заполнение буфера с запоминанием счётчика
            int t = scanner.nextInt();
            int d = scanner.nextInt();
            //System.out.print(time + " ");//ФИНАЛЬНЫЙ РЕЗУЛЬТАТ С НОВОЙ СТРОКИ!!!
            bQ.addLast(new HashMap.SimpleEntry<>(t,d));
            j++;
        }
        //логика - если новый элемент пытается попасть в буфер после окончания обработки первого, то норм)

        while (!bQ.isEmpty()) {
            HashMap.Entry<Integer, Integer> temp = bQ.pollFirst();
            if (temp.getKey() == -1){
                System.out.print(-1 + " ");
                continue;
            } else if (temp.getKey() > time){
                time = temp.getKey();
                System.out.print(time + " ");//ФИНАЛЬНЫЙ РЕЗУЛЬТАТ С НОВОЙ СТРОКИ!!!
                time += temp.getValue();
            }
            else {
                time = time;
                System.out.print(time + " ");//ФИНАЛЬНЫЙ РЕЗУЛЬТАТ С НОВОЙ СТРОКИ!!!
                time += temp.getValue();
            }
            while (scanner.hasNext()) {
                int t = scanner.nextInt();
                int d = scanner.nextInt();
                if (t<time ) {
                    bQ.addLast(new HashMap.SimpleEntry<>(-1, d));
                } else {
                    //time=t;
                    bQ.addLast(new HashMap.SimpleEntry<>(t, d));
                    break;
                }
            }
                //16 29 44 58 72 88 -1 108 123 139 152 -1 169 183 192 202 213 229 232 236 239 247 -1 267 275
        }
    }
}
