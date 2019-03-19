import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int j=0;//счётчик для первоначального заполнения буфера
        int time = 0;
        Deque<HashMap.Entry<Integer,Integer>> bQ = new ArrayDeque<>();//очередь в буффере
        while (bQ.size()<b && j<n) { //первоначальное заполнение буфера с запоминанием счётчика
            int t = scanner.nextInt();
            int d = scanner.nextInt();
            bQ.addLast(new HashMap.SimpleEntry<>(t,d));
            j++;
        }

        while (!bQ.isEmpty()) {
            HashMap.Entry<Integer, Integer> temp = bQ.pollFirst();
            if (temp.getKey() == -1){
                System.out.println(-1);
                continue;
            } else if (temp.getKey() > time){
                time = temp.getKey();
                System.out.println(time);
                time += temp.getValue();
            }
            else {
                time = time;
                System.out.println(time);
                time += temp.getValue();
            }
            while (scanner.hasNext()) {
                int t = scanner.nextInt();
                int d = scanner.nextInt();
                if (t<time ) {
                    bQ.addLast(new HashMap.SimpleEntry<>(-1, d));
                } else {
                    bQ.addLast(new HashMap.SimpleEntry<>(t, d));
                    break;
                }
            }
            //16 29 44 58 72 88 -1 108 123 139 152 -1 169 183 192 202 213 229 232 236 239 247 -1 267 275
            //6 29 73 101 116 123 164 189 194 208 216 259 270 295 322 362 -1 381 -1 -1 -1 404 420 461 484
            //10 47 92 116 133 176 206 218 246 291 301 347 351 367 368 409 409 431 -1 -1 432 443 -1 473 -1
            //5 16 30 47 69 105 118 126 138 159 197 215 230 243 274 274 323 331 361 398 447 478 503 534 570
            //11 56 78 102 151 190 193 194 199 229 266 278 284 317 -1 337 -1 -1 344 353 390 408 411 -1 -1
            //0 21 56 68 81 92 106 155 188 -1 231 245 290 -1 -1 328 -1 -1 -1 -1 -1 -1 -1 -1 -1
            //15 -1 39 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 84 -1 -1 -1 -1 -1 -1 -1 142 -1 -1 -1
        }
    }
}
