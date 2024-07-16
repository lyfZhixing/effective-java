package extend.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap 容量
 */
public class HashMapCapacity {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        mapSize15();
    }

    static void mapSize15() {
//        HashMap.tableSizeFor(15);

        System.out.println(tableSizeFor(15));

    }

    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
