package sample;

import com.google.common.collect.Streams;

import java.util.List;
import java.util.Map;

public class DbEngineImpl implements DbQuery {


    @Override
    public Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {


        return firstByKey (key, Comparison.ASC, records);
    }

    private Map<String, Integer> firstByKey(String key, Comparison direction, List<Map<String, Integer>> records) {
        Map<String, Integer> result = null;
        Integer minimal = null;

        for (Map<String, Integer> map : records) {
            Integer other = map.get(key);
            if (direction.compare(minimal, other)) {
                minimal = map.getOrDefault(key, 0);
                result = map;
            }
        }


        return result;

    }

    @Override
    public Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
        return firstByKey(key, Comparison.valueOf(direction.toUpperCase()), records);
    }

    enum Comparison {
        ASC {
            @Override
            boolean compare(Integer current, Integer other) {
                if (other == null) {
                    other = 0;
                }
                if (current == null) {
                    return true;
                }
                return current > other;
            }
        },
        DESC {
            @Override
            boolean compare(Integer current, Integer other) {
                if (other == null) {
                    other = 0;
                }
                if (current == null) {
                    return true;
                }
                return current < other;
            }
        };

        abstract boolean compare (Integer current, Integer other);
    }


}
