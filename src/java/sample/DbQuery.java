package sample;

import java.util.List;
import java.util.Map;

public interface DbQuery {

    Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records);

    /**
     *
     1. a string key
     2. a string sort direction (which must be either "asc" or "desc")
     3. an array of records, just as in min_by_key.

     If the sort direction is "asc", then we should return the minimum record,
     otherwise we should return the maximum record. As before, records without a
     value for the key should be treated as having value 0.

     * @param key
     * @param direction
     * @param records
     * @return
     */
    Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records);
}
