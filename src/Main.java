import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("11 25\n" +
                "6 23\n" +
                "15 44\n" +
                "24 28\n" +
                "25 15\n" +
                "33 7\n" +
                "47 41\n" +
                "58 25\n" +
                "65 5\n" +
                "70 14\n" +
                "79 8\n" +
                "93 43\n" +
                "103 11\n" +
                "110 25\n" +
                "123 27\n" +
                "138 40\n" +
                "144 19\n" +
                "159 2\n" +
                "167 23\n" +
                "179 43\n" +
                "182 31\n" +
                "186 7\n" +
                "198 16\n" +
                "208 41\n" +
                "222 23\n" +
                "235 26");
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
            } else if (temp.getKey() > time){
                time = temp.getKey();
            }
            else {
                time = time;
            }
            System.out.print(time + " ");//ФИНАЛЬНЫЙ РЕЗУЛЬТАТ С НОВОЙ СТРОКИ!!!
            time += temp.getValue();
            if (scanner.hasNext()) {
                int t = scanner.nextInt();
                int d = scanner.nextInt();
                if (t>temp.getKey()) {
                    bQ.addLast(new HashMap.SimpleEntry<>(-1, d));
                } else bQ.addLast(new HashMap.SimpleEntry<>(t, d));
            }
                //16 29 44 58 72 88 -1 108 123 139 152 -1 169 183 192 202 213 229 232 236 239 247 -1 267 275
                //6 29 73 101 116 123 164 189 194 208 216 259 270 295 322 362 -1 381 -1 -1 -1 404 420 461 484
        }
    }
}
