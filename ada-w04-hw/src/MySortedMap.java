import java.util.Map;

/**
 * MySortedMap is a Map that provides a total ordering on its keys.
 * All keys inserted into a sorted map must implement the Comparable interface.
 *
 * The operations defined in MySortedMap emulate a subset of
 * the operations of java.util.SortedMap
 *
 * @param <Key> - the type of keys maintained by this SortedMap
 * @param <Value> - the type of values mapped to keys
 */
public interface MySortedMap <Key extends Comparable<Key>, Value>{

    /**
     * Searches if a key is contained in the Map.
     * @param key - the key to be searched
     * @return true if this map contains a mapping for the specified key
     */
    boolean containsKey(Key key);


    /**
     * Searches the associated value of a key.
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    Value get(Key key);

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a value for the key, the old value
     * is replaced by the specified value.
     * @param key - the new key
     * @param val - the new value
     */
    void put(Key key, Value val);

    /**
     * Removes the mapping containing given key from this map if it is present.
     * @param key - key whose mapping is to be removed
     */
    void remove(Key key);

    /**
     * @return all keys as an Iterable in ascending order
     */
    Iterable<Key> getKeys();

    /**
     * @return all entries (Key, Value) as an Iterable in ascending order of keys
     */
    Iterable<Map.Entry<Key,  Value>> getEntries();

}