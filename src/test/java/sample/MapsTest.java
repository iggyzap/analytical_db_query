package sample;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MapsTest {

    private DbQuery toTest = new DbEngineImpl();

    public static <K, V> Map<K, V> of() {
        return new HashMap<K, V>();
    }

    public static <K, V> Map<K, V> of(K k1, V v1) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2, K k3, V v3) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }



    @Test
    public void testMinByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(
                MapsTest.of("a", 1, "b", 2),
                MapsTest.of("a", 2)
        );
        List<Map<String, Integer>> example2 = Arrays.asList(example1.get(1), example1.get(0));
        List<Map<String, Integer>> example3 = Arrays.asList(MapsTest.of());
        List<Map<String, Integer>> example4 = Arrays.asList(
                MapsTest.of("a", -1),
                MapsTest.of("b", -1)
        );

        System.out.println("minByKey");
        assertEquals(example1.get(0), toTest.minByKey("a", example1));
        assertEquals(example2.get(1), toTest.minByKey("a", example2));
        assertEquals(example1.get(1), toTest.minByKey("b", example1));
        assertEquals(example3.get(0), toTest.minByKey("a", example3));
        assertEquals(example4.get(1), toTest.minByKey("b", example4));
    }

    @Test
    public void testFirstByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(MapsTest.of("a", 1));
        List<Map<String, Integer>> example2 = Arrays.asList(
                MapsTest.of("b", 1),
                MapsTest.of("b", -2),
                MapsTest.of("a", 10)
        );
        List<Map<String, Integer>> example3 = Arrays.asList(
                MapsTest.of(),
                MapsTest.of("a", 10, "b", -10),
                MapsTest.of(),
                MapsTest.of("a", 3, "c", 3)
        );

        System.out.println("firstByKey");
        assertEquals(example1.get(0), toTest.firstByKey("a", "asc", example1));
        assertEquals(example2.get(0), toTest.firstByKey("a", "asc", example2));  // example2.get(1) ok too
        assertEquals(example2.get(2), toTest.firstByKey("a", "desc", example2));
        assertEquals(example2.get(1), toTest.firstByKey("b", "asc", example2));
        assertEquals(example2.get(0), toTest.firstByKey("b", "desc", example2));
        assertEquals(example3.get(1), toTest.firstByKey("a", "desc", example3));
    }

}
