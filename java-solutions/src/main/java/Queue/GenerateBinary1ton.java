package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinary1ton {
    public static void main(String[] args) {
        int n = 10; // Generate binary numbers up to 10

        System.out.println("Binary Numbers from 1 to " + n + ":");
        generateBinaryNumbers(n);
    }

    private static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");

        while( n > 0){
            String a = queue.poll();
            System.out.println(a);
           queue.offer(a + "0");
            queue.offer(a + "1");
            n--;

        }
    }
}
