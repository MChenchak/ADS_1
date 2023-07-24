package lessons.cache;

import java.lang.reflect.Array;
import java.util.Objects;

public class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    public int count;
    public int step;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.hits = new int[size];
        this.count = 0;
        this.step = 3;
    }

    public void put(String key, T value) {
        if (size == count) {
            int leastAccessedIndex = findleastAccessedIndex();
            slots[leastAccessedIndex] = key;
            values[leastAccessedIndex] = value;
            return;
        }

        int slot = seekSlot(key);
        slots[slot] = key;
        values[slot] = value;
        count++;
    }

    public int hashFun(String key) {
        if (key == null) {
            return 0;
        }
        int hash = 0;
        byte[] bytes = key.getBytes();
        for (byte b : bytes) {
            hash = hash + b;
        }
        return hash % size;
    }

    public T get(String key) {
        int hash = hashFun(key);

        if (Objects.equals(key, slots[hash])) {
            hits[hash]++;
            return values[hash];
        }

        hash = 0;

        while (hash < size) {
            if (Objects.equals(key, slots[hash])) {
                hits[hash]++;
                return values[hash];
            }
            hash++;
        }
        return null;
    }

    private int seekSlot(String key) {
        int hash = hashFun(key);

        if (slots[hash] != null && slots[hash].equals(key)) {
            return hash;
        }

        while (slots[hash] != null && hash <= size) {
            hash = hash + step;
            if (hash >= size) {
                hash = 0;
                step = 1;
            }
        }
        return hash;
    }

    private int findleastAccessedIndex() {
        int min = 0;

        for (int i = 0; i < hits.length; ++i) {
            if (hits[i] < hits[min]) {
                min = i;
            }
        }
        return min;
    }
}
