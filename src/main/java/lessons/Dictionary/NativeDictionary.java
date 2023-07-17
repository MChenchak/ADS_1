package lessons.Dictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int step;
    public int count;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        step = 3;
        count = 0;
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

    public boolean isKey(String key) {
        return get(key) != null;
    }

    public void put(String key, T value) {

        if (size == count) {
            return;
        }

        int slot = seekSlot(key);
        if (key != slots[slot]) {
            count++;
        }
        if (slot > -1) {
            slots[slot] = key;
            values[slot] = value;
        }


    }

    public T get(String key) {
        int hash = hashFun(key);

        if (key == slots[hash]) {
            return values[hash];
        }

        hash = 0;

        while (hash < size) {
            if (key == slots[hash]) {
                return values[hash];
            }
            hash++;
        }

        return null;
    }

    private int seekSlot(String key) {
        int hash = hashFun(key);

        if (slots[hash] == key) {
            return hash;
        }

        while (slots[hash] != null && hash <= size) {
            hash = hash + step;
            if (hash >= size) {
                hash = 0;
                step = 1;
            }
        }

        if (slots[hash] == null) {
            return hash;
        }

        return -1;
    }
}