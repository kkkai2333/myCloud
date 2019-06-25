package my.cloud.hashmap.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapInfiniteLoop {

    static Map<Integer, String> map = new HashMap<>(2, 0.75F);

    public static void main(String[] args) {

        map.put(1, "tom");
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(2, "jack");
                System.out.println(map.get(1));
            }
        }, "thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(3, "holmes");
                System.out.println(map.get(1));
            }
        }, "thread-2").start();
    }
}
